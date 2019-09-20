package com.control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> map = new HashMap<String, Object>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String propertyConfig = config.getInitParameter("config"); // <param-value> 값을 가져온다. 
		
		FileInputStream fis = null; //파일 읽어오기
		Properties properties = new Properties(); // 외부에서 설정한 환경설정 파일을 보관할 장소
		
		try {
			fis = new FileInputStream(propertyConfig); //propertyConfig에 있는 파일을 가져와
			properties.load(fis); // properties에 전부 보관 
			System.out.println("properties: "+ properties);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { // IOException (부모) / FileNotFoundException (자식): IOE를 먼저 잡으면 에러!
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Iterator it = properties.keySet().iterator(); // properties 안에 있는 내용을 Set[순서없음, 중복 불가]에 보관하고, iterator 생성. 
		while(it.hasNext()) { //현재 위치에 항목이 있는지 체크 (T/F)
			String key = (String) it.next(); //현재 위치의 항목을 꺼내주고 다음으로 이동. '=' 연산자를 기준으로 앞부분만 모두 꺼내온다. 
			String className = properties.getProperty(key);
			
			System.out.println("key: " + key);
			System.out.println("className: " + className);
			
			//className의 타입이 무엇인지 모르니, 전체를 포괄하는 'Class' 객체에 담는다. 
			try {
				Class classType = Class.forName(className);
				Object ob = classType.newInstance(); // object 타입으로 클래스 객체 생성. 
				System.out.println("ob: " + ob);
				
				map.put(key, ob); // 객체를 map에 보관. 
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}
	
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("POST")) request.setCharacterEncoding("UTF-8");
		
		String category = request.getServletPath(); // 전체주소 (http://localhost:8080/miniProject/main/index.do) 에서, 프로젝트명 이하(/main/index.do) 부분만 잘라서 가져온다.
		CommandProcess cp = (CommandProcess) map.get(category); //부모인 CommandProcess로 받아야 implement - override 가능 (NOT Object!)
		
		System.out.println("category :" + category);
		System.out.println("cp: " + cp);
		
		String view = null;
		try {
			view = cp.requestPro(request, response); //호출
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response); //forward방식으로 제어권 넘기기
	}
	
	
}

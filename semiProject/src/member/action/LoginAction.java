package member.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String rememberMe = request.getParameter("rememberMe");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		MemberDTO memberDTO = MemberDAO.getInstance().isLogin(map);
		
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		if(memberDTO != null) {
			session.setAttribute("memDTO", memberDTO); // 로그인 세션(브라우저가 꺼지면 만료됨)을 주고
			session.setAttribute("memId", memberDTO.getId());
			
			if(rememberMe.equals("true")) { // 자동로그인
				Cookie cookie = new Cookie("remember", memberDTO.getId()); //자동로그인 쿠키에 sessionID 값을 넣어놓는다. 
				cookie.setMaxAge(60*60*24*7); //7일
				cookie.setPath("/");
				response.addCookie(cookie);
				
				Date sessionLimit =new Date(System.currentTimeMillis() + (1000*60*60*24*7)); //7일
				System.out.println("자동 로그인 쿠키, 세션 한도 생성");
				
				System.out.println("cookie: "+ cookie.getName() + "/ " + cookie.getValue());
				
				map.put("id", memberDTO.getId());
				map.put("sessionId",  memberDTO.getId());
				map.put("sessionLimit", sessionLimit);
				
				MemberDAO.getInstance().keepLogin(map); // 해당 아이디에 자동로그인 쿠키, 세션 한도값 업데이트
				
			}
		}
		
		request.setAttribute("memberDTO", memberDTO);
	
		return "/member/islogin.jsp";
	}
	
	
	public void loginProcess(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
	}
}

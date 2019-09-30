package main.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class IndexAction implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
	//	Object object = session.getAttribute("memDTO");
	
		
		//처음 들어왔을 때 세션 값이 없으면 => 자동로그인 여부 체크
		
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for (Cookie cookie : cookies) {
					if(cookie.getName().equals("remember")) {
						String sessionId = cookie.getValue();
						System.out.println("자동 로그인 cookie: "+ cookie.getName() + "/" + sessionId);
						
						MemberDTO memberDTO = MemberDAO.getInstance().checkUserWithSessionId(sessionId);
						session.setAttribute("memDTO", memberDTO);
						
					}
					//if - 자동로그인 여부값이 있으면 
				} // for: cookie
				
			}
			
	
		
		request.setAttribute("display", "/template/body.jsp");
		return "/main/index.jsp";
	}

}

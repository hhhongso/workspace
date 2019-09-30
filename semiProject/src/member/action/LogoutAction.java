package member.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

public class LogoutAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//세션, 쿠키 죽이기 
		HttpSession session = request.getSession();
		session.invalidate();
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {	
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
				System.out.println("쿠키 죽이기");
			}
		}
	
		
		//request.setAttribute("display", "/member/logout.jsp");
		
		return "/member/logout.jsp";
	}

}

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
		
		Cookie[] cookie = request.getCookies();
		for (int i = 0; i < cookie.length; i++) {
			if(cookie[i].getName().equals("memId")){
				cookie[i].setMaxAge(0);
				response.addCookie(cookie[i]);
				System.out.println("쿠키 죽이기");
			}
		}
		
		//request.setAttribute("display", "/member/logout.jsp");
		
		return "/member/logout.jsp";
	}

}

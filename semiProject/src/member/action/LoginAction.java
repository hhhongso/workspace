package member.action;

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
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		MemberDTO memberDTO = MemberDAO.getInstance().isLogin(map);
		
		HttpSession session = request.getSession();
		if(memberDTO != null) {
			session.setAttribute("memDTO", memberDTO); // 세션을 주고
			session.setAttribute("memId", memberDTO.getId());
			if(rememberMe.equals("true")) { // 자동로그인
				Cookie cookie = new Cookie("memId", memberDTO.getId());
				cookie.setMaxAge(60*60*24*7); //7일
				response.addCookie(cookie);
				System.out.println("쿠키생성");
			}
		}
		
		
		request.setAttribute("memberDTO", memberDTO);
	
		return "/member/islogin.jsp";
	}

}

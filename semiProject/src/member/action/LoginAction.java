package member.action;

import java.util.HashMap;
import java.util.Map;

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
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		MemberDTO memberDTO = MemberDAO.getInstance().isLogin(map);
		
		if(memberDTO != null) { //세션을 주고
			HttpSession session = request.getSession();
			session.setAttribute("memDTO", memberDTO);
		}
		
		request.setAttribute("memberDTO", memberDTO);
	
		return "/member/islogin.jsp";
	}

}

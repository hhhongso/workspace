package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import memberJSP.bean.MemberDTO;
import memberJSP.dao.MemberDAO;

public class LoginAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터 받기 
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//DB
		MemberDTO memberDTO = MemberDAO.getinstance().isLogin(id, pwd);
		//응답
		if(memberDTO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", memberDTO.getId());
			session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
			return "/member/loginOK.jsp";
		}
		else return "/member/loginFail.jsp";
	}

}

package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class SignupAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//ajax로 보낸다면?  ==> Spring
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		int birthYear = Integer.parseInt(request.getParameter("birthYear"));
		int birthMonth = Integer.parseInt(request.getParameter("birthMonth"));
		int birthDay = Integer.parseInt(request.getParameter("birthDay"));
		
		MemberDTO memberDTO = new MemberDTO(name, id, pwd, email1, email2, birthYear, birthMonth, birthDay);
		
		//DB
		MemberDAO.getInstance().insertMember(memberDTO);
		//응답
		//request.setAttribute("display", "/member/signup.jsp");
		
		return "/member/signup.jsp";
	}

}

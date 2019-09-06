package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import memberJSP.dao.MemberDAO;

public class CheckIdAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터 받기
		String id = request.getParameter("id");
		
		//DB
		boolean isDup = MemberDAO.getinstance().isDuplicate(id);
		
		//응답
		request.setAttribute("id", id);
		if(!isDup) return "/member/checkIdOk.jsp";
		else return "/member/checkIdFail.jsp";
	}

}

package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class CheckIdDupAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String checkId = request.getParameter("id");
		
		boolean isDup = MemberDAO.getinstance().isDuplicate(checkId);
		request.setAttribute("isDup", isDup); 
		return "/member/checkIdDup.jsp";
	}

}

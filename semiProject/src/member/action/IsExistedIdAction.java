package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class IsExistedIdAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String id = request.getParameter("id");
		
		//DB
		boolean isExisted = MemberDAO.getInstance().isExistedId(id);

		request.setAttribute("isExisted", isExisted);

		return "/member/isExistedId.jsp";
	}

}

package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardReplyFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int pg = Integer.parseInt(request.getParameter("pg"));
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		
		request.setAttribute("pg", pg);
		request.setAttribute("pseq", pseq);
		request.setAttribute("display", "/board/boardReplyForm.jsp");
		
		return "/main/index.jsp";
	}

}

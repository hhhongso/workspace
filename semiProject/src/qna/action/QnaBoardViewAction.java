package qna.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import qna.bean.QnADTO;
import qna.dao.QnADAO;

public class QnaBoardViewAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int seq = Integer.parseInt(request.getParameter("seq")); 
		int pg =  Integer.parseInt(request.getParameter("pg")); 
		
		QnADTO qnaDTO = QnADAO.getInstance().getQnAView(seq);
		
		request.setAttribute("qnaDTO", qnaDTO);
		request.setAttribute("display", "/qna/qnaBoardView.jsp");
		return "/main/index.jsp";
	}

}

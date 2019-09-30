package qna.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import notice.bean.NoticeDTO;
import qna.bean.QnADTO;
import qna.dao.QnADAO;

public class QnaBoardWriteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {	
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		QnADTO qnaDTO = new QnADTO();
		qnaDTO.setId(id);
		qnaDTO.setName(name);
		qnaDTO.setSubject(subject);
		qnaDTO.setContent(content);
		
		QnADAO.getInstance().writeQNA(qnaDTO);
		
		return "/qna/qnaBoardWrite.jsp";
	}

}

package qna.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import qna.bean.QnADTO;
import qna.dao.QnADAO;

public class QnaBoardReplyAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		QnADTO qnaDTO = new QnADTO(); // 답글의 DTO 생성
		qnaDTO.setId(id);
		qnaDTO.setName(name);
		qnaDTO.setSubject(subject);
		qnaDTO.setContent(content);
		qnaDTO.setPseq(seq);
		
		QnADAO.getInstance().replyQNA(qnaDTO); //답글 달기
		
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		return "/qna/qnaBoardReply.jsp";
	}

}

package qna.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import qna.bean.CommentDTO;
import qna.dao.QnADAO;

public class QnaCommentWriteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setBseq(bseq);
		commentDTO.setId(id);
		commentDTO.setName(name);
		commentDTO.setContent(content);
		
		// DB
		QnADAO.getInstance().writeComment(commentDTO);
		
		return "/qna/commentWrite.jsp";
	}

}

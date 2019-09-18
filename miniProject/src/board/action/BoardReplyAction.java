package board.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardReplyAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		BoardDTO boardDTO = new BoardDTO();
		HttpSession session = request.getSession();

		int pg = Integer.parseInt(request.getParameter("pg")); //원글의 페이지 번호
		boardDTO.setPseq(Integer.parseInt(request.getParameter("pseq"))); //원글번호
		boardDTO.setSubject(request.getParameter("subject"));
		boardDTO.setContent(request.getParameter("content"));		
		
		boardDTO.setId((String) session.getAttribute("memId"));
		boardDTO.setName((String) session.getAttribute("memName"));
		boardDTO.setEmail((String) session.getAttribute("memEmail"));
		
		BoardDAO.getInstance().replyBoard(boardDTO);
		
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardReply.jsp");
		return "/main/index.jsp";
	}

}

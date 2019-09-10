package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터 받기
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		// db
		BoardDAO.getInstance().updateHit(seq);
		BoardDTO boardDTO = BoardDAO.getInstance().getBoardView(seq);

		request.setAttribute("pg", pg);
		request.setAttribute("boardDTO", boardDTO);
		// 응답
		return "/board/boardView.jsp";
	}

}

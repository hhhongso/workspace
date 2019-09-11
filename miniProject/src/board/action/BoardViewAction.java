package board.action;

import javax.servlet.http.Cookie;
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
		
		//쿠키
		Cookie[] ckarr = request.getCookies();
		if(ckarr != null) {
			for (int i = 0; i < ckarr.length; i++) {
				if(ckarr[i].getName().equals("memHit")) {
					BoardDAO.getInstance().updateHit(seq);					
					ckarr[i].setMaxAge(0);
					response.addCookie(ckarr[i]);
				}
			}
		}

		// db
		BoardDTO boardDTO = BoardDAO.getInstance().getBoardView(seq);
		request.setAttribute("pg", pg);
		request.setAttribute("boardDTO", boardDTO);
		request.setAttribute("display", "/board/boardView.jsp");
		
		// 응답
		return "/main/index.jsp";
	}

}

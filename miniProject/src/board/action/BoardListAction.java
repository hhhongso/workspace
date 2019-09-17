package board.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardListAction implements CommandProcess {

	@SuppressWarnings("deprecation")
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터 받기
		int pg = Integer.parseInt(request.getParameter("pg"));
		int endNum = pg * 5; 
		int startNum = endNum -4;
		int totalArticle = BoardDAO.getInstance().getTotArticle();
		
		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(5);
		boardPaging.setPageSize(5);
		boardPaging.setTotalArticle(totalArticle);
		boardPaging.makePagingHTML("boardList");
		
		//db
		List<BoardDTO> list = BoardDAO.getInstance().getList(startNum, endNum); //list.size() == 5
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	
		request.setAttribute("boardPaging", boardPaging);
		request.setAttribute("list", list);
		request.setAttribute("display", "/board/boardList.jsp");
		
		//쿠키
		HttpSession session = request.getSession();
		if(session.getAttribute("memId") != null) {
			Cookie cookie = new Cookie("memHit", "hit");
			cookie.setMaxAge(30*60);
			response.addCookie(cookie);				
		}
		//응답
		return "/main/index.jsp";
	}

}

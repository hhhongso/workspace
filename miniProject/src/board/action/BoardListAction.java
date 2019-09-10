package board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardListAction implements CommandProcess {

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
		boardPaging.makePagingHTML();
		
		//db
		List<BoardDTO> list = BoardDAO.getInstance().getList(startNum, endNum); //list.size() == 5
		request.setAttribute("boardPaging", boardPaging);
		request.setAttribute("list", list);
		//응답
		return "/board/boardList.jsp";
	}

}

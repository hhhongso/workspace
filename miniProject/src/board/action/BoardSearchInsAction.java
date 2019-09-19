package board.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardSearchInsAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int pg = Integer.parseInt(request.getParameter("pg"));
		String searchOp = request.getParameter("searchOp");
		String searchWord = request.getParameter("searchWord");
		
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOp", searchOp);
		map.put("searchWord", searchWord);		
		map.put("startNum", startNum + "");
		map.put("endNum", endNum + "");
		
		List<BoardDTO> list = BoardDAO.getInstance().getSearchList(map); //searchOp, searchWord, startNum, endNum 필요
		int totalArticle = BoardDAO.getInstance().getSearchTotArticle(map); //searchOp, searchWord만 필요
		
	
		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(2);
		boardPaging.setPageSize(5);
		boardPaging.setTotalArticle(totalArticle);
		boardPaging.makeSearchPagingHTML();

		
		request.setAttribute("pg", pg);
		request.setAttribute("searchOp", searchOp);
		request.setAttribute("searchWord", searchWord);
		request.setAttribute("list", list);
		request.setAttribute("boardPaging", boardPaging);
		request.setAttribute("display", "/board/boardList.jsp");
		
		return "/main/index.jsp";
	}

}

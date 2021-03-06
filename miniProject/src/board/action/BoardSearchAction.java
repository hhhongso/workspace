package board.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardSearchAction implements CommandProcess {
	private String searchOp;
	private String searchWord;
	private int sw;

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터 받기
		int pg = Integer.parseInt(request.getParameter("pg"));
		if (pg == 1 && sw == 0) {
			searchOp = request.getParameter("searchOp");
			searchWord = request.getParameter("searchWord");
			sw = 1;
		}
		
		if(request.getParameter("searchOp")!=null && request.getParameter("searchWord")!=null) {
			if(!searchOp.equals(request.getParameter("searchOp")) || !searchWord.equals(request.getParameter("searchWord"))) {
				searchOp = request.getParameter("searchOp");
				searchWord = request.getParameter("searchWord"); 
				sw = 1; 
			}
		}
		
		System.out.println(pg + "/" + searchOp + "/" + searchWord + "/ sw:" + sw);
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOp", searchOp);
		map.put("searchWord", searchWord);

		// DB
		int totalArticle = BoardDAO.getInstance().getSearchTotArticle(map);
		int endNum = pg * 5;
		int startNum = endNum - 4;

		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(2);
		boardPaging.setPageSize(5);
		boardPaging.setTotalArticle(totalArticle);
		boardPaging.makePagingHTML("boardSearch");

		map.put("startNum", startNum + "");
		map.put("endNum", endNum + "");

		List<BoardDTO> list = BoardDAO.getInstance().getSearchList(map);
		request.setAttribute("list", list);
		request.setAttribute("boardPaging", boardPaging);

//		List<BoardDTO> list = BoardDAO.getInstance().searchBoard(map);
		request.setAttribute("display", "/board/boardList.jsp");
		
		//쿠키
		Cookie cookie = new Cookie("memHit", "hit");
		cookie.setMaxAge(30*60);
		response.addCookie(cookie);
				
		// 응답
		return "/main/index.jsp";
	}

}

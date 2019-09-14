package board.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private List<BoardDTO> list = new ArrayList<BoardDTO>();
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터 받기
		int pg = Integer.parseInt(request.getParameter("pg"));
		if(pg == 1 && sw == 0) {
			System.out.println("들어오나요?");
			searchOp = request.getParameter("searchOp");
			searchWord = request.getParameter("searchWord");		
			sw = 1;
		}	
			System.out.println(pg +"/"+ searchOp +"/"+ searchWord + "/ sw:" + sw);
			Map<String, String> map = new HashMap<String, String>();
			map.put("searchOp", searchOp);
			map.put("searchWord", searchWord);
			
			//DB
			int totalArticle = BoardDAO.getInstance().getSearchTotArticle(map);
			int endNum = pg *5; 
			int startNum = endNum -4; 
			
			BoardPaging boardPaging = new BoardPaging();
			boardPaging.setCurrentPage(pg);
			boardPaging.setPageBlock(2);
			boardPaging.setPageSize(5);
			boardPaging.setTotalArticle(totalArticle);
			boardPaging.makePagingHTML("boardSearch");
			
			map.put("startNum", startNum+"");
			map.put("endNum", endNum+"");
			
			List<BoardDTO> list = BoardDAO.getInstance().getSearchList(map);
			request.setAttribute("list", list);
			request.setAttribute("boardPaging", boardPaging);
		
//		List<BoardDTO> list = BoardDAO.getInstance().searchBoard(map);
		request.setAttribute("display", "/board/boardSearchList.jsp");
		//응답
		return "/main/index.jsp";
	}

}

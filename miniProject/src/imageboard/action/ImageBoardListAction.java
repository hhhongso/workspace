package imageboard.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardPaging;
import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageBoardDAO;

public class ImageBoardListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int pg = Integer.parseInt(request.getParameter("pg"));
		int totalArticle = ImageBoardDAO.getInstance().getTotArticle();
		
		int endNum = pg*2;
		int startNum = endNum-1;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("endNum", endNum);
		map.put("startNum", startNum);
		
		//db
		List<ImageboardDTO> list = ImageBoardDAO.getInstance().getImageboardList(map);
		
		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(2);
		boardPaging.setTotalArticle(totalArticle);
		boardPaging.makePagingHTML("imageboardList");

		request.setAttribute("list", list);
		request.setAttribute("boardPaging", boardPaging);
		request.setAttribute("display", "/imageboard/imageboardList.jsp");
		//응답
		return "/main/index.jsp";
	}

}

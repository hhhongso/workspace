package imageboard.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardPaging;
import imageboard.bean.ImageboardDTO;
import imageboard.bean.ImageboardPaging;
import imageboard.dao.ImageBoardDAO;

public class ImageBoardListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		int endNum = pg*3;
		int startNum = endNum-2;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("endNum", endNum);
		map.put("startNum", startNum);
		
		//db
		int totalArticle = ImageBoardDAO.getInstance().getImageboardTotArticle();
		List<ImageboardDTO> list = ImageBoardDAO.getInstance().getImageboardList(map);
		
		//imageboardPaing 을 따로 만들어주는 게 좋다. (만약 board의 내용을 전부 삭제하게 될 경우, ~)
		ImageboardPaging imageboardPaging = new ImageboardPaging();
		imageboardPaging.setCurrentPage(pg);
		imageboardPaging.setPageBlock(3);
		imageboardPaging.setPageSize(3);
		imageboardPaging.setTotalArticle(totalArticle);
		imageboardPaging.makePagingHTML();

		request.setAttribute("list", list);
		request.setAttribute("imageboardPaging", imageboardPaging);
		request.setAttribute("display", "/imageboard/imageboardList.jsp");
		//응답
		return "/main/index.jsp";
	}

}

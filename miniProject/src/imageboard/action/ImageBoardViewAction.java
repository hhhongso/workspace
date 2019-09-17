package imageboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageBoardDAO;

public class ImageBoardViewAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int pg = Integer.parseInt(request.getParameter("pg"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		//db
		ImageboardDTO imageboardDTO = ImageBoardDAO.getInstance().getImageboardView(seq);
		
		request.setAttribute("pg", pg);
		request.setAttribute("imageboard", imageboardDTO);
		request.setAttribute("display", "/imageboard/imageboardView.jsp");
		
		return "/main/index.jsp";
	}

}

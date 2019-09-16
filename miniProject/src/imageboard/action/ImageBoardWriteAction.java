package imageboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageBoardDAO;

public class ImageBoardWriteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터 받기
		ImageboardDTO imageboardDTO = new ImageboardDTO();
		imageboardDTO.setImageId(request.getParameter("imageId"));     
		imageboardDTO.setImageName(request.getParameter("imageName"));     
		imageboardDTO.setImagePrice(Integer.parseInt(request.getParameter("imagePrice")));     
		imageboardDTO.setImageQty(Integer.parseInt(request.getParameter("imageQty")));     
		imageboardDTO.setImageContent(request.getParameter("imageContent"));     
		imageboardDTO.setImage1(request.getParameter("image1"));     

		System.out.println(request.getParameter("image1"));
		                    
		//db
		ImageBoardDAO.getInstance().writeImage(imageboardDTO);
		
		request.setAttribute("display", "/imageboard/imageboardWrite.jsp");
		//응답
		return "/main/index.jsp";
	}

}

package imageboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageBoardDAO;

public class ImageBoardWriteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//파일 업로드
		//1. cos.jar 2.실제 폴더 얻기 3.업로드
		String realFolder = request.getServletContext().getRealPath("/storage");
		MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024, "UTF-8");
		//가상폴더: C:\java_ee\workspace\miniProject\WebContent\storage
		//실제폴더: C:\java_ee\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\miniProject\storage

		//데이터 받기: request의 제어권은 multi에게 넘어감
		ImageboardDTO imageboardDTO = new ImageboardDTO();
		imageboardDTO.setImageId(multi.getParameter("imageId"));     
		imageboardDTO.setImageName(multi.getParameter("imageName"));     
		imageboardDTO.setImagePrice(Integer.parseInt(multi.getParameter("imagePrice")));     
		imageboardDTO.setImageQty(Integer.parseInt(multi.getParameter("imageQty")));     
		imageboardDTO.setImageContent(multi.getParameter("imageContent"));     
		imageboardDTO.setImage1(multi.getOriginalFileName("image1"));
		
		System.out.println(multi.getOriginalFileName("image1"));
		//db
		ImageBoardDAO.getInstance().writeImageboard(imageboardDTO);		
		
		request.setAttribute("display", "/imageboard/imageboardWrite.jsp");
		//응답
		return "/main/index.jsp";
	}

}

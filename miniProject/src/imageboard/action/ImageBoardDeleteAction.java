package imageboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imageboard.dao.ImageBoardDAO;

public class ImageBoardDeleteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//만일 submit 으로 보낸다면? check한 값만 주소 타고 넘어간다. => 배열로 getParamValues("cbx"); 		
		/* 1)
		 * String[] seqArr = request.getParameterValues("cbx"); String seq = "";  ==> seq[0] = 10;(선택한 번호) 
		 * for (int i = 0; i < seq.length; i++) { seq += seqArr[i] +","; } 
		 * seq = seqArr.substring(0, seq.length()-1);
		 * 
		 * 
		 * 2) 
		 * String[] seqArr = request.getParameterValues("cbx");
		 * Map<String, String[]> map = new HashMap<String, String[]>();
		 * map.put("seqMap", seqArr);
		 * =>파라미터 값으로 map 넘기기
		 */
		
		String seq = request.getParameter("seq");
		ImageBoardDAO.getInstance().deleteImageBoard(seq);
		request.setAttribute("display", "/imageboard/imageboardDelete.jsp");
		
		return "/main/index.jsp";
	}

}

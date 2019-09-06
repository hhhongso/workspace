package board.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardModifyAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		String subject = request.getParameter("subject"); 
		String content = request.getParameter("content");
		
		// hidden value
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("subject", subject);
		map.put("content", content);
		map.put("seq", seq+"");
		
		//db 업데이트
		BoardDAO.getInstance().updateBoard(map);
		request.setAttribute("pg", pg);
		//응답
		return "/board/boardModify.jsp";
	}

}

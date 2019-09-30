package notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import notice.bean.NoticeDTO;
import notice.dao.NoticeDAO;

public class NoticeBoardWriteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("memId");		
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setId(id);
		noticeDTO.setName(name);
		noticeDTO.setSubject(subject);
		noticeDTO.setContent(content);
		
		//DB
		NoticeDAO.getInstance().writeNotice(noticeDTO);
		
		return null;
	}

}

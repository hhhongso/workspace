package qna.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import qna.bean.QnADTO;
import qna.dao.QnADAO;

public class QnaBoardListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		List<QnADTO> list = QnADAO.getInstance().getQnAList();
		
		request.setAttribute("list", list);
		request.setAttribute("display", "/qna/qnaBoardList.jsp");
		return "/main/index.jsp";
	}

}

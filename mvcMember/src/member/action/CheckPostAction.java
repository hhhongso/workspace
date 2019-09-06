package member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import memberJSP.bean.ZipcodeDTO;
import memberJSP.dao.MemberDAO;

public class CheckPostAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터 가져오기
		String sido = request.getParameter("sido");
		String sigungu = request.getParameter("sigungu");
		String roadname = request.getParameter("roadname");
		
		//DB
		List<ZipcodeDTO> list = null;
		if(sido != null && roadname != null){
			list = MemberDAO.getinstance().getZipcodeList(sido, sigungu, roadname);
			request.setAttribute("list", list);			
		}
		
		//응답
		return "/member/checkPost.jsp";
	}

}
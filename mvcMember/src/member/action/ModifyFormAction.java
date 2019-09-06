package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import memberJSP.bean.MemberDTO;
import memberJSP.dao.MemberDAO;

public class ModifyFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터 받기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("memId");
		//db
		MemberDTO memberDTO = MemberDAO.getinstance().getInfo(id);
		
		//응답		
		request.setAttribute("memName", memberDTO.getName());
		request.setAttribute("memId", memberDTO.getId());
		request.setAttribute("memGender", memberDTO.getGender());
		request.setAttribute("memEmail1", memberDTO.getEmail1());
		request.setAttribute("memEmail2", memberDTO.getEmail2());
		request.setAttribute("memTel1", memberDTO.getTel1());
		request.setAttribute("memTel2", memberDTO.getTel2());
		request.setAttribute("memTel3", memberDTO.getTel3());
		request.setAttribute("memZipcode", memberDTO.getZipcode());
		request.setAttribute("memAddr1", memberDTO.getAddr1());
		request.setAttribute("memAddr2", memberDTO.getAddr2());
		
		return "/member/modifyForm.jsp"; 
	}

}
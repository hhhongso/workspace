package member.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.ZipcodeDTO;
import member.dao.MemberDAO;

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
			Map<String, String> map = new HashMap<String, String>();
			map.put("sido", sido);
			map.put("sigungu", sigungu);
			map.put("roadname", roadname);
			list = MemberDAO.getinstance().getZipcodeList(map);
			request.setAttribute("list", list);			
		}
		
		//응답
		return "/member/checkPost.jsp";
	}

}

package myProject.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myProject.dao.MemberDAO;
import myProject.bean.MemberDTO;



@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 받기 
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String zipcode = request.getParameter("zipcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		MemberDTO memberDTO = new MemberDTO();		
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		memberDTO.setGender(gender);
		memberDTO.setEmail1(email1);
		memberDTO.setEmail2(email2);
		memberDTO.setTel1(tel1);
		memberDTO.setTel2(tel2);
		memberDTO.setTel3(tel3);
		memberDTO.setZipcode(zipcode);
		memberDTO.setAddr1(addr1);
		memberDTO.setAddr2(addr2);

		//DB
		MemberDAO memberDAO = MemberDAO.getinstance();
		int cnt = memberDAO.insert(memberDTO);
		
		//응답
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(cnt == 1) {
			
			out.println(cnt + "건 회원가입을 축하합니다! <br>"
					+ "창을 닫고 로그인 해 주세요.");
			out.println("<br><br>");
		}									
		else out.println("회원가입 실패. 다시 작성해 주세요. ");
		out.println("</body>");
		out.println("</html>");
		
	}

}

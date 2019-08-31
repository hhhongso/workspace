package myProject.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myProject.dao.MemberDAO;

@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 받기
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd= request.getParameter("pwd");
		
		//DB
		String name = MemberDAO.getinstance().isLogin(id, pwd);
		//응답하기
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("<form method=post action='/myProject/myproject/modifyForm.jsp'>");
		if(name != null) {
			out.println(name + "님, 환영합니다! <br>");
			out.println("<input type=hidden name=id value="+ id+ ">");
			out.println("<input type=submit value=회원정보수정>");
		} else {
			out.println("아이디 혹은 비밀번호가 틀렸습니다. ");
		}
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}
}

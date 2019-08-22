package member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 받기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
				
		//DB
		String name = MemberDAO.getinstance().isLogin(id, pwd);
		
		//응답
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(name != null) out.println(name + "님, 환영합니다. ");
		else out.println("다시 로그인해주세요. ");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}

}

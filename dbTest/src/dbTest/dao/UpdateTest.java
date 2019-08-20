package dbTest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	private String user = "java"; 
	private String pw = "dkdlxl"; 
	
	private Connection conn; 
	private PreparedStatement pstmt;
	
	public UpdateTest() {
		try {
			Class.forName(driver);	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, pw);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 이름 선택: ");
		String nameChar = scan.next();
		
		this.getConnection();
		
		String sql = "UPDATE DBTEST SET AGE=AGE+1 WHERE NAME LIKE ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+nameChar+"%");
					
			int count = pstmt.executeUpdate();
			System.out.println(count + "row(s) updated");	

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}		
	}

	public static void main(String[] args) {
		UpdateTest ut = new UpdateTest();
		ut.updateArticle();
		
	}

}

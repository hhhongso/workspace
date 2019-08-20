package bitProject.cafe.dao;

// Board 클래스 DB 연동용 DAO 클래스

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDAO {
	private static BoardDAO instance;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "java";
	private String password = "dkdlxl";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// singleton과 인스턴스 획득용
	public static BoardDAO getInstance() {
		if (instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}

	// 생성자 - 드라이버 불러오기
	public BoardDAO() {
		try {
			Class.forName(driver);
			System.out.println("Driver Loading Success");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 서버연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}



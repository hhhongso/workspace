package bitProject.cafe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bitProject.cafe.dto.MemberDTO;

public class MemberDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "java";
	private String password = "dkdlxl";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static MemberDAO instance;

	public static MemberDAO getInstance() {
		if (instance == null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();
			}
		}
		return instance;
	}

	public MemberDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public MemberDTO tryLogin(String tryId, String tryPw) {
		MemberDTO member = null;
		getConnection();
		String sql = "SELECT * FROM CAFE_MEMBER WHERE ID = ? AND PW = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tryId);
			pstmt.setString(2, tryPw);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String emailAccount = rs.getString("email1");
				String emailDomain = rs.getString("email2");
				String tel1 = rs.getString("tel1");
				String tel2 = rs.getString("tel2");
				String tel3 = rs.getString("tel3");
				int birthYear = rs.getInt("birthYear");
				int birthMonth = rs.getInt("birthMonth");
				int birthDate = rs.getInt("birthDate");
				boolean isAgreeEssen = rs.getInt("agreeEssen") == 1 ? true : false;
				boolean isAgreeSelec = rs.getInt("agreeSelec") == 1 ? true : false;
				member = new MemberDTO(id, pw, name, emailAccount, emailDomain, tel1, tel2, tel3, birthYear, birthMonth,
						birthDate, isAgreeEssen, isAgreeSelec);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}

	public int insert(MemberDTO member) {
		int cnt = 0;

		String id = member.getId();
		String pw = member.getPw();
		String name = member.getName();
		String emailAccount = member.getEmailAccount();
		String emailDomain = member.getEmailDomain();
		String tel1 = member.getTel1();
		String tel2 = member.getTel2();
		String tel3 = member.getTel3();
		int birthYear = member.getBirthYear();
		int birthMonth = member.getBirthDate();
		int birthDate = member.getBirthDate();
		int staff = member.isStaff() ? 1 : 0;
		int agreeEssen = member.isAgreeEssen() ? 1 : 0;
		int agreeSelec = member.isAgreeSelec() ? 1 : 0;

		getConnection();
		String sql = "INSERT INTO CAFE_MEMBER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, emailAccount);
			pstmt.setString(5, emailDomain);
			pstmt.setString(6, tel1);
			pstmt.setString(7, tel2);
			pstmt.setString(8, tel3);
			pstmt.setInt(9, birthYear);
			pstmt.setInt(10, birthMonth);
			pstmt.setInt(11, birthDate);
			pstmt.setInt(12, staff);
			pstmt.setInt(13, agreeEssen);
			pstmt.setInt(14, agreeSelec);

			cnt = pstmt.executeUpdate();
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

		return cnt;
	}
}



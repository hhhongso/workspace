package memberJSP.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import memberJSP.bean.MemberDTO;

public class MemberDAO {
	public static MemberDAO instance;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "java";
	private String password = "dkdlxl";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public static MemberDAO getinstance() {
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

	public int insert(MemberDTO memberDTO) {
		getConnection();
		int cnt = 0;
		String sql = "insert into member values (?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getZipcode());
			pstmt.setString(11, memberDTO.getAddr1());
			pstmt.setString(12, memberDTO.getAddr2());

			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;
	}

	public boolean isDuplicate(String id) {
		boolean isDup = false;
		String sql = "select * from member where id = ?";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				isDup = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)	rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isDup;
	}
	
	public MemberDTO isLogin(String id, String pwd) {
		MemberDTO memberDTO = new MemberDTO();
		String sql = "select * from member where id = ? and pwd = ?";
		getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				id = rs.getString("id");
						
				memberDTO.setName(name);
				memberDTO.setId(id);
			
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
		return memberDTO;
	}

	public MemberDTO getInfo(String id) {
		MemberDTO memberDTO = new MemberDTO();
		String sql = "select * from member where id = ?";
		getConnection();
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				id = rs.getString("id");
				String gender = rs.getString("gender");
				String email1 = rs.getString("email1");
				String email2 = rs.getString("email2");
				String tel1 = rs.getString("tel1");
				String tel2 = rs.getString("tel2");
				String tel3 = rs.getString("tel3");
				String zipcode = rs.getString("zipcode");
				String addr1 = rs.getString("addr1");
				String addr2 = rs.getString("addr2");
				
				memberDTO.setName(name);
				memberDTO.setId(id);
				memberDTO.setGender(gender);
				memberDTO.setEmail1(email1);
				memberDTO.setEmail2(email2);
				memberDTO.setTel1(tel1);
				memberDTO.setTel2(tel2);
				memberDTO.setTel3(tel3);
				memberDTO.setZipcode(zipcode);
				memberDTO.setAddr1(addr1);
				memberDTO.setAddr2(addr2);
			
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
		return memberDTO;
		
		
	}
}

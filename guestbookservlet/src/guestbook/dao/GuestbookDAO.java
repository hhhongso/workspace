package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import guestbook.bean.GuestbookDTO;

public class GuestbookDAO {
	public static GuestbookDAO instance; 

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "java";
	private String password = "dkdlxl";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private ArrayList<GuestbookDTO> list;
	
	public static GuestbookDAO getinstance() {
		if(instance == null) {
			synchronized (GuestbookDAO.class) {
				instance = new GuestbookDAO();				
			}
		}
		return instance;
	}
	
	public GuestbookDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		list = new ArrayList<GuestbookDTO>();

	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void write(GuestbookDTO guestbookDTO) {
		getConnection();
		String sql = "insert into guestbook values(seq_guestbook.nextVal, ?,?,?,?,?, sysdate)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, guestbookDTO.getName());
			pstmt.setString(2, guestbookDTO.getEmail());
			pstmt.setString(3, guestbookDTO.getHomepage());
			pstmt.setString(4, guestbookDTO.getSubject());
			pstmt.setString(5, guestbookDTO.getContent());
			
			pstmt.executeUpdate();
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

	public ArrayList<GuestbookDTO> getList() {
		getConnection();
		String sql = "select seq, name, email, homepage, subject, content, to_CHAR(logtime, 'YYYY.MM.DD') as logtime from guestbook order by seq asc";		
	
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String homepage = rs.getString("homepage");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String logtime = rs.getString("logtime");
				
				GuestbookDTO guestbookDTO = new GuestbookDTO(seq, name, email, homepage, subject, content, logtime);
				
				list.add(guestbookDTO);
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
				
		return list;
	}

}

package friend.dao;
//DAO: Database Access Operation : 

import friend.bean.FriendDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FriendDAO {
	private static FriendDAO instance;
	public static FriendDAO getInstance() {
		if(instance == null) {
			synchronized (FriendDAO.class) {
				instance = new FriendDAO();
			}
		}
		return instance;
	}
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	private String user = "java"; 
	private String password = "dkdlxl"; 
	
	private Connection conn; 
	private PreparedStatement pstmt;
	private ResultSet rs; 
	
	public FriendDAO() {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int regitFriend(FriendDTO dto) {	
		getConnection();
		int count = 0; 
		String sql = "INSERT INTO FRIEND(SEQ, NAME, TEL1, TEL2, TEL3, SEX, READ, MOVIE, MUSIC, GAME, SHOOPING)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		//seq.nextVal?

		try {
			pstmt = conn.prepareStatement(sql);				

			pstmt.setInt(1, dto.getSeq());		
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getTel1());
			pstmt.setString(4, dto.getTel2());
			pstmt.setString(5, dto.getTel3());
			pstmt.setInt(6, dto.getSex());
			pstmt.setInt(7, dto.getRead());
			pstmt.setInt(8, dto.getMovie());
			pstmt.setInt(9, dto.getMusic());
			pstmt.setInt(10, dto.getGame());
			pstmt.setInt(11, dto.getShopping());
		
			count = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {				
				if(pstmt != null) pstmt.close();
				if(conn != null)conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return count; 
	}

	public int getSeq() {
		getConnection();
		int seq = 0; 
		String sql = "select seq_friend.nextVal from dual";
		
		try {
			pstmt = conn.prepareStatement(sql);		
			rs = pstmt.executeQuery();
			if(rs.next()) { // 항목이 하나밖에 없으니까 if 써도 괜찮. 전체출력 등 다수의 항목을 가져와야 할 경우 while로 
				seq = rs.getInt(1); // 따로 column명이 없음 => 그냥 번호로 가져올 수도 있음. 	
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			try {	
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null)conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return seq;
	}

	public ArrayList<FriendDTO> getFriendDisp() {
		getConnection();
		
		ArrayList<FriendDTO> list = new ArrayList<FriendDTO>();
		String sql = "select * from friend order by seq desc";
		
		try {
			pstmt = conn.prepareStatement(sql);		
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FriendDTO dto = new FriendDTO(); // 데이터의 수만큼 dto를 만들고, 각 값을 셋팅해준 후, list에 넣는다.
				dto.setSeq(rs.getInt("seq"));
				dto.setName(rs.getString("name"));
				dto.setTel1(rs.getString("tel1"));
				dto.setTel2(rs.getString("tel2"));
				dto.setTel3(rs.getString("tel3"));
				dto.setSex(rs.getInt("sex"));
				dto.setRead(rs.getInt("read"));
				dto.setMovie(rs.getInt("movie"));
				dto.setMusic(rs.getInt("music"));
				dto.setGame(rs.getInt("game"));
				dto.setShopping(rs.getInt("shooping")); //쇼핑 오타났쪄 
			
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null; 
			//만일 에러가 생성됬다면, list를 return하면 안된다. catch에서 list= null로 다시 초기화시켜줌. => 실행 시 nullpointerException 발생
		} finally {
			try {	
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null)conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return list;
	}

	public int editFriend(FriendDTO dto) {
		getConnection();
		int count = 0; 
		String sql = "UPDATE FRIEND SET NAME = ?, TEL1 = ?, TEL2 = ?, TEL3 = ?, SEX = ?, READ = ?, MOVIE = ?, MUSIC = ?, GAME = ?, SHOOPING = ?"
				+ "WHERE SEQ = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);				

			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTel1());
			pstmt.setString(3, dto.getTel2());
			pstmt.setString(4, dto.getTel3());
			pstmt.setInt(5, dto.getSex());
			pstmt.setInt(6, dto.getRead());
			pstmt.setInt(7, dto.getMovie());
			pstmt.setInt(8, dto.getMusic());
			pstmt.setInt(9, dto.getGame());
			pstmt.setInt(10, dto.getShopping());
			pstmt.setInt(11, dto.getSeq());		

			count = pstmt.executeUpdate();
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
				
		return count;
	}

	public int deleteFriend(int seq) {
		getConnection();
		int count = 0; 
		
		String sql = "DELETE FRIEND WHERE SEQ = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);		
			
			count = pstmt.executeUpdate();
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
		
		return count;
	}

}
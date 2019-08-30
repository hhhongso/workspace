package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.bean.BoardDTO;

public class BoardDAO {
	public static BoardDAO instance;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "java";
	private String password = "dkdlxl";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public BoardDAO() {
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
	
	public void write(BoardDTO boardDTO) {
		getConnection();
		
		String sql ="insert into board (seq, id, name, email, subject, content, ref) "
				+ "values (seq_board.nextVal, ?, ?, ?, ?, ?, seq_board.currVal)";	
		//같은 SQL문장 안에서는 nextVal 이 같음. 
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getId());
			pstmt.setString(2, boardDTO.getName());
			pstmt.setString(3, boardDTO.getEmail());
			pstmt.setString(4, boardDTO.getSubject());
			pstmt.setString(5, boardDTO.getContent());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}			
	}
	
	public int getTotArticle() {
		int totArticle = 0;
		String sql = "select count(*) as count from board";
		getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				totArticle = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totArticle;
	}
	public List<BoardDTO> getList(int startNum, int endNum){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "select seq, subject, id, logtime, hit from " + 
				"(select rownum rn, temp.* from " + 
				"(select *from board order by seq desc) temp) where rn between ? and ?";
		getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setLogtime(rs.getDate("logtime"));
				boardDTO.setHit(rs.getInt("hit"));
			
//				boardDTO.setContent(rs.getString("content"));			
//				boardDTO.setRef(rs.getInt("ref"));
//				boardDTO.setLev(rs.getInt("lev"));
//				boardDTO.setStep(rs.getInt("step"));
//				boardDTO.setPseq(rs.getInt("pseq"));
//				boardDTO.setReply(rs.getInt("reply"));
//				

				list.add(boardDTO);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return list;
	}
}

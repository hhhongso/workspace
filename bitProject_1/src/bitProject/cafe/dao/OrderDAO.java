package bitProject.cafe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bitProject.cafe.dto.OrderDTO;

public class OrderDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "java";
	private String password = "dkdlxl";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static OrderDAO instance;

	public static OrderDAO getInstance() {
		if (instance == null) {
			synchronized (OrderDAO.class) {
				instance = new OrderDAO();
			}
		}
		return instance;
	}

	public OrderDAO() {
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
	
	public int insert(OrderDTO order) {
		getConnection();
		int cnt = 0;
		
		String sql = "INSERT INTO CAFE_ORDER VALUES(?, ?, ?, ?, ?, ?)";

		int seq = order.getSeq();
		String id = order.getId();
		String menuName = order.getMenuName();
		int amount = order.getAmount();
		int menuPrice = order.getMenuPrice();
		int totPrice = order.getAmount() * order.getMenuPrice();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, seq);
			pstmt.setString(2, id);
			pstmt.setString(3, menuName);
			pstmt.setInt(4, amount);
			pstmt.setInt(5, menuPrice);
			pstmt.setInt(6, totPrice);
			
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
	
	
	public int getSeq() {
		getConnection();		
		int seq = 0;
		String sql = "select seq_order.nextVal from dual";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) { 
				seq = rs.getInt(1); 
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
		
		return seq;
	}

	public ArrayList<OrderDTO> dispAll() { // 전체출력
		getConnection();
		ArrayList<OrderDTO> list = new ArrayList<OrderDTO>();

		String sql = "SELECT * FROM CAFE_ORDER order by 1 asc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				OrderDTO order = new OrderDTO();
				
				int seq = rs.getInt("seq");
				String id = rs.getString("id");
				String menuName = rs.getString("menuName");
				int amount = rs.getInt("amount");
				int menuPrice = rs.getInt("menuPrice");

				order.setSeq(seq);
				order.setId(id);
				order.setMenuName(menuName);
				order.setAmount(amount);
				order.setMenuPrice(menuPrice);

				list.add(order);
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
		return list;
	}
	
	public int delete(int selectedSeq) {//판매완료 ->  주문 내역 DB에서 삭제
		getConnection();
		int cnt = 0; 
		String sql = "DELETE FROM CAFE_ORDER WHERE SEQ = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, selectedSeq);
			cnt = pstmt.executeUpdate();
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
		return cnt; 
	}

	public ArrayList<OrderDTO> dispUpdate(int lastSeq) {
		getConnection();
		ArrayList<OrderDTO> list = new ArrayList<OrderDTO>();
		
		String sql = "SELECT * FROM CAFE_ORDER WHERE SEQ > ? order by 1 asc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lastSeq);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderDTO order = new OrderDTO();	
				
				int seq = rs.getInt("seq");
				String id = rs.getString("id");
				String menuName = rs.getString("menuName");
				int amount = rs.getInt("amount");
				int menuPrice = rs.getInt("menuPrice");

				order.setSeq(seq);
				order.setId(id);
				order.setMenuName(menuName);
				order.setAmount(amount);
				order.setMenuPrice(menuPrice);

				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return list;
	}

}

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

public class SalesDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "java";
	private String password = "dkdlxl";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static SalesDAO instance;

	public static SalesDAO getInstance() {
		if (instance == null) {
			synchronized (SalesDAO.class) {
				instance = new SalesDAO();
			}
		}
		return instance;
	}

	public SalesDAO() {
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

		String sql = "INSERT INTO CAFE_SALES VALUES(?, ?, ?, ?, ?, ?)";

		SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-dd HH:mm");
		Date date = new Date();
		String orderDate = sdf.format(date);
		order.setOrderDate(orderDate);
		
		int seq = getSeq();
		String menuName = order.getMenuName();
		int amount = order.getAmount();
		int menuPrice = order.getMenuPrice();
		int totPrice = order.getAmount() * order.getMenuPrice();
		orderDate = order.getOrderDate();
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, menuName);
			pstmt.setInt(2, amount);
			pstmt.setInt(3, menuPrice);
			pstmt.setInt(4, totPrice);
			pstmt.setString(5, orderDate);

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
	
	public int getSeq() {
		getConnection();
		int seq = 0;
		
		String sql = "select seq_sales.nextVal from dual";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				seq = rs.getInt("seq");
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
		
		String sql = "SELECT * FROM CAFE_SALES";

		try {	
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
				
				while(rs.next()) {	
					OrderDTO order = new OrderDTO();
					String menuName = rs.getString("menuName");
					int amount = rs.getInt("amount");
					int menuPrice = rs.getInt("menuPrice");
					String orderDate = rs.getString("orderDate");

					order.setMenuName(menuName);
					order.setAmount(amount);
					order.setMenuPrice(menuPrice);
					order.setOrderDate(orderDate);
					
					list.add(order);
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
	
	public ArrayList<OrderDTO> dispUpdate(int selectedSeq) {
		getConnection();
		ArrayList<OrderDTO> list = new ArrayList<OrderDTO>();
		String sql = "SELECT * FROM CAFE_SALES WHERE SEQ > ?";
		//SELECT * FROM "TABLE NAME" ORDER BY "COLUMN NAME" DESC LIMIT 1
//		//select * from [테이블] order by [정렬할 속성] desc limit [출력 갯수]	
//		SELECT * FROM 
//		(SELECT user_id, nickname, reg_date 
//		FROM user 
//		ORDER BY reg_date desc) as a 
//		GROUP BY a.nickname; 
		try {
			pstmt.setInt(1, selectedSeq);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				OrderDTO order = new OrderDTO();
				String id = rs.getString("id");
				String menuName = rs.getString("menuName");
				int amount = rs.getInt("amount");
				int menuPrice = rs.getInt("menuPrice");
				String orderDate = rs.getString("orderDate");

				order.setId(id);
				order.setMenuName(menuName);
				order.setAmount(amount);
				order.setMenuPrice(menuPrice);
				order.setOrderDate(orderDate);

				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return list;
	}

	

}

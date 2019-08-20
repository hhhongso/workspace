package bitProject.cafe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

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

	public void insert(OrderDTO orderDTO) {
		ArrayList<OrderDTO> list = orderDTO.getOrderArr();
		getConnection();
		try {
			for (int i = 0; i < list.size(); i++) {
				String sql = "INSERT INTO CAFE_ORDER VALUES(SEQ_ORDER.NEXTVAL, ?, ?, ?, ?, ?)";

				OrderDTO order = list.get(i);
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, order.getId());
				pstmt.setString(2, order.getMenuName());
				pstmt.setInt(3, order.getAmount());
				pstmt.setInt(4, order.getMenuPrice());
				pstmt.setInt(5, order.getAmount() * order.getMenuPrice());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection(false);
		}
	}

	public int getSeq() {
		getConnection();
		int seq = 0;
		String sql = "select seq_order.nextVal from dual";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				seq = rs.getInt(1);
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

		return seq;
	}

	public Vector<Vector<String>> getFromDB() { // 전체출력
		getConnection();
		Vector<Vector<String>> orderList = new Vector<Vector<String>>();
		Vector<String> order = null;
		String sql = "SELECT * FROM CAFE_ORDER ORDER BY seq ASC";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new Vector<String>();
				order.add(rs.getInt("seq") + "");
				order.add(rs.getString("id"));
				order.add(rs.getString("menuName"));
				order.add(rs.getInt("amount") + "");
				order.add(rs.getInt("menuPrice") + "");
				order.add((rs.getInt("amount") * rs.getInt("menuPrice")) + "");
				orderList.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection(true);
		}
		return orderList;
	}

	public void delete(int selectedSeq) { // 판매완료 -> 주문 내역 DB에서 삭제
		getConnection();
		String sql = "DELETE FROM CAFE_ORDER WHERE SEQ = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, selectedSeq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection(false);
		}
	}

//	public ArrayList<OrderDTO> dispUpdate(int lastSeq) {
//		getConnection();
//		ArrayList<OrderDTO> list = new ArrayList<OrderDTO>();
//
//		String sql = "SELECT * FROM CAFE_ORDER WHERE SEQ > ? order by 1 asc";
//
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, lastSeq);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				OrderDTO order = new OrderDTO();
//
//				int seq = rs.getInt("seq");
//				String id = rs.getString("id");
//				String menuName = rs.getString("menuName");
//				int amount = rs.getInt("amount");
//				int menuPrice = rs.getInt("menuPrice");
//
//				order.setSeq(seq);
//				order.setId(id);
//				order.setMenuName(menuName);
//				order.setAmount(amount);
//				order.setMenuPrice(menuPrice);
//
//				list.add(order);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return list;
//	}

	public void disconnection(boolean isSelect) {
		try {
			if (isSelect) {
				rs.close();
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

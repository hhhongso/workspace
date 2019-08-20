package bitProject.cafe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import bitProject.cafe.dto.RoomDTO;

public class RoomDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "java";
	private String password = "dkdlxl";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static RoomDAO instance;

	public static RoomDAO getInstance() {
		if (instance == null) {
			synchronized (RoomDAO.class) {
				instance = new RoomDAO();
			}
		}
		return instance;
	}

	public RoomDAO() {
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

	public int insert(RoomDTO room) {
		int cnt = 0;

		String id = room.getId();
		int roomNum = room.getRoomNum();
		int year = room.getYear();
		int month = room.getMonth();
		int date = room.getDate();
		int inHour = room.getInHour();
		int outHour = room.getOutHour();

		getConnection();
		String sql = "INSERT INTO CAFE_ROOMRESERVATION VALUES(?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, roomNum);
			pstmt.setInt(3, year);
			pstmt.setInt(4, month);
			pstmt.setInt(5, date);
			pstmt.setInt(6, inHour);
			pstmt.setInt(7, outHour);

			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	public ArrayList<RoomDTO> check(RoomDTO room) {
		ArrayList<RoomDTO> roomList = new ArrayList<RoomDTO>();

		int room_year = room.getYear();
		int room_month = room.getMonth();
		int room_date = room.getDate();

		getConnection();
		String sql = "SELECT * FROM CAFE_ROOMRESERVATION WHERE ROOM_YEAR = ? AND ROOM_MONTH = ? AND ROOM_DATE = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, room_year);
			pstmt.setInt(2, room_month);
			pstmt.setInt(3, room_date);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int roomNum = rs.getInt("room_num");
				String id = rs.getString("id");
				int year = rs.getInt("room_year");
				int month = rs.getInt("room_month");
				int date = rs.getInt("room_date");
				int inHour = rs.getInt("inhour");
				int outHour = rs.getInt("outHour");

				roomList.add(new RoomDTO(roomNum, id, year, month, date, inHour, outHour));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return roomList;
	}

	public Vector<Vector<Integer>> getMyReservation(String id) {
		Vector<Vector<Integer>> roomList = new Vector<Vector<Integer>>();
		Vector<Integer> room = null;
		getConnection();
		String sql = "SELECT * FROM CAFE_ROOMRESERVATION WHERE ID = ? ORDER BY 2, 3, 4, 5, 6";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				room = new Vector<Integer>();
				room.add(rs.getInt("room_num"));
				room.add(rs.getInt("room_year"));
				room.add(rs.getInt("room_month"));
				room.add(rs.getInt("room_date"));
				room.add(rs.getInt("inhour"));
				room.add(rs.getInt("outHour"));
				roomList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return roomList;
	}

	public int deleteReservation(RoomDTO room) {
		int cnt = 0;
		getConnection();
		String sql = "DELETE FROM CAFE_ROOMRESERVATION WHERE ID = ? AND ROOM_NUM = ? AND ROOM_YEAR = ? AND ROOM_MONTH = ? AND ROOM_DATE = ? AND INHOUR = ? AND OUTHOUR =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, room.getId());
			pstmt.setInt(2, room.getRoomNum());
			pstmt.setInt(3, room.getYear());
			pstmt.setInt(4, room.getMonth());
			pstmt.setInt(5, room.getDate());
			pstmt.setInt(6, room.getInHour());
			pstmt.setInt(7, room.getOutHour());

			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
}



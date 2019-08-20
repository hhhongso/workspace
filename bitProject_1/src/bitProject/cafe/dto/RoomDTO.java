package bitProject.cafe.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

import bitProject.cafe.dao.Status;

public class RoomDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7774346678492384119L;
	private int roomNum;
	private String id;
	private int year;
	private int month;
	private int date;
	private int inHour;
	private int outHour;
	private Status status;
	private ArrayList<RoomDTO> roomList;
	private Vector<Vector<Integer>> reservationList;

	public RoomDTO(int roomNum, String id, int year, int month, int date, int inHour, int outHour) {
		super();
		this.roomNum = roomNum;
		this.id = id;
		this.year = year;
		this.month = month;
		this.date = date;
		this.inHour = inHour;
		this.outHour = outHour;
	}

	public RoomDTO(String id) {
		this.id = id;
	}

	public Vector<Vector<Integer>> getReservationList() {
		return reservationList;
	}

	public void setReservationList(Vector<Vector<Integer>> reservationList) {
		this.reservationList = reservationList;
	}

	public ArrayList<RoomDTO> getRoomList() {
		return roomList;
	}

	public RoomDTO(Status status) {
		this.status = status;
	}

	public RoomDTO(ArrayList<RoomDTO> roomList) {
		this.roomList = roomList;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDate() {
		return date;
	}

	public int getInHour() {
		return inHour;
	}

	public int getOutHour() {
		return outHour;
	}

}

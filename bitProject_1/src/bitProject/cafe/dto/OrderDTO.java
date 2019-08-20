package bitProject.cafe.dto;

import java.io.Serializable;
import bitProject.cafe.view.Message;

public class OrderDTO implements Serializable {
	private int seq;
	private String id;
	private String menuName;
	private int amount;
	private int menuPrice;
	private String orderDate;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public String getOrderDate() {
		return orderDate;
	}

}

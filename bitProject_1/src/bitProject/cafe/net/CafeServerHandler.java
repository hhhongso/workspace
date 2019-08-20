package bitProject.cafe.net;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import bitProject.cafe.dto.MemberDTO;
import bitProject.cafe.dto.OrderDTO;
import bitProject.cafe.dto.RoomDTO;
import bitProject.cafe.view.Message;

public class CafeServerHandler extends Thread {
//	public static ArrayList<RoomDTO> roomList = new ArrayList<RoomDTO>();

	private Socket socket;
	private ArrayList<CafeServerHandler> list;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	private MemberDTO member;

	public CafeServerHandler(Socket socket, ArrayList<CafeServerHandler> list) {
		this.socket = socket;
		this.list = list;

		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		try {
			while (true) {
				Object temp = null;

				try {
					temp = ois.readObject();
				} catch (EOFException eofe) {
					temp = null;
				}
				if (temp instanceof MemberDTO) {
					member = (MemberDTO) temp;
					System.out.println(member.getName() + " 님이 접속하셨습니다.");
					System.out.println("현재 접속 인원 수 :"+  list.size());
					
				} else if (temp instanceof RoomDTO) {
					RoomDTO room = (RoomDTO) temp;
					oos.writeObject(room);
					oos.flush();

// OrderDTO 로 캐스팅 할 수 있으면~ 					
				} else if (temp instanceof OrderDTO || temp instanceof MemberDTO) {
					OrderDTO order = (OrderDTO) temp;

//					if (order.getStatus() == Message.ORDER) {
//						order.setStatus(Message.ORDER);
//						oos.writeObject(order);
//						oos.flush();
//					} 

					// 스태프 계정에게는 내용을 보내주고
					// 관계없는 사용자 계정에게는 아무것도 보내지 않는다.
//					if(member.getStaff()) {
//						System.out.println(member.getStaff());
//						System.out.println(order.getStatus());
//						String id = order.getId();
//						String menuName = order.getMenuName();
//						int amount = order.getAmount();
//						int menuPrice = order.getMenuPrice();
//						System.out.println(id);
//						
//						order.setId(id);
//						order.setMenuName(menuName);
//						order.setAmount(amount);
//						order.setMenuPrice(menuPrice);
//						order.setStatus(Message.ORDERDISP);
//						oos.writeObject(order);
//						oos.flush();
//						
//						
//					}
					while(true) {}

				}

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

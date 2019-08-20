package bitProject.cafe.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class CafeServer {

	public static final int SERVER_PORT = 10200;
	private ServerSocket ss;
	private ArrayList<CafeServerHandler> list;

	public CafeServer() {
		list = new ArrayList<CafeServerHandler>();

		try {
			ss = new ServerSocket(SERVER_PORT);
			System.out.println("서버가 준비되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				Socket socket = ss.accept();

				CafeServerHandler handler = new CafeServerHandler(socket, list);
				handler.start();

				list.add(handler);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new CafeServer();
	}

}



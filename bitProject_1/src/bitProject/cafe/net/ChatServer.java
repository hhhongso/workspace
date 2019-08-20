package bitProject.cafe.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	
	private ServerSocket ss;
	private Socket socket;

	public ChatServer() {
		try{
			ss = new ServerSocket(10201);
			System.out.println("서버준비완료");
			
			while(true){
				Socket socket = ss.accept();
				ChatHandler handler = new ChatHandler(socket); // 스레드 생성
				handler.start();
				//스레드 시작
			
			}//while
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChatServer();
	}
}



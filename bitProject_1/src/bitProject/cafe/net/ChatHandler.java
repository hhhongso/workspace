package bitProject.cafe.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

class ChatHandler extends Thread {

	private BufferedReader br;
	private PrintWriter pw;
	private Socket socket;

	public ChatHandler(Socket socket) {
		this.socket = socket;
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void run() {
		try {
			String chatStr;
			String command;
			boolean isChatting = true;
			while (isChatting) {
				chatStr = br.readLine();
				command = classify(chatStr);
				switch (command) {
				case "MEET":
					String room = chatStr.substring(10, 15);
					String id = chatStr.substring(15);
					broadcast("meet");
					break;
				case "SEND":
					String msg = chatStr.substring(10);
					broadcast(msg);
					break;
				case "EXIT":
				default:
					isChatting = false;
					break;
					
				}
			}
			pw.println("|||EXIT|||");
			broadcast("퇴장");
			br.close();
			pw.close();
			socket.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public String classify(String str) {
		String tempCom;
		tempCom = str.substring(3, 7);
		return tempCom;
	}

	public void broadcast(String msg) {

			pw.println(msg);
			pw.flush();
	}
}



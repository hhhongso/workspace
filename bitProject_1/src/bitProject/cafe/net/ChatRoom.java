package bitProject.cafe.net;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import bitProject.cafe.dto.MemberDTO;

public class ChatRoom extends JPanel implements ListSelectionListener, ActionListener, Runnable {

	PrintWriter pw;
	BufferedReader br;
	Socket socket;
	
	JPanel pnlTop1;
	JLabel lblTop1Name;
	JLabel lblTop1Content;

	JPanel pnlTop2;
	JLabel lblTop2Name;
	JLabel lblTop2Content;

	JPanel pnlTop3;
	JLabel lblTop3Name;
	JLabel lblTop3Content;

	JPanel pnlTop4;
	JLabel lblTop4Name;
	JLabel lblTop4Content;

	JPanel pnlTopRight;
	JLabel lblTopRight;

	JTextArea taShow;
	JScrollPane scrollChat;

	JPanel pnlInput;
	JLabel lblInput;

	JPanel pnlBot;
	JLabel lblBot;

	JPanel pnlSend;
	JTextField tfSend;
	JButton btnSend;
	
	JButton btnClose;

	JList<String> chatList;

	public ChatRoom(MemberDTO dto) {
		this.setSize(1200, 500);
		// 레이아웃 설정
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(gbl);

		gbc.fill = GridBagConstraints.BOTH;
		
		btnClose = new JButton("채팅종료");

		pnlTop1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblTop1Name = new JLabel("방이름  : ");
		lblTop1Content = new JLabel("테스트");
		pnlTop1.add(lblTop1Name);
		pnlTop1.add(lblTop1Content);
		this.addGrid(gbl, gbc, pnlTop1, 0, 0, 1, 1, 1, 0);

		pnlTop2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblTop2Name = new JLabel("입실시간  : ");
		lblTop2Content = new JLabel("테스트2");
		pnlTop2.add(lblTop2Name);
		pnlTop2.add(lblTop2Content);
		this.addGrid(gbl, gbc, pnlTop2, 1, 0, 1, 1, 1, 0);

		pnlTop3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblTop3Name = new JLabel("퇴실시간  : ");
		lblTop3Content = new JLabel("테스트3");
		pnlTop3.add(lblTop3Name);
		pnlTop3.add(lblTop3Content);
		this.addGrid(gbl, gbc, pnlTop3, 2, 0, 1, 1, 1, 0);

		pnlTop4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblTop4Name = new JLabel("총 구매액  : ");
		lblTop4Content = new JLabel("테스트4");
		pnlTop4.add(lblTop4Name);
		pnlTop4.add(lblTop4Content);
		this.addGrid(gbl, gbc, pnlTop4, 3, 0, 1, 1, 1, 0);

		pnlTopRight = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblTopRight = new JLabel("채팅방 리스트");
		pnlTopRight.setPreferredSize(new Dimension(100, 25)); // 탑라벨을 늘려도 사이즈 고정되도록
		pnlTopRight.add(lblTopRight);
		this.addGrid(gbl, gbc, pnlTopRight, 4, 0, 1, 1, 0, 0);

		taShow = new JTextArea();
		taShow.setEditable(false);

		scrollChat = new JScrollPane(taShow);
		scrollChat.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.addGrid(gbl, gbc, scrollChat, 0, 1, 4, 1, 3, 3);

		chatList = new JList<String>();
		chatList.setListData(new String[] { "test1번방 : Client3", "test2번방 : 유종민", "test3 : guest3" });
		this.addGrid(gbl, gbc, chatList, 4, 1, 1, 1, 1, 0);
		chatList.setBorder(new LineBorder(Color.GRAY));

		tfSend = new JTextField(10);
		this.addGrid(gbl, gbc, tfSend, 0, 3, 3, 1, 1, 0);

		pnlSend = new JPanel(new FlowLayout(FlowLayout.LEFT));

		btnSend = new JButton("보내기");
		pnlSend.add(btnSend);
		pnlSend.add(btnClose);
		this.addGrid(gbl, gbc, pnlSend, 3, 3, 1, 1, 1, 0);

		event();
		
		// 로그인 시 바로 연결, 파라미터 입력, 채팅방 연결
		connectionChat("room1",dto.getId(),"192.168.0.39",10201);
	}

	
	// 유틸리티 메서드

	private void addGrid(GridBagLayout gbl, GridBagConstraints gbc, Component c, int gridx, int gridy, int gridwidth,
			int gridheight, double weightx, double weighty) { // 그리드백레이아웃 생성용
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints(c, gbc);
		add(c);
	}
	
	public void connectionChat(String room,String id, String server, int port) {

		
		pw = null;
		br = null;
		
		try {
			socket = new Socket(server,port);
			
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
		} catch (UnknownHostException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		String chatStr = "|||MEET|||"+room+id;
		pw.println(chatStr);
		pw.flush();
		Thread t = new Thread(this);
		t.start();

	}
	
	private void event() {
		chatList.addListSelectionListener(this);
		btnSend.addActionListener(this);
		tfSend.addActionListener(this);		
		btnClose.addActionListener(this);
	}
	
	// 이벤트 처리

	@Override
	public void valueChanged(ListSelectionEvent e) {
		System.out.println("셀렉션인덱스 : " + chatList.getSelectedIndex());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnSend || e.getSource() == tfSend) {
			String msg = "|||SEND|||"+tfSend.getText();
			pw.println(msg);
			pw.flush();
			tfSend.setText("");
		}
		
		if(e.getSource() == btnClose) {
			pw.println("|||EXIT|||");
			pw.flush();
		}
	}
	


	@Override
	public void run() {
		String msg = null;
		while(true) {
			try {
				msg = br.readLine();
				if(msg==null || msg.equals("|||EXIT|||")) {
					br.close();
					pw.close();
					socket.close();
					System.out.println(msg);
					System.out.println("채팅종료");
					break;
//					System.exit(0);
				}
				System.out.println(msg);
				taShow.append(msg+"\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}



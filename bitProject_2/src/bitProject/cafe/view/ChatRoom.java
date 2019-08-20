package bitProject.cafe.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import bitProject.cafe.ClientSetting;
import bitProject.cafe.dto.MemberDTO;

public class ChatRoom extends JPanel implements ListSelectionListener, ActionListener, Runnable {
	private static final long serialVersionUID = -7018549215051326493L;
	private PrintWriter pw;
	private BufferedReader br;
	private Socket socket;
	private JButton btnSend;
	private JButton btnClose;
	private JTextField tfSend;
	private JList<String> listChat;
	private DefaultListModel<String> modelChat;
	private JTextArea taShow;
	private JButton btnTest;
	private JScrollPane scrollChat;
	private boolean isStaff;
	private String id;

	private HashMap<String, JTextArea> mapChat;

	GridBagLayout gbl;
	GridBagConstraints gbc;

	public ChatRoom(MemberDTO member) {
		// 레이아웃 설정

		this.setSize(1200, 500);

		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		this.setLayout(gbl);

		gbc.fill = GridBagConstraints.BOTH;
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

		JPanel pnlSend;

		btnTest = new JButton("비품요청?이라든가");
		btnClose = new JButton("채팅종료");

		mapChat = new HashMap<String, JTextArea>();

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
		lblTop4Name = new JLabel("더미  : ");
		lblTop4Content = new JLabel("테스트4");
		pnlTop4.add(lblTop4Name);
		pnlTop4.add(lblTop4Content);
		this.addGrid(gbl, gbc, pnlTop4, 3, 0, 1, 1, 1, 0);

		pnlTopRight = new JPanel(new FlowLayout(FlowLayout.LEFT));
		String whoLogin = member.isStaff() ? "채팅방 리스트" : "문의하기"; // 확인해

		lblTopRight = new JLabel(whoLogin); // 이거 모야

		pnlTopRight.setPreferredSize(new Dimension(100, 25)); // 탑라벨을 늘려도 사이즈 고정되도록
		pnlTopRight.add(lblTopRight);
		this.addGrid(gbl, gbc, pnlTopRight, 4, 0, 1, 1, 0, 0);

		taShow = new JTextArea();
		taShow.setEditable(false);
		scrollChat = new JScrollPane(taShow);
		scrollChat.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // 채팅 아레아 설정
		this.addGrid(gbl, gbc, scrollChat, 0, 1, 4, 1, 3, 3);

		modelChat = new DefaultListModel<String>();
		listChat = new JList<String>(modelChat);
		modelChat = (DefaultListModel<String>) listChat.getModel();

		this.addGrid(gbl, gbc, listChat, 4, 1, 1, 1, 1, 0);
		listChat.setBorder(new LineBorder(Color.GRAY));

		tfSend = new JTextField(10);
		this.addGrid(gbl, gbc, tfSend, 0, 3, 3, 1, 1, 0);

		pnlSend = new JPanel(new FlowLayout(FlowLayout.LEFT));

		btnSend = new JButton("보내기");
		pnlSend.add(btnSend);
		pnlSend.add(btnClose);
		pnlSend.add(btnTest);
		this.addGrid(gbl, gbc, pnlSend, 3, 3, 1, 1, 1, 0);

		event();

	}

	// 채팅방 연결 메서드

	public void callChatRoom(MemberDTO dto) { // 아이디가 null일 경우 채팅방 생성, 아이디가 ""일 경우 채팅방 재연결
		if (id == null) {
			isStaff = dto.isStaff();
			id = dto.getId();
			mapChat.put(id, taShow);
			modelChat.addElement(id);
			listChat.setSelectedIndex(0);
			connectionChat(ClientSetting.SERVER_IP, ClientSetting.CHAT_PORT);
		} else if (id.equals("")) {
			id = dto.getId();
			connectionChat(ClientSetting.SERVER_IP, ClientSetting.CHAT_PORT);
		}
	}

	// 이벤트 추가

	private void event() {
		listChat.addListSelectionListener(this);
		btnSend.addActionListener(this);
		tfSend.addActionListener(this);
		btnClose.addActionListener(this);
		btnTest.addActionListener(this);
	}

	// 유틸리티 메서드(레이아웃, 간단한 변환 등)

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

	private String convertId(String id) { // 보낼때 공백 포함하여 아이디 12자리로 맞춰 만들기

		StringBuffer convertId = new StringBuffer(id);
		for (int i = convertId.length(); i < 12; i++) {
			convertId.append(" ");
		}
		return convertId.toString();
	}

	// 기능 메서드(핵심 기능들)

	public void closeChatRoom() {
		if (listChat.getSelectedValue() != null) {
			String cvToId = convertId(listChat.getSelectedValue()); // 현재는 관리자가 손님 챗방에서 강퇴 가능
			pw.println("|||EXIT|||" + cvToId);
			pw.flush();
		}
	}

	public void addChatArea(String fromId) {
		if (!mapChat.containsKey(fromId)) { // 메시지 보낸 손님 채팅방이 없다면 채팅방 생성
			JOptionPane.showMessageDialog(this, fromId + "님께서 문의요청이 들어왔습니다.");
			modelChat.addElement(fromId);
			JTextArea taNew = new JTextArea();
			mapChat.put(fromId, taNew);
		}
	}

	public void connectionChat(String server, int port) {
		// 소켓 연결, 리더라이터 연결, 스태프여부, 아이디 전송, 스레드 돌림
		pw = null;
		br = null;
		try {
			socket = new Socket(server, port);
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String chatStr = isStaff ? ("|||MEET|||" + convertId(id) + "stf") : ("|||MEET|||" + convertId(id) + "cli");
		pw.println(chatStr);
		pw.flush();
		Thread t = new Thread(this);
		t.start();
	}

	// 이벤트 처리

	@Override
	public void valueChanged(ListSelectionEvent e) {
		scrollChat.setViewportView(mapChat.get(listChat.getSelectedValue())); // 누른 아이디 채팅창 띄워줌
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnSend || e.getSource() == tfSend) {

			String cvToId = convertId(listChat.getSelectedValue()); // 받는사람 아이디 12자리로 변환 생성
			String msg = "|||SEND|||" + cvToId + tfSend.getText(); // SEND코드+받는사람 아이디+메시지 발송
			pw.println(msg);
			pw.flush();
			tfSend.setText("");
		}

		if (e.getSource() == btnClose) { // 패널 바뀔 때 자동 채팅 종료하도록 모두 추가해야함!!!!!!!!!
			closeChatRoom();
		}
	}

	@Override
	public void run() {
		String msg = null;
		JTextArea textArea = mapChat.get(id);
		String senderType = null;
		String toId = null;
		String command = null;
		while (true) {

			try {
				msg = br.readLine();
				if (msg == null) {
					br.close();
					pw.close();
					socket.close();
					System.out.println("강퇴당함");
					break;
				} else { // 아니라면 명령어와 보낸사람 아이디 저장
					command = msg.substring(0, 10);
					toId = msg.substring(10, 22).trim();
				}

				if (command.equals("|||EXIT|||")) { // 종료체크
					if (toId.equals(id)) { // 종료와 함께 온 아이디가 나라면 종료
						br.close();
						pw.close();
						socket.close();
						id = "";
						break;
					} else if (isStaff) { // 내 아이디가 아니고 내가 스태프라면 누가 종료했는지 메시지 추가
						mapChat.get(toId).append(toId + "님께서 채팅을 종료하셨습니다.+\n");
					}
				} else if (command.equals("|||MEET|||")) { // 첫 채팅방 입장일 때 아이디 리스트에 추가, 매핑된 아이디와 텍스트영역추가
					System.out.println("MEET로 들어옵니다. 메시지 : " + msg);
					senderType = msg.substring(22, 25);
					if (isStaff) { // 내가 직원이라면
						addChatArea(toId);
					}
				} else if (command.equals("|||SEND|||")) {

					if (isStaff) { // 스태프고 채팅방이 없다면
						addChatArea(toId);
					}
					String fromId = msg.substring(22, 34).trim();
					String fromMsg = msg.substring(34);

					textArea = mapChat.get(toId); // 보낸 사람 아이디의 채팅방의 텍스트아레아에 내용 추가
					textArea.append("[" + fromId + "] " + fromMsg + "\n");
					textArea.setCaretPosition(textArea.getText().length());
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

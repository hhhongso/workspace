//db연결 시, 변수명과 컬럼명을 동일하게 한다.


package friend.action;

import friend.dao.FriendDAO;
import friend.bean.FriendDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FriendManager extends JFrame implements ActionListener, ListSelectionListener {
	private JLabel nameL, telL, telhyphenL, telhyphenL2, sexL, hobbyL, inputL, dispL, infoL;
	private JTextField nameT, tel2T, tel3T; 
	private JComboBox<String> tel1C;
	private JRadioButton manR, womanR; 
	private JCheckBox readCB, movieCB, musicCB, gameCB, shoppingCB; 
	private JList<FriendDTO> jlist; //Jlist: model 들어감요 , scroll도 있어야 
	private DefaultListModel<FriendDTO> model;
	private JTextArea area;
	private JButton regitB, editB, delB, clearB;
	private JPanel southP, northP, eastP, westP; 
	private JPanel[] westAr;	
	
	private ArrayList<FriendDTO> list;
	
	public FriendManager() {		
		nameL = new JLabel("이       름:");
		telL = new JLabel("전화번호:");
		telhyphenL = new JLabel(" - ");
		telhyphenL2 = new JLabel(" - ");
		sexL = new JLabel("성       별:");
		hobbyL = new JLabel("취       미:");
		inputL = new JLabel("개인정보입력");
		dispL = new JLabel("전체목록");
		infoL = new JLabel("개인정보분석");
		
		nameT = new JTextField(10);
		tel2T = new JTextField(5);
		tel3T = new JTextField(5);
		
		String[] telAr = new String[] {"010", "011", "019"};
		tel1C = new JComboBox<String>(telAr);
		
		womanR = new JRadioButton("여성", true);
		manR = new JRadioButton("남성");
		
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(womanR);
		bgroup.add(manR);
		
		readCB = new JCheckBox("독서");
		movieCB = new JCheckBox("영화");
		musicCB = new JCheckBox("음악");
		gameCB = new JCheckBox("게임");
		shoppingCB = new JCheckBox("쇼핑");		
		readCB.setSelected(true);		

		//model = new DefaultListModel<FriendDTO>(); 		
		//jlist = new JList<FriendDTO>(model); 이래도 되고
		jlist = new JList<FriendDTO>(new DefaultListModel<FriendDTO>());
		model = (DefaultListModel<FriendDTO>)jlist.getModel();
		
		JScrollPane scroll = new JScrollPane(jlist);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		area = new JTextArea(8,50);
		JScrollPane scroll2 = new JScrollPane(area);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);	
		area.setEditable(false);

		regitB = new JButton("등록");
		editB = new JButton("수정");
		delB = new JButton("삭제");
		clearB = new JButton("지우기");		
		
		regitB.setEnabled(true);
		editB.setEnabled(false);
		delB.setEnabled(false);
		clearB.setEnabled(true);	
		
		southP = new JPanel();
		northP = new JPanel();
		eastP = new JPanel();
		westP = new JPanel();
		westAr = new JPanel[6];
		
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		eastP.setLayout(new FlowLayout(FlowLayout.CENTER));
		westP.setLayout(new GridLayout(6,1,5,5));
		southP.setLayout(new FlowLayout(FlowLayout.CENTER));	
		northP.setLayout(new BorderLayout());
		
		for (int i = 0; i < westAr.length; i++) {
			westAr[i] = new JPanel();
			westP.add(westAr[i]);
		}
		westAr[0].setLayout(new FlowLayout(FlowLayout.CENTER));
		westAr[1].setLayout(new FlowLayout(FlowLayout.LEFT));
		westAr[2].setLayout(new FlowLayout(FlowLayout.LEFT));
		westAr[3].setLayout(new FlowLayout(FlowLayout.LEFT));
		westAr[4].setLayout(new FlowLayout(FlowLayout.LEFT));
		westAr[5].setLayout(new FlowLayout(FlowLayout.CENTER));		
		
		eastP.add(dispL);
		eastP.add(scroll);
		
		westAr[0].add(inputL);
		
		westAr[1].add(nameL);
		westAr[1].add(nameT);
		
		westAr[2].add(telL);
		westAr[2].add(tel1C);
		westAr[2].add(telhyphenL);
		westAr[2].add(tel2T);
		westAr[2].add(telhyphenL2);
		westAr[2].add(tel3T);
		
		westAr[3].add(sexL);
		westAr[3].add(womanR);
		westAr[3].add(manR);
		
		westAr[4].add(hobbyL);
		westAr[4].add(readCB);
		westAr[4].add(movieCB);
		westAr[4].add(musicCB);
		westAr[4].add(gameCB);
		westAr[4].add(shoppingCB);
		
		westAr[5].add(regitB);
		westAr[5].add(editB);
		westAr[5].add(delB);
		westAr[5].add(clearB);
		
		southP.add(infoL);
		southP.add("Center", scroll2);

		northP.add("Center", eastP);
		northP.add("West", westP);
		
		con.add("North", northP);
		con.add("Center", southP);

		con.setBackground(Color.ORANGE);
		
		setBounds(700, 100, 650, 500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//DB에서 모든 레코드를 꺼내 와 jlist 에 출력
		FriendDAO dao = FriendDAO.getInstance();
		list = dao.getFriendDisp();

			for(FriendDTO dto : list) {
				model.addElement(dto);
			}

		
	}


//main =======================================================================================================================================

	private void event() {
		regitB.addActionListener(this);
		editB.addActionListener(this);
		delB.addActionListener(this);
		clearB.addActionListener(this);
		
		jlist.addListSelectionListener(this);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == regitB) {
			//1. 데이터 받아오기
			String name = nameT.getText();
			String tel1 = (String) tel1C.getSelectedItem();
			String tel2 = tel2T.getText();
			String tel3 = tel3T.getText();
			
			int sex = 0; 			
			if(womanR.isSelected()) { 	sex = 1;}
			else { sex = 0; }
			
			int read = readCB.isSelected() ? 1 : 0;
			int movie = movieCB.isSelected() ? 1 : 0;
			int music = musicCB.isSelected() ? 1 : 0;
			int game = gameCB.isSelected() ? 1 : 0;
			int shopping = shoppingCB.isSelected() ? 1 : 0;

			FriendDTO dto = new FriendDTO();
			dto.setName(name);
			dto.setTel1(tel1);
			dto.setTel2(tel2);
			dto.setTel3(tel3);
			dto.setSex(sex);
			dto.setRead(read);
			dto.setMovie(movie);
			dto.setMusic(music);
			dto.setGame(game);
			dto.setShopping(shopping);
			
			//2. DB 연결하기하여 insert			
			FriendDAO dao = FriendDAO.getInstance(); //DAO는 한번만 생성하고 프로그램이 종료될 때까지 같은 것을 사용한다 >>> singleTon
			int seq = dao.getSeq(); // DB에서 시퀀스 번호 가져오기
			dto.setSeq(seq);			
			
			int count = dao.regitFriend(dto);
			clear();
			
			//3. 응답: 분석 란에 "데이터 등록 완료" => 목록 란에 등록된 이름을 출력
			if(count == 1) area.setText(count + "row created.");
			else area.setText("등록 실패");
			model.addElement(dto);
// 수정 ==============================================================================================================================	
		} else if(e.getSource() == editB) {			
			// DB로부터 데이터를 얻어온 뒤 dto로 묶기.  == regitB에서와 동일 
			String name = nameT.getText();
			String tel1 = (String) tel1C.getSelectedItem();
			String tel2 = tel2T.getText();
			String tel3 = tel3T.getText();
			
			int sex = 0; 			
			if(womanR.isSelected()) { 	sex = 1;}
			else { sex = 0; }
			
			int read = readCB.isSelected() ? 1 : 0;
			int movie = movieCB.isSelected() ? 1 : 0;
			int music = musicCB.isSelected() ? 1 : 0;
			int game = gameCB.isSelected() ? 1 : 0;
			int shopping = shoppingCB.isSelected() ? 1 : 0;
			
			FriendDTO dto = new FriendDTO();
			dto.setName(name);
			dto.setTel1(tel1);
			dto.setTel2(tel2);
			dto.setTel3(tel3);
			dto.setSex(sex);
			dto.setRead(read);
			dto.setMovie(movie);
			dto.setMusic(music);
			dto.setGame(game);
			dto.setShopping(shopping);
			
			int seq = jlist.getSelectedValue().getSeq();
			dto.setSeq(seq);
			
			// DB의 내용을 update한다.
			FriendDAO dao = FriendDAO.getInstance();			
			int count = dao.editFriend(dto);
			
			// 데이터 수정 완료 => 변경 내용을 jlist에도 적용. textArea에 '수정완료' 출력
			clear();
			if(count == 1) area.setText(count + "row(s) updated.");
			else area.setText("데이터 업데이트 실패");
			model.set(jlist.getSelectedIndex(), dto);
// 삭제 ==============================================================================================================================
		} else if(e.getSource() == delB) {			
			//seq를 가지고 옴
			int seq = jlist.getSelectedValue().getSeq();
			
			// DB 연결하여 해당 seq의 정보를 delete
			FriendDAO dao = FriendDAO.getInstance();			
			int count = dao.deleteFriend(seq);
			
			// 데이터 삭제 완료 => jlist에서도 삭제. textArea에 '삭제완료' 출력
			clear();
			if(count == 1) area.setText(count + "row(s) deleted.");
			else area.setText("데이터 삭제 실패");
			model.remove(jlist.getSelectedIndex());
// 지우기 ==============================================================================================================================
		} else if(e.getSource() == clearB) {
			clear();
			regitB.setEnabled(true);
			editB.setEnabled(false);
			delB.setEnabled(false);
			clearB.setEnabled(false);
	
			
		}
		
	} // actionPerformed
	
	
	@Override //클릭 누를 때 , 땔 때 두 번 호출한다. 
	public void valueChanged(ListSelectionEvent e) {
		System.out.println("index: " + jlist.getSelectedIndex());
		if(jlist.getSelectedIndex() == -1) return; //해당 인덱스가 없으면 return 으로 메소드를 빠져 나간다. 
		
		FriendDTO dto = jlist.getSelectedValue();
		nameT.setText(dto.getName());
		tel1C.setSelectedItem(dto.getTel1());
		tel2T.setText(dto.getTel2());
		tel3T.setText(dto.getTel3());
		int sex = 0; 
		if(dto.getSex() == 1) {womanR.setSelected(true);}
		else { manR.setSelected(true);	}
		if(dto.getRead() == 1) {readCB.setSelected(true);} 
		else { readCB.setSelected(false); }
		if(dto.getMovie() == 1) {movieCB.setSelected(true);}
		else {movieCB.setSelected(false);}
		if(dto.getMusic() == 1) {musicCB.setSelected(true);}
		else {musicCB.setSelected(false);}
		if(dto.getGame() == 1) {gameCB.setSelected(true);}
		else {gameCB.setSelected(false);}
		
		shoppingCB.setSelected(dto.getShopping() == 1 ? true : false);
		
		regitB.setEnabled(false);
		editB.setEnabled(true);
		delB.setEnabled(true);
		clearB.setEnabled(true);
		}


	
	private void clear() {
		nameT.setText("");
		tel1C.setSelectedItem("010");		//tel1C.setSelectedIndex(0);
		tel2T.setText("");
		tel3T.setText("");
		womanR.setSelected(true);
		readCB.setSelected(false);
		movieCB.setSelected(false);
		musicCB.setSelected(false);
		gameCB.setSelected(false);
		shoppingCB.setSelected(false);
		
		area.setText("");
	}


//main =======================================================================================================================================
	public static void main(String[] args) {
		new FriendManager().event();

	}







}

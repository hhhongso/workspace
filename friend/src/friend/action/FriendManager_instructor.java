package friend.action;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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

import friend.bean.FriendDTO;
import friend.dao.FriendDAO;

public class FriendManager_instructor extends JFrame implements ActionListener, ListSelectionListener{
	private JLabel infoinputL, nameL, telL, sexL, hobbyL, tot_listL, infoL, dashL1, dashL2;
	private JTextField nameT, tel2T, tel3T;
	private JComboBox<String> tel1C;
	private JRadioButton manR, womanR;
	private JCheckBox readCB, movieCB, musicCB, gameCB, shoppingCB;
	private JList<FriendDTO> list;
	private DefaultListModel<FriendDTO> model;
	private JTextArea area;
	private JButton addB, updateB, deleteB, clearB;

	public FriendManager_instructor() {
		setTitle("Friend Manager");
		JPanel pW1 = new JPanel();
		pW1.setBackground(Color.YELLOW);
		infoinputL = new JLabel("개인정보입력");
		pW1.add(infoinputL);

		JPanel pW2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pW2.setBackground(Color.YELLOW);
		nameL = new JLabel("이     름 : ");
		nameT = new JTextField(15);
		pW2.add(nameL);
		pW2.add(nameT);

		JPanel pW3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pW3.setBackground(Color.YELLOW);
		telL = new JLabel("전화번호 : ");
		String[] cItems = { "010", "011", "070", "02", "031", "032", "033", "041", "042", "043", "044", "051", "052",
				"053", "054", "055", "061", "062", "063", "064" };
		tel1C = new JComboBox<String>(cItems);
		dashL1 = new JLabel("-");
		tel2T = new JTextField(5);
		dashL2 = new JLabel("-");
		tel3T = new JTextField(5);
		pW3.add(telL);
		pW3.add(tel1C);
		pW3.add(dashL1);
		pW3.add(tel2T);
		pW3.add(dashL2);
		pW3.add(tel3T);

		JPanel pW4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pW4.setBackground(Color.YELLOW);
		sexL = new JLabel("성     별 : ");
		manR = new JRadioButton("남성", true);
		manR.setBackground(Color.YELLOW);
		womanR = new JRadioButton("여성");
		womanR.setBackground(Color.YELLOW);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(manR);
		btnGroup.add(womanR);
		
		pW4.add(sexL);
		pW4.add(manR);
		pW4.add(womanR);

		JPanel pW5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pW5.setBackground(Color.YELLOW);
		hobbyL = new JLabel("취미");
		readCB = new JCheckBox("독서");
		readCB.setBackground(Color.YELLOW);
		movieCB = new JCheckBox("영화");
		movieCB.setBackground(Color.YELLOW);
		musicCB = new JCheckBox("음악");
		musicCB.setBackground(Color.YELLOW);
		gameCB = new JCheckBox("게임");
		gameCB.setBackground(Color.YELLOW);
		shoppingCB = new JCheckBox("쇼핑");
		shoppingCB.setBackground(Color.YELLOW);
		pW5.add(hobbyL);
		pW5.add(readCB);
		pW5.add(movieCB);
		pW5.add(musicCB);
		pW5.add(gameCB);
		pW5.add(shoppingCB);

		JPanel pW6 = new JPanel();
		pW6.setBackground(Color.YELLOW);
		addB = new JButton("등록");
		updateB = new JButton("수정");
		deleteB = new JButton("삭제");
		clearB = new JButton("지우기");
		
		addB.setEnabled(true);
		updateB.setEnabled(false);
		deleteB.setEnabled(false);
		clearB.setEnabled(false);

		pW6.add(addB);
		pW6.add(updateB);
		pW6.add(deleteB);
		pW6.add(clearB);

		JPanel pWest = new JPanel(new GridLayout(6, 1));
		pWest.setBackground(Color.YELLOW);
		pWest.add(pW1);
		pWest.add(pW2);
		pWest.add(pW3);
		pWest.add(pW4);
		pWest.add(pW5);
		pWest.add(pW6);
//-----------------------------------------
		JPanel pEast = new JPanel(new BorderLayout());
		JPanel pE1 = new JPanel();
		pE1.setBackground(Color.YELLOW);
		tot_listL = new JLabel("전체목록            ");
		pE1.add(tot_listL);

		JPanel pE2 = new JPanel();
		pE2.setBackground(Color.YELLOW);
		
		list = new JList<FriendDTO>(new DefaultListModel<FriendDTO>());
		model = (DefaultListModel<FriendDTO>)list.getModel();
		
		JScrollPane scroll = new JScrollPane(list);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(300, 250));
		pE2.add(scroll);
		pEast.add("North", pE1);
		pEast.add("Center", pE2);
//-----------------------------------------
		JPanel pSouth = new JPanel(new BorderLayout());

		JPanel pS1 = new JPanel();
		pS1.setBackground(Color.YELLOW);
		infoL = new JLabel("개인정보분석");
		pS1.add(infoL);

		JPanel pS2 = new JPanel();
		pS2.setBackground(Color.YELLOW);
		area = new JTextArea(5, 50);
		JScrollPane scroll2 = new JScrollPane(area);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pS2.add(scroll2);

		pSouth.add("North", pS1);
		pSouth.add("Center", pS2);

		Container contentPane = this.getContentPane();
		contentPane.add("West", pWest);
		contentPane.add("East", pEast);
		contentPane.add("South", pSouth);
		contentPane.setBackground(Color.YELLOW);

		setBounds(50, 50, 630, 520);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//DB에서 모든 레코드들을 꺼내서 JList 뿌리기
		FriendDAO dao = FriendDAO.getInstance();
		ArrayList<FriendDTO> arrayList = dao.getFriendList();
		
		for(FriendDTO dto : arrayList) {
			model.addElement(dto);
		}

	}//생성자

	private void event() {
		addB.addActionListener(this);
		
		list.addListSelectionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addB) {
			//데이터
			String name = nameT.getText();
			String tel1 = (String)tel1C.getSelectedItem();
			String tel2 = tel2T.getText();
			String tel3 = tel3T.getText();
			int gender=0;
			if(manR.isSelected())
				gender = 0;
			else if(womanR.isSelected())
				gender = 1;
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
			dto.setGender(gender);
			dto.setRead(read);
			dto.setMovie(movie);
			dto.setMusic(music);
			dto.setGame(game);
			dto.setShopping(shopping);		
			
			//DB
			FriendDAO dao = FriendDAO.getInstance();
			
			int seq = dao.getSeq();
			dto.setSeq(seq);
			int su = dao.insertFriend(dto);
			
			//응답
			clear();
			
			if(su==1)
				area.setText("\n\t\t 데이터 등록 완료");
			else 
				area.setText("\n\t\t 데이터 등록 실패");
			
			model.addElement(dto);
			
		}
		
	}
	
	public void clear() {
		nameT.setText("");
		tel1C.setSelectedItem("010");
		tel2T.setText("");
		tel3T.setText("");
		manR.setSelected(true);
		readCB.setSelected(false);
		movieCB.setSelected(false);
		musicCB.setSelected(false);
		gameCB.setSelected(false);
		shoppingCB.setSelected(false);
		
		area.setText("");
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		FriendDTO dto = list.getSelectedValue();
		nameT.setText(dto.getName());
		tel1C.setSelectedItem(dto.getTel1());
		tel2T.setText(dto.getTel2());
		tel3T.setText(dto.getTel3());
		if (dto.getGender() == 0) {
			manR.setSelected(true);
		} else {
			womanR.setSelected(true);
		}
		readCB.setSelected(dto.getRead()==1 ? true : false);
		movieCB.setSelected(dto.getMovie()==1 ? true : false);
		musicCB.setSelected(dto.getMusic()==1 ? true : false);
		gameCB.setSelected(dto.getGame()==1 ? true : false);
		shoppingCB.setSelected(dto.getShopping()==1 ? true : false);
		
		addB.setEnabled(false);
		updateB.setEnabled(true);
		deleteB.setEnabled(true);
		clearB.setEnabled(true);
	}
	
	public static void main(String[] args) {
		new FriendManager().event();
	}
}// class















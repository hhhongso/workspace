package bitProject.cafe.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import bitProject.cafe.dto.BoardDTO;
import bitProject.cafe.dto.MemberDTO;

public class BoardNew extends JFrame implements ActionListener {
	private JTextField tfText;
	private JButton btnConfirm, btnCancle;
	private JLabel lblId, lblId2, lblText;
	private String writeTime;
	
	private MemberDTO member;
	private DefaultTableModel model;
	private ArrayList<BoardDTO> listBoard;



	public BoardNew() { // constructor
	
	} // constructor
	
	public BoardNew(MemberDTO member, DefaultTableModel model, ArrayList<BoardDTO> listBoard) { // constructor for newRow
		this.member = member;
		this.model = model;
		this.listBoard = listBoard;
		
		
		getContentPane().setLayout(null);

		tfText = new JTextField();
		tfText.setBounds(123, 54, 530, 25);
		getContentPane().add(tfText);
		tfText.setColumns(10);

		lblId = new JLabel("작성자"); // 작성자 라벨
		lblId.setBounds(47, 16, 64, 39);
		getContentPane().add(lblId);

		lblId2 = new JLabel(member.getId()); // MemberDTO - BoardDTO에서 받아온 ID 출력 라벨 dto.getId()
		lblId2.setBounds(123, 29, 57, 15);
		getContentPane().add(lblId2);

		lblText = new JLabel("내용"); // 내용 라벨
		lblText.setBounds(47, 48, 48, 36);
		getContentPane().add(lblText);

		btnConfirm = new JButton("확인"); // 확인 버튼
		btnCancle = new JButton("취소"); // 취소 버튼

		JPanel pnlBottom = new JPanel(); // 아래쪽 버튼 묶어주는 패널
		pnlBottom.setBounds(0, 87, 694, 34);
		pnlBottom.add(btnConfirm);
		pnlBottom.add(btnCancle);
		getContentPane().add(pnlBottom);

		// 작성일 생성
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar time = Calendar.getInstance();
		writeTime = sdf.format(time.getTime());

		// setLocation(); 지금 명확한 위치를 몰라서 안해놓았는데 꼭 나중에 위치 지정할 것
		setTitle("게시판 글쓰기");
		setSize(700, 160);
		setResizable(false);
		setVisible(true);

		// 이벤트 생성
		btnConfirm.addActionListener(this);
		btnCancle.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConfirm) {
			String tfTextLine = tfText.getText();
//			BoardAction ba = new BoardAction();
//			ba.addRow(member, model, listBoard, tfTextLine, writeTime);
			setVisible(false);
		} else if (e.getSource() == btnCancle) {
			setVisible(false);
		}
	}

	
}





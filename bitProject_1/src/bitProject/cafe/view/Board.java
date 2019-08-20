package bitProject.cafe.view;

// 메인페이지 하단부에 등장하는 게시판
// Board : 메인 패널
// BoardNew : 글쓰기 버튼을 눌렀을 때 새로 뜨는 JFrame, BoardAction으로 줄 생성 데이터를 넘겨줌
// BoardAction : JTable 줄 생성과 삭제
// BoardDTO : JTable 기본 내용
//

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import bitProject.cafe.dto.BoardDTO;
import bitProject.cafe.dto.MemberDTO;

public class Board extends JPanel implements ActionListener {
	private JButton btnAdd, btnDelete;
	private JTable tblBoard;
	private Vector<String> vector;
	private DefaultTableModel model;
	private MemberDTO member;
	private ArrayList<BoardDTO> listBoard;


	public Board(MemberDTO member) { // constructor : MainFrame에서 member를 던져주므로 생성자에서 받아야함
		this.member = member; // MemberDTO의 모든 필드 가져오기 : member.getId()
		
		// ArrayList 생성 : 맨 처음 한번만 만들어져야 하는 것!!
		listBoard = new ArrayList<BoardDTO>();
		
		// Vector로 열 데이터 입력
		vector = new Vector<String>();
		vector.addElement("글번호");
		vector.addElement("내용");
		vector.addElement("작성자");
		vector.addElement("작성일");

		// JTable에 적용시킬 model 선언
		model = new DefaultTableModel(vector, 0){ 
			@Override // JTable 더블클릭으로 수정 여부
			public boolean isCellEditable(int r, int c) { 
				return false; // 수정 불가
			}
		};

		// 글쓰기 버튼과 삭제 버튼
		btnAdd = new JButton("글쓰기");
		btnAdd.setBounds(1021, 467, 69, 23);

		btnDelete = new JButton("삭제");
		btnDelete.setBounds(1102, 467, 69, 23);

		// 전체적인 JTable 레이아웃
		tblBoard = new JTable();
		tblBoard.setModel(model); // JTable에 모델 적용
		tblBoard.setRowHeight(25); // 한 줄 높이 설정
		tblBoard.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // JTable 강제로 간격 설정되는 것 컨트롤을 위해 Auto Resize 끄기
		tblBoard.getColumn("글번호").setPreferredWidth(50);
		tblBoard.getColumn("내용").setPreferredWidth(800);
		tblBoard.getColumn("작성자").setPreferredWidth(130);
		tblBoard.getColumn("작성일").setPreferredWidth(200);

		// 텍스트 가운데 정렬
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		tblBoard.getColumn("글번호").setCellRenderer(celAlignCenter);
		tblBoard.getColumn("내용").setCellRenderer(celAlignCenter);
		tblBoard.getColumn("작성자").setCellRenderer(celAlignCenter);
		tblBoard.getColumn("작성일").setCellRenderer(celAlignCenter);
		
		// 최대 한줄만 선택할 수 있게 하기
		tblBoard.setRowSelectionAllowed(true);
		tblBoard.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// 세로 줄 안보이게 하기
		tblBoard.setShowVerticalLines(false);
		// JTable 컬럼 누르고 움직이면 위치 바꿀 수 있는 것 막기
		tblBoard.getTableHeader().setReorderingAllowed(false);


		// JTable에 JScrollPane추가
		JScrollPane scroll = new JScrollPane(tblBoard);
		// 언제나 세로 스크롤 보여주기
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// 전체적인 Board 패널 크기 지정
		scroll.setPreferredSize(new Dimension(1200, 450));

		// 패널 잡기
		JPanel pnlMain = new JPanel();
		JPanel pnlBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pnlMain.setBounds(-5, 0, 1200, 460);
		pnlBottom.setBounds(0, 460, 1200, 40);

		pnlMain.add(scroll);
		pnlBottom.add(btnAdd);
		pnlBottom.add(btnDelete);

		// MainFrame에서 패널을 불러올 수 있게 최종 레이아웃 잡기
		this.setBounds(0, 0, 1200, 500);
		this.add(pnlMain);
		this.add(pnlBottom);

		// Board 이벤트 생성
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);

	} // 생성자
	
	@Override
	public void actionPerformed(ActionEvent e) { // ActionListener 이벤트
		if (e.getSource() == btnAdd) addRow(); // 글쓰기 버튼
		else if (e.getSource() == btnDelete) deleteRow(); // 지우기 버튼
	}

	private void addRow() { // 열 추가하기
		// JTable을 컨트롤 해야하므로 model도 다시 선언해서 보냄
		model = (DefaultTableModel) tblBoard.getModel(); 
		
		// member.getID()를 실행할 수 있게 MemberDTO와, 행을 추가하기 위해  JTable model를 패러미터로 보냅니다
		new BoardNew(member, model, listBoard);		
	}

	private void deleteRow() { // 선택한 열 삭제하기
		if (tblBoard.getSelectedRow() != -1) {
			int select = tblBoard.getSelectedRow();
			System.out.println(select);
	
//			BoardAction ba = new BoardAction();
			// JTable을 컨트롤 해야하므로 model도 다시 선언해서 보냄
			model = (DefaultTableModel) tblBoard.getModel();
			// 해당 ArrayList도 지워야하므로 BoardNew에 있는 removeRow메소드로 보냄
//			ba.removeRow(listBoard, select, model);
			

			JOptionPane.showMessageDialog(this, "선택한 글을 삭제하였습니다", "삭제", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "삭제할 글을 선택해주세요", "삭제", JOptionPane.ERROR_MESSAGE);
		}
	}
}


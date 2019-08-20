package bitProject.cafe.view;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import bitProject.cafe.dao.RoomDAO;
import bitProject.cafe.dto.MemberDTO;
import bitProject.cafe.dto.RoomDTO;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class MyInfomation extends JPanel implements ActionListener {

	private JTextField tfId;
	private JPasswordField ptfPwCurr;
	private JPasswordField ptfPwNew;
	private JPasswordField ptfPwNewRe;
	private JTextField tfName;
	private JTextField tfEmailAccount;
	private JTextField tfEmailDomain;
	private JTextField tfTel1;
	private JTextField tfTel2;
	private JTextField tfTel3;
	private JTextField tfYear;
	private JTextField tfMonth;
	private JTextField tfDate;
	private MemberDTO member;

	private JTable tableReservationList;
	private DefaultTableModel modelRoomList;
	private Vector<String> vtColName;
	private Vector<Vector<Integer>> reservationList;

	private JButton btnUpdateReservation;
	private JButton btnCancel;

	private JPanel pnlRoomList;

	public MyInfomation(MemberDTO member) {
		this.member = member;

		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 1200, 500));
		setLayout(null);

		JPanel pnlStatus = new JPanel();
		pnlStatus.setBounds(12, 10, 416, 480);
		add(pnlStatus);
		pnlStatus.setLayout(null);

		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(15, 32, 54, 23);
		pnlStatus.add(lblId);
		lblId.setFont(new Font("나눔바른고딕", Font.BOLD, 20));

		JLabel lblPwCurr = new JLabel("이전 비밀번호");
		lblPwCurr.setBounds(15, 83, 122, 23);
		pnlStatus.add(lblPwCurr);
		lblPwCurr.setFont(new Font("나눔바른고딕", Font.BOLD, 20));

		JLabel lblPwNew = new JLabel("새 비밀번호");
		lblPwNew.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		lblPwNew.setBounds(15, 134, 122, 23);
		pnlStatus.add(lblPwNew);

		JLabel lblPwNewRe = new JLabel("비밀번호 재확인");
		lblPwNewRe.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		lblPwNewRe.setBounds(15, 186, 160, 23);
		pnlStatus.add(lblPwNewRe);

		JLabel lblName = new JLabel("이름");
		lblName.setBounds(15, 237, 36, 23);
		pnlStatus.add(lblName);
		lblName.setFont(new Font("나눔바른고딕", Font.BOLD, 20));

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(15, 290, 54, 23);
		pnlStatus.add(lblEmail);
		lblEmail.setFont(new Font("나눔바른고딕", Font.BOLD, 20));

		JLabel lblTelNum = new JLabel("전화번호");
		lblTelNum.setBounds(12, 348, 72, 23);
		pnlStatus.add(lblTelNum);
		lblTelNum.setFont(new Font("나눔바른고딕", Font.BOLD, 20));

		JLabel lblBirthDay = new JLabel("생년월일");
		lblBirthDay.setBounds(12, 408, 72, 23);
		pnlStatus.add(lblBirthDay);
		lblBirthDay.setFont(new Font("나눔바른고딕", Font.BOLD, 20));

		tfId = new JTextField();
		tfId.setText(member.getId());
		tfId.setEditable(false);
		tfId.setBounds(180, 30, 226, 23);
		pnlStatus.add(tfId);
		tfId.setColumns(10);

		ptfPwCurr = new JPasswordField();
		ptfPwCurr.setBounds(180, 85, 226, 21);
		pnlStatus.add(ptfPwCurr);

		ptfPwNew = new JPasswordField();
		ptfPwNew.setBounds(180, 135, 226, 21);
		pnlStatus.add(ptfPwNew);

		ptfPwNewRe = new JPasswordField();
		ptfPwNewRe.setBounds(180, 185, 226, 21);
		pnlStatus.add(ptfPwNewRe);

		tfName = new JTextField();
		tfName.setText(member.getName());
		tfName.setEditable(false);
		tfName.setColumns(10);
		tfName.setBounds(180, 235, 226, 23);
		pnlStatus.add(tfName);

		tfEmailAccount = new JTextField();
		tfEmailAccount.setText(member.getEmailAccount());
		tfEmailAccount.setColumns(10);
		tfEmailAccount.setBounds(180, 290, 94, 23);
		pnlStatus.add(tfEmailAccount);

		tfEmailDomain = new JTextField();
		tfEmailDomain.setText(member.getEmailDomain());
		tfEmailDomain.setColumns(10);
		tfEmailDomain.setBounds(310, 290, 94, 23);
		pnlStatus.add(tfEmailDomain);

		tfTel1 = new JTextField();
		tfTel1.setText(member.getTel1());
		tfTel1.setColumns(10);
		tfTel1.setBounds(180, 350, 54, 23);
		pnlStatus.add(tfTel1);

		JLabel lblHyphen = new JLabel("-");
		lblHyphen.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		lblHyphen.setBounds(237, 350, 17, 23);
		pnlStatus.add(lblHyphen);

		tfTel2 = new JTextField();
		tfTel2.setText(member.getTel2());
		tfTel2.setColumns(10);
		tfTel2.setBounds(254, 350, 66, 23);
		pnlStatus.add(tfTel2);

		tfTel3 = new JTextField();
		tfTel3.setText(member.getTel3());
		tfTel3.setColumns(10);
		tfTel3.setBounds(338, 350, 66, 23);
		pnlStatus.add(tfTel3);

		tfYear = new JTextField();
		tfYear.setText("" + member.getBirthYear());
		tfYear.setEditable(false);
		tfYear.setColumns(10);
		tfYear.setBounds(180, 405, 72, 23);
		pnlStatus.add(tfYear);

		tfMonth = new JTextField();
		tfMonth.setText("" + member.getBirthMonth());
		tfMonth.setEditable(false);
		tfMonth.setColumns(10);
		tfMonth.setBounds(278, 405, 41, 23);
		pnlStatus.add(tfMonth);

		tfDate = new JTextField();
		tfDate.setText("" + member.getBirthDate());
		tfDate.setEditable(false);
		tfDate.setColumns(10);
		tfDate.setBounds(346, 405, 41, 23);
		pnlStatus.add(tfDate);

		JLabel lblYear = new JLabel("년");
		lblYear.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		lblYear.setBounds(254, 405, 24, 23);
		pnlStatus.add(lblYear);

		JLabel lblMonth = new JLabel("월");
		lblMonth.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		lblMonth.setBounds(322, 405, 24, 23);
		pnlStatus.add(lblMonth);

		JLabel lblDate = new JLabel("일");
		lblDate.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		lblDate.setBounds(392, 405, 24, 23);
		pnlStatus.add(lblDate);

		JLabel label = new JLabel("-");
		label.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		label.setBounds(325, 350, 17, 23);
		pnlStatus.add(label);

		JLabel lblAt = new JLabel("@");
		lblAt.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		lblAt.setBounds(281, 290, 24, 23);
		pnlStatus.add(lblAt);

		JButton btnUpdateStatus = new JButton("수정");
		btnUpdateStatus.setBounds(101, 438, 86, 33);
		pnlStatus.add(btnUpdateStatus);

		JButton btnLeave = new JButton("탈퇴");
		btnLeave.setBounds(216, 438, 86, 32);
		pnlStatus.add(btnLeave);

		pnlRoomList = new JPanel();
		pnlRoomList.setBounds(467, 10, 347, 408);
		add(pnlRoomList);
		setTable();

		btnUpdateReservation = new JButton("갱신");
		btnUpdateReservation.setBounds(467, 430, 163, 60);
		add(btnUpdateReservation);

		btnCancel = new JButton("예약취소");
		btnCancel.setEnabled(false);
		btnCancel.setBounds(651, 430, 163, 60);
		add(btnCancel);

		addEvent();
	}

	public void addEvent() {
		btnUpdateReservation.addActionListener(this);
		btnCancel.addActionListener(this);
	}

	@SuppressWarnings("serial")
	public void setTable() {
		setTableCol(); // 테이블 컬럼명 세팅
		getMyReservation(); // DB에서 데이터를 다 가지고 옴.

		// tableModel에 컬럼명, DB에서 가져온 예약리스트를 넣음.
		// 수정 불가능하게 막음.
		modelRoomList = new DefaultTableModel(reservationList, vtColName) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		tableReservationList = new JTable(modelRoomList); // tableModel을 Jtable에 넣음
		tableReservationList.setRowSelectionAllowed(true);
		tableReservationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setAlignmentCenter(tableReservationList); // JTabel 가운데 정렬

		JScrollPane scroll = new JScrollPane(tableReservationList);
		scroll.setPreferredSize(new Dimension(pnlRoomList.getSize()));
		pnlRoomList.add(scroll);
	}

	public void setAlignmentCenter(JTable table) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}

	public void setTableCol() {
		vtColName = new Vector<String>();
		vtColName.add("방 번호");
		vtColName.add("연도");
		vtColName.add("월");
		vtColName.add("일");
		vtColName.add("시작시간");
		vtColName.add("종료시간");
	}

	public void getMyReservation() {
		reservationList = RoomDAO.getInstance().getMyReservation(member.getId());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdateReservation) {
			btnCancel.setEnabled(true);
			for (int i = 0; i < modelRoomList.getRowCount(); i++) {
				modelRoomList.removeRow(i);
				i--;
			}

			getMyReservation();

			for (int i = 0; i < reservationList.size(); i++) {
				modelRoomList.addRow(reservationList.get(i));
			}
		} else if (e.getSource() == btnCancel) {
			int rowIdx = tableReservationList.getSelectedRow();
			if (rowIdx == -1) {
				JOptionPane.showMessageDialog(this, "선택한 예약 리스트가 없습니다.");
				return;
			}

			int roomNum = (Integer) tableReservationList.getValueAt(rowIdx, 0);
			int year = (Integer) tableReservationList.getValueAt(rowIdx, 1);
			int month = (Integer) tableReservationList.getValueAt(rowIdx, 2);
			int date = (Integer) tableReservationList.getValueAt(rowIdx, 3);
			int inHour = (Integer) tableReservationList.getValueAt(rowIdx, 4);
			int outHour = (Integer) tableReservationList.getValueAt(rowIdx, 5);

			int cnt = RoomDAO.getInstance()
					.deleteReservation(new RoomDTO(roomNum, member.getId(), year, month, date, inHour, outHour));

			if (cnt != 0) {
				System.out.println("성공적으로 삭제하였습니다.");
			} else {
				System.out.println("삭제 실패");
				return;
			}

			modelRoomList.removeRow(rowIdx);
			btnCancel.setEnabled(false);
		}
	}
}



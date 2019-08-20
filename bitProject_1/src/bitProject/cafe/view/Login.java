package bitProject.cafe.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import bitProject.cafe.dao.MemberDAO;
import bitProject.cafe.dto.MemberDTO;

public class Login extends JFrame implements ActionListener {

	// 변수 선언
	private MemberDTO OnAccount; // 로그인 성공 시 여기에 계정 저장
	private HashMap<String, MemberDTO> hashMemberDTO;

	private ButtonGroup btnGroupLogin;

	private JButton btnLogin;
	private JButton btnClear;
	private JButton btnJoin;
	private JButton btnFind;

	private JLabel lblId;
	private JLabel lblPw;

	private JRadioButton rbtnStaff;
	private JRadioButton rbtnClient;

	private JTextField tfId;
	private JPasswordField ptfPw;

	public Login() {
		// 제목, 틀 생성 및 배치 시작
		super("선홍유림_로그인");
		this.setLayout(null);
		this.setSize(475, 200);
		this.setLocationRelativeTo(null);
		Container c = this.getContentPane();
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 제목, 틀 생성 및 배치 종료

		// 변수 초기화
		hashMemberDTO = new HashMap<String, MemberDTO>();

		// 로그인 라벨, 필드 생성 및 배치 시작
		btnGroupLogin = new ButtonGroup();

		btnLogin = new JButton("로그인");
		btnClear = new JButton("다시입력");
		btnJoin = new JButton("회원가입");
		btnFind = new JButton("ID/PW찾기");

		lblId = new JLabel("●  아이디");
		lblPw = new JLabel("●  비밀번호");

		tfId = new JTextField(30);
		ptfPw = new JPasswordField(30);
		rbtnStaff = new JRadioButton("Staff", false);
		rbtnClient = new JRadioButton("Client", true);

		btnGroupLogin.add(rbtnStaff);
		btnGroupLogin.add(rbtnClient);

		btnLogin.setBounds(30, 115, 95, 30);
		btnClear.setBounds(135, 115, 95, 30);
		btnJoin.setBounds(240, 115, 95, 30);
		btnFind.setBounds(345, 115, 95, 30);
		lblId.setBounds(40, 30, 100, 30);
		lblPw.setBounds(40, 60, 100, 30);
		tfId.setBounds(135, 30, 200, 30);
		ptfPw.setBounds(135, 60, 200, 30);
		rbtnStaff.setBounds(370, 30, 100, 30);
		rbtnClient.setBounds(370, 60, 100, 30);

		c.add(lblId);
		c.add(lblPw);
		c.add(tfId);
		c.add(ptfPw);
		c.add(rbtnStaff);
		c.add(rbtnClient);
		c.add(btnLogin);
		c.add(btnClear);
		c.add(btnJoin);
		c.add(btnFind);

		// 로그인 라벨, 필드 생성 및 배치 종료

		this.setVisible(true);
		event();
	}

	public void event() {
		btnLogin.addActionListener(this);
		btnClear.addActionListener(this);
		btnJoin.addActionListener(this);
		btnFind.addActionListener(this);
	}

	// 로그인 버튼용 메서드
	public boolean isIdExist(MemberDTO tryingId) { // 입력한 아이디가 해쉬맵에 있는지 확인
		boolean idExistence = false;
		idExistence = (tryingId == null) ? false : true;
		return idExistence;
	}

	public boolean isIdExist(String id) { // 위에랑 합치는 것 고려

		boolean idExistence = false;
		idExistence = (hashMemberDTO.get(id) == null) ? false : true;
		return idExistence;
	}

	public boolean isPwCorrect(MemberDTO tryingId) { // 입력한 아이디의 비밀번호가 맞는지 확인

		boolean pwCorrect = false;
		pwCorrect = (tryingId.getPw().equals(String.valueOf(ptfPw.getPassword()))) ? true : false;
		return pwCorrect;
	}

	public boolean isStaff(MemberDTO tryingId) { // 입력한 아이디의 권한 확인

		boolean staffCorrect = false; // 1.로그인시도 아이디 스태프 여부 확인 2. 버튼이 스태프인지 확인 3. 둘 다 맞으면 true 반환
		staffCorrect = (tryingId.isStaff()) ? (rbtnStaff.isSelected() ? true : false) : false;
		return staffCorrect;
	}

	public boolean isClient(MemberDTO tryingId) { // 입력한 아이디의 권한 확인

		boolean clientCorrect = false; // 1.로그인시도 아이디 클라이언트 여부 확인 2. 버튼이 클라이언트인지 확인 3. 둘 다 맞으면 true 반환
		clientCorrect = (!tryingId.isStaff()) ? (rbtnClient.isSelected() ? true : false) : false;
		return clientCorrect;
	}

	// 다시입력용 메서드
	public void clear() {
		tfId.setText("");
		ptfPw.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "로그인":

			String tryId = tfId.getText();
			String tryPw = String.valueOf(ptfPw.getPassword());
			MemberDTO member = MemberDAO.getInstance().tryLogin(tryId, tryPw);
			new MainFrame(member).setVisible(true);

			break;
		case "다시입력":
			clear();
			break;
		case "회원가입":
			new Join(this);
			break;
		case "ID/PW찾기":
			new Find(this);
			break;
		}

	}

	public void setMemberDTO(MemberDTO dto) {
		this.hashMemberDTO.put(dto.getId(), dto);
	}

	public HashMap<String, MemberDTO> getHashMemberDTO() {
		return hashMemberDTO;
	}

	public static void main(String[] args) {
		Login login = new Login();

	}

}



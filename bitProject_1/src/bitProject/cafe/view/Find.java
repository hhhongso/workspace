package bitProject.cafe.view;

import javax.swing.JFrame;

public class Find extends JFrame {

	public Find(Login login) {
		super("선홍유림_ID/PW 찾기");
		this.setLayout(null);
		setSize(500, 600);
		setLocationRelativeTo(login);
		this.setResizable(false);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);

		this.setVisible(true);
	}

}



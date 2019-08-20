package bitProject.cafe.net;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import bitProject.cafe.dto.MemberDTO;

public class TestFrame extends JFrame {
	public TestFrame() {
		getContentPane().add(new ChatRoom(new MemberDTO("elisaint8","123456789q","유종민","elisaint8","gmail","010","3063","3277",2000,12,6,true,true)));
		setBounds(700, 100, 1200, 500);
		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void	windowClosing(WindowEvent e){
				System.out.println("이걸론 꺼지지 않습니다.");
			}
		});

	}
	public static void main(String[] args) {
		new TestFrame();
	}

}



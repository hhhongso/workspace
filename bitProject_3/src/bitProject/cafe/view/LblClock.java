package bitProject.cafe.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class LblClock extends JLabel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -10406669327723571L;
	private Thread clock;
	private SimpleDateFormat sdf;
	private Date date;
	private String result;

	public LblClock() {
		sdf = new SimpleDateFormat("a hh:mm:ss");
		clock = new Thread(this);
		clock.start();
	}

	@Override
	public void run() {
		while (true) {
			date = new Date();
			result = sdf.format(date);
			setText(result);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

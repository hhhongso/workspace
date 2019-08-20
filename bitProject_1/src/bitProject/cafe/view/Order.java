package bitProject.cafe.view;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import bitProject.cafe.dao.OrderDAO;
import bitProject.cafe.dto.OrderDTO;

public class Order extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5436347122697860687L;
	private JComboBox<String> cbxBevOrDes; // 음료/디저트 선택 콤보박스
	private JComboBox<ImageIcon> cbxMenuSelect; // 음료메뉴/디저트메뉴 선택 콤보박스
	private ImageIcon[] bevArr; // 음료메뉴 아이콘
	private ImageIcon[] desArr; // 디저트 메뉴 아이콘

	private JTextArea taPrice; // 금액
	private JTextField tfAmount; // 수량
	private JTextField tfTotPrice; // 총 결제금액

	private JButton btnAdd; // 주문 추가 버튼
	private JButton btnConfirm; // 주문 확정 버튼
	private JButton btnCancel; // 주문 취소 버튼

	private JTable table; // Jtable
	private DefaultTableModel model; // tableModel
	private ArrayList<OrderDTO> list; // dto ArrayList

	public Order() {
		setLayout(null);
		setBounds(new Rectangle(0, 0, 1200, 500));

		JLabel lblBevOrDes = new JLabel("음료/디저트");
		JLabel lblMenuSelect = new JLabel("메뉴 선택");
		JLabel lblPrice = new JLabel("금액");
		JLabel lblAmount = new JLabel("수량");
		JLabel lblStatus = new JLabel("주문현황");
		JLabel lblTotPrice = new JLabel("총 결제 금액");

		String[] bevOrDesArr = { "음료", "디저트" };
//		bevOrDesArr
		cbxBevOrDes = new JComboBox<String>(bevOrDesArr);

		bevArr = new ImageIcon[] { new ImageIcon("img/coffee_1.png"), new ImageIcon("img/coffee_2.png"),
				new ImageIcon("img/coffee_3.png"), new ImageIcon("img/coffee_4.png"),
				new ImageIcon("img/coffee_5.png"),
				new ImageIcon("img/coffee_6.png"),};

		desArr = new ImageIcon[] { new ImageIcon("img/cake_1.png"), new ImageIcon("img/cake_2.png"),
				new ImageIcon("img/cake_3.png"), new ImageIcon("img/cake_4.png"), };

		cbxMenuSelect = new JComboBox<ImageIcon>();

		taPrice = new JTextArea(0, 0);
		taPrice.setEditable(false);

		tfAmount = new JTextField("0");
		tfAmount.setColumns(10);

		tfTotPrice = new JTextField();
		tfTotPrice.setColumns(10);
		tfTotPrice.setEditable(false);

		btnConfirm = new JButton("주문 확정");
		btnAdd = new JButton("주문 추가");
		btnCancel = new JButton("주문 취소");

		// JTable 생성
		String colName[] = new String[] { "선택 메뉴", "수량", "금액" };
		model = new DefaultTableModel(colName, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -8826602990608097920L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		setAlignmentCenter(table);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// ArrayList 생성
		list = new ArrayList<OrderDTO>();

		// 위치 / 글꼴 설정 후 붙이기
		lblBevOrDes.setBounds(12, 10, 120, 20);
		lblMenuSelect.setBounds(213, 10, 100, 20);
		lblPrice.setBounds(378, 10, 80, 20);
		lblAmount.setBounds(519, 10, 80, 20);
		lblStatus.setBounds(940, 10, 100, 20);
		lblTotPrice.setBounds(616, 473, 80, 20);
		cbxBevOrDes.setBounds(12, 47, 100, 30);
		cbxMenuSelect.setBounds(200, 47, 100, 30);
		taPrice.setBounds(378, 51, 80, 30);
		tfAmount.setBounds(505, 51, 80, 30);
		tfTotPrice.setBounds(708, 468, 100, 30);
		btnAdd.setBounds(820, 468, 100, 30);
		btnCancel.setBounds(940, 468, 100, 30);
		btnConfirm.setBounds(1059, 468, 100, 30);
		scroll.setBounds(812, 53, 300, 400);

		lblBevOrDes.setFont(new Font("나눔바른고딕", Font.BOLD, 15));
		lblMenuSelect.setFont(new Font("나눔바른고딕", Font.BOLD, 15));
		lblPrice.setFont(new Font("나눔바른고딕", Font.BOLD, 15));
		lblAmount.setFont(new Font("나눔바른고딕", Font.BOLD, 15));
		lblStatus.setFont(new Font("나눔바른고딕", Font.BOLD, 15));
		lblTotPrice.setFont(new Font("나눔바른고딕", Font.BOLD, 15));
		cbxBevOrDes.setFont(new Font("나눔바른고딕", Font.BOLD, 15));
		cbxMenuSelect.setFont(new Font("나눔바른고딕", Font.BOLD, 15));
		taPrice.setFont(new Font("나눔바른고딕", Font.BOLD, 15));
		tfTotPrice.setFont(new Font("나눔바른고딕", Font.BOLD, 15));
		btnAdd.setFont(new Font("나눔바른고딕", Font.BOLD, 15));
		btnConfirm.setFont(new Font("나눔바른고딕", Font.BOLD, 15));
		btnCancel.setFont(new Font("나눔바른고딕", Font.BOLD, 15));

		add(lblBevOrDes);
		add(lblMenuSelect);
		add(lblPrice);
		add(lblAmount);
		add(lblStatus);
		add(lblTotPrice);
		add(cbxBevOrDes);
		add(cbxMenuSelect);
		add(taPrice);
		add(tfAmount);
		add(tfTotPrice);
		add(btnAdd);
		add(btnCancel);
		add(btnConfirm);
		add(scroll);

		// ActionEvent
		cbxBevOrDes.addActionListener(this);
		btnAdd.addActionListener(this);
		btnCancel.addActionListener(this);
		btnConfirm.addActionListener(this);
		
		tfAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isDigit(c)) {
					e.consume();
					return;
				}
			}
		});
	}// 생성자

	@Override
	public void actionPerformed(ActionEvent e) {
		int totPrice = 0;
	
		OrderDAO orderDao = OrderDAO.getInstance();
		// 음료/디저트 선택 콤보박스에서, 선택한 옵션에 맞추어 메뉴 콤보박스(음료메뉴/디저트메뉴) 를 보여준다.
		if (e.getSource() == cbxBevOrDes) {
			selectBevOrDes();
			taPrice.setText("");
			cbxMenuSelect.addActionListener(this);

			// 음료/디저트 메뉴 콤보박스에서, 선택한 메뉴에 맞추어 메뉴의 가격을 보여준다.
		} else if (e.getSource() == cbxMenuSelect) {
			int idx = cbxMenuSelect.getSelectedIndex();
			int menuPrice = 0;
			if (cbxBevOrDes.getSelectedIndex() == 0)
				menuPrice = setBevPrice(idx);
			else if (cbxBevOrDes.getSelectedIndex() == 1)
				menuPrice = setDesPrice(idx);
			taPrice.setText(menuPrice + "");
			taPrice.setEditable(false);

			// 주문 추가 버튼을 누르면, 선택한 메뉴, 수량, 금액을 JTable에 보여준다.
		} else if (e.getSource() == btnAdd) {		
			if(tfAmount.getText().equals("") || tfAmount.getText() == null || Integer.parseInt(tfAmount.getText()) == 0) { 
				System.out.println(tfAmount.getText());
				JOptionPane.showMessageDialog(this, "수량을 입력해주세요" );
				return;
			} else if(Integer.parseInt(tfAmount.getText()) > 1000) {
				JOptionPane.showMessageDialog(this, "수량은 1000 잔 까지만 주문이 가능합니다." );
				return;
				
			}
			
			String menuName = null;
			if (cbxBevOrDes.getSelectedIndex() == 0)
				menuName = setBevName();
			else if (cbxBevOrDes.getSelectedIndex() == 1)
				menuName = setDesName();

			int amount = Integer.parseInt(tfAmount.getText().trim());
			tfAmount.setText("0");

			// DTO를 생성하여 메뉴명, 금액, 수량 set.
			OrderDTO order = new OrderDTO();
			int menuPrice = Integer.parseInt(taPrice.getText());
			order.setId("guest");
			order.setMenuName(menuName);
			order.setAmount(amount);
			order.setMenuPrice(menuPrice);	
			
			int seq = orderDao.getSeq();
			order.setSeq(seq);
			list.add(order);

			// JTable에는 열 별로 vector로 추가한다.
			Vector<Object> vec = new Vector<Object>();
			vec.addElement(order.getMenuName());
			vec.addElement(order.getAmount());
			vec.addElement(order.getMenuPrice());
			model.addRow(vec);

			// 총 결제 금액
			for (OrderDTO dto1 : list) {
				totPrice += (dto1.getAmount() * dto1.getMenuPrice());
			}
			tfTotPrice.setText(totPrice + "");

		} else if (e.getSource() == btnCancel) {
			delete();
			for (OrderDTO dto1 : list) {
				totPrice += (dto1.getAmount() * dto1.getMenuPrice());
			}
			tfTotPrice.setText(totPrice + "");

			// 주문 확정 버튼을 누르면, 체크되어 있던 값이 모두 초기화된다.
		} else if (e.getSource() == btnConfirm) {
			clear();
			JOptionPane.showMessageDialog(this, "주문이 완료되었습니다. ");
			totPrice = 0;
			tfTotPrice.setText(totPrice + "");
			
			int cnt = 0; 
			// DB에 orderDTO order 를 보낸다.
			for (OrderDTO dto1 : list) {
				cnt = orderDao.insert(dto1);
			}
			list.removeAll(list); // 주문확정 되면, arraylist를 모두 비운다. 
			System.out.println(cnt + "건의 주문 내역 추가");
		}
	}

	public void delete() {
		if(table.getSelectedColumn() == -1) {
			JOptionPane.showMessageDialog(null, "주문 취소할 메뉴를 선택해 주세요." );
			return;
		}
		int row = table.getSelectedRow();
		model.removeRow(row);
		list.remove(row);
	}

	public void clear() {
		for (int i = 0; i < model.getRowCount(); i++) {
			model.removeRow(i);
			i = i - 1;
		}

		cbxBevOrDes.setSelectedIndex(0);
		cbxMenuSelect.setSelectedIndex(0);
		taPrice.setText("");
		tfTotPrice.setText("");
	}

	public int setDesPrice(int idx) {
		int menuPrice = 0;
		int[] priceArr = { 1500, 2000, 2000, 2500 };
		for (int i = 0; i < priceArr.length; i++) {
			if (idx == i)
				menuPrice = priceArr[i];
		}
		return menuPrice;
	}

	public int setBevPrice(int idx) {
		int menuPrice = 0;
		int[] priceArr = { 1000, 2000, 3000, 3000, 2000, 2500};
		for (int i = 0; i < priceArr.length; i++) {
			if (idx == i)
				menuPrice = priceArr[i];
		}
		return menuPrice;
	}

	public String setDesName() {
		String menuName = null;
		if (cbxMenuSelect.getSelectedIndex() == 0) {
			menuName = "초코케익";
		} else if (cbxMenuSelect.getSelectedIndex() == 1) {
			menuName = "치즈케익";
		} else if (cbxMenuSelect.getSelectedIndex() == 2) {
			menuName = "딸기케익";
		} else if (cbxMenuSelect.getSelectedIndex() == 3) {
			menuName = "블루베리케익";
		}

		return menuName;
	}

	public String setBevName() {
		// 음료 메뉴 중 하나를 선택
		String menuName = null;
		if (cbxMenuSelect.getSelectedIndex() == 0) {
			menuName = "아메리카노";
		} else if (cbxMenuSelect.getSelectedIndex() == 1) {
			menuName = "카페라떼";
		} else if (cbxMenuSelect.getSelectedIndex() == 2) {
			menuName = "카푸치노";
		} else if (cbxMenuSelect.getSelectedIndex() == 3) {
			menuName = "녹차라떼";
		} else if (cbxMenuSelect.getSelectedIndex() == 4) {
			menuName = "핫초코";
		} else if (cbxMenuSelect.getSelectedIndex() == 5) {
			menuName = "레모네이드";
		}

		return menuName;
	}

	public void selectBevOrDes() {
		cbxMenuSelect.setVisible(false); // 생성자에서 만들었던 빈칸의 콤보박스를 setVisible(false) 하고
		int idx = cbxBevOrDes.getSelectedIndex(); // 음료/디저트 중 하나를 선택
		ImageIcon[] menuArr = setImageIcon(idx); // 선택한 옵션에 맞추어 ImageIcon 를 대입.
		setCbxMenu(menuArr);

		cbxMenuSelect.setBounds(200, 47, 100, 100);
		add(cbxMenuSelect);
		cbxMenuSelect.setVisible(true); // ImageIcon을 받은 콤보박스로 setVisible(true)
	}

	private void setCbxMenu(ImageIcon[] menuArr) {
		cbxMenuSelect = new JComboBox<ImageIcon>(menuArr);
	}

	public ImageIcon[] setImageIcon(int idx) {
		ImageIcon[] menuArr = bevArr;
		if (idx == 0) {
			menuArr = bevArr;
		} else if (idx == 1) {
			menuArr = desArr;
		}

		return menuArr;
	}

	public void setAlignmentCenter(JTable table) { // JTable의 내용 가운데 정렬
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}
}

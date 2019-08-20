package bitProject.cafe.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import bitProject.cafe.dao.OrderDAO;
import bitProject.cafe.dao.SalesDAO;
import bitProject.cafe.dto.OrderDTO;


import javax.swing.JButton;
import javax.swing.ListSelectionModel;

public class OrderDisp extends JPanel implements ActionListener {
	private JTable table;
	private DefaultTableModel model;

	private JButton btnConfirm;
	private JButton btnUpdate;

	private ArrayList<OrderDTO> list;

	public OrderDisp() {
		setLayout(null);
		setBounds(new Rectangle(0, 0, 1200, 500));

		JLabel lblOrderDisp = new JLabel("주문내역 확인");
		lblOrderDisp.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblOrderDisp.setBounds(28, 21, 178, 36);
		add(lblOrderDisp);

		String[] colName = {"번호", "주문자", "주문 메뉴", "수량", "단가", "금액"};
		model = new DefaultTableModel(colName, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false); // 이동 불가
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setPreferredWidth(180);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(5).setPreferredWidth(30);
		table.getTableHeader().setResizingAllowed(false); // 크기 조절 불가
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //하나의 행만 선택
		setAlignmentCenter(table);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		scroll.setBounds(28, 84, 801, 377);
		add(scroll);

		btnConfirm = new JButton("판매 완료");
		btnConfirm.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnConfirm.setBounds(875, 84, 158, 173);
		add(btnConfirm);
		
		btnUpdate = new JButton("주문내용 갱신");
		btnUpdate.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnUpdate.setBounds(875, 288, 158, 173);
		add(btnUpdate);
		
		
		list = new ArrayList<OrderDTO>();
		list = OrderDAO.getInstance().dispAll();	
		disp();
		
		btnConfirm.addActionListener(this);
		btnUpdate.addActionListener(this);
		
	} // 생성자

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConfirm) { // 판매 완료
			int row = table.getSelectedRow();
			if(!table.isRowSelected(row)) {
				JOptionPane.showMessageDialog(this, "판매 완료된 메뉴를 선택해 주세요 !");
				
			}else if(table.isRowSelected(row)) {
				int selectedSeq = (int) table.getValueAt(row, 0);
				int cntSales = SalesDAO.getInstance().insert(list.get(row));
				System.out.println(cntSales + "건 매출 등록 완료");

				int cntOrder = OrderDAO.getInstance().delete(selectedSeq);
				System.out.println(cntOrder + "건 주문 정보 삭제 완료");				
				model.removeRow(row);
				
//				list.remove(row);				
			}
		
		} else if (e.getSource() == btnUpdate) { //주문내역 갱신 
			if(model.getRowCount() != 0) {
				int lastSeq = (int) table.getValueAt(model.getRowCount()-1, 0);
				list = OrderDAO.getInstance().dispUpdate(lastSeq);	
				if(list.size() == 0) {
					JOptionPane.showMessageDialog(this, "갱신할 내용이 없습니다. ");
				}
				disp();
			} else if(model.getRowCount() == 0) {
				list = OrderDAO.getInstance().dispAll();	
				disp();
				
			}
				
		} 
	}
	
	public void disp() {
		for (OrderDTO order : list) {
			Vector<Object> vec = new Vector<Object>();
			int totPrice = order.getAmount() * order.getMenuPrice();
			vec.addElement(order.getSeq());
			vec.addElement(order.getId());
			vec.addElement(order.getMenuName());
			vec.addElement(order.getAmount());
			vec.addElement(order.getMenuPrice());
			vec.addElement(totPrice);
			
			model.addRow(vec);
		}
		
	}

	public void setAlignmentCenter(JTable table) { // JTable의 내용 가운데 정렬
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}

// 임시 main =========================================================================================================================	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		OrderDisp orderDisp = new OrderDisp();
		f.getContentPane().add(orderDisp);
		f.setBounds(700, 100, 1300, 600);
		f.setVisible(true);
	}
}

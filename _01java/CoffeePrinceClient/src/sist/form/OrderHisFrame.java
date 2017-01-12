package sist.form;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import sist.dao.SingletonClass;
import sist.dto.MemDTO;
import sist.dto.OrderDTO;
import sist.network.OrderWriteClass;

public class OrderHisFrame extends JFrame implements ActionListener{
	
	JTable jTable;
	JScrollPane jScrPane;
	//
	
	String adColumnNames[] = {
			"Id", "Espresso Beverages", "Size", "Syrup",
			"Shot", "Cream", "Cup", "Total", "Confirm"
		};
	String columnNames[] = {
			"Espresso Beverages", "Size", "Syrup",
			"Shot", "Cream", "Cup", "Total", "Confirm"
		};
	Object 	rowData[][];
	public OrderHisFrame() {
		Font f = new Font("Monospaced", Font.BOLD, 20);
		
		setLayout(null);
		setBounds(100, 100, 640, 480);
		
		JLabel title = new JLabel("Order History");
		title.setBounds(10, 10, 300, 30);
		title.setFont(f);
		add(title);
		
		this.setJtable();
		SingletonClass sc = SingletonClass.getInstance();
		JLabel idLb = new JLabel(sc.loginMem.getId());
		idLb.setBounds(360, 10, 70, 30);
		add(idLb);
		
		JButton outBtn = new JButton("Logout");
		outBtn.setBounds(530, 10, 80, 30);
		add(outBtn);
		outBtn.addActionListener(this);
		
		JButton reFreshBtn = new JButton("Refresh");
		reFreshBtn.setBounds(440, 10, 80, 30);
		add(reFreshBtn);
		reFreshBtn.addActionListener(this);
		
		setVisible(true);
		
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				SingletonClass sc = SingletonClass.getInstance();

				if(sc.memDao.list.size() == 0) System.exit(0);
				for(int i=0; i< sc.memDao.list.size(); ++i){
					MemDTO d = sc.memDao.list.get(i);
					if(d.getId().equals(sc.loginMem.getId())){
						sc.memDao.list.get(i).setConnect(false);
					}
				}
				sc.memDao.fileLoad();
				
			}
			
		});
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		String btnStr = btn.getLabel();
		if(btnStr.equals("Logout")){
			SingletonClass sc = SingletonClass.getInstance();

			for(int i=0; i< sc.memDao.list.size(); ++i){
				MemDTO d = sc.memDao.list.get(i);
				if(d.getId().equals(sc.loginMem.getId())){
					sc.memDao.list.get(i).setConnect(false);
				}
			}
			sc.memDao.fileLoad();
			new LoginFrame();
			dispose();
		}else if(btnStr.equals("Aditional Order")){
			new OrderFrame();
			dispose();
		}else if(btnStr.equals("Refresh")){
			new OrderHisFrame();
			dispose();
		}
		
	}
	
	public void setJtable(){
		SingletonClass sc = SingletonClass.getInstance();
		if(sc.loginMem.getId().equals("admin")){
			if(sc.orderDao.list.size() != 0){
				int liSize = sc.orderDao.list.size(); 
				rowData = new Object[liSize][9];
				for(int i=0; i<liSize; ++i){
					OrderDTO d = sc.orderDao.list.get(i);
					rowData[i][0] = d.getId();
					rowData[i][1] = d.getChoice();
					rowData[i][2] = d.getSize();
					rowData[i][3] = d.getSyrup();
					rowData[i][4] = d.isShot() ? "Add" : "No";
					rowData[i][5] = d.isCream() ? "Add" : "No";
					rowData[i][6] = d.getCount();
					rowData[i][7] = d.getTotal();
					rowData[i][8] = d.isConfirm() ? "Complete" : "ongoing";
				}
			}else{
				rowData = new Object[1][9];
			}
			
			
			jTable = new JTable(rowData, adColumnNames);
			
			jTable.getColumnModel().getColumn(0).setMaxWidth(100);
			jTable.getColumnModel().getColumn(1).setMaxWidth(400);
			jTable.getColumnModel().getColumn(2).setMaxWidth(60);
			jTable.getColumnModel().getColumn(3).setMaxWidth(50);
			jTable.getColumnModel().getColumn(4).setMaxWidth(50);
			jTable.getColumnModel().getColumn(5).setMaxWidth(50);
			jTable.getColumnModel().getColumn(6).setMaxWidth(30);
			jTable.getColumnModel().getColumn(7).setMaxWidth(60);
			jTable.getColumnModel().getColumn(8).setMaxWidth(50);
			
			jTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SingletonClass sc = SingletonClass.getInstance();
					int rowNum = jTable.getSelectedRow();
					if(sc.orderDao.list.get(rowNum).isConfirm()) return;
					int confirmNum = JOptionPane.showConfirmDialog(null, "주문확인으로 변경하시겠습니까?");
					if(confirmNum == 0){
						sc.orderDao.list.get(rowNum).setConfirm(true);
						sc.networkDto = sc.orderDao.list.get(rowNum); 
						sc.networkDto.setAuth(1);
						//JOptionPane.showMessageDialog(null, "sending!!!");
						sc.wc.sendMsg();					
						
						//JOptionPane.showMessageDialog(null, sc.networkDto.toString());
						
						sc.networkDto = null;
						
					//	new OrderHisFrame();
					//	dispose();
						
					}
					
				}
			});
		}else{
			sc.orderDao.setMemList();
			if(sc.orderDao.memList.size() != 0){
				int memLiSize = sc.orderDao.memList.size(); 
				rowData = new Object[memLiSize][8];
				for(int i=0; i<memLiSize; ++i){
					OrderDTO d = sc.orderDao.memList.get(i);
					rowData[i][0] = d.getChoice();
					rowData[i][1] = d.getSize();
					rowData[i][2] = d.getSyrup();
					rowData[i][3] = d.isShot() ? "Add" : "No";
					rowData[i][4] = d.isCream() ? "Add" : "No";
					rowData[i][5] = d.getCount();
					rowData[i][6] = d.getTotal();
					rowData[i][7] = d.isConfirm() ? "Complete" : "ongoing";
				}
			}else{
				rowData = new Object[1][8];
			}
			
			
			jTable = new JTable(rowData, columnNames);
			
			jTable.getColumnModel().getColumn(0).setMaxWidth(500);
			jTable.getColumnModel().getColumn(1).setMaxWidth(100);
			jTable.getColumnModel().getColumn(2).setMaxWidth(60);
			jTable.getColumnModel().getColumn(3).setMaxWidth(60);
			jTable.getColumnModel().getColumn(4).setMaxWidth(60);
			jTable.getColumnModel().getColumn(5).setMaxWidth(30);
			jTable.getColumnModel().getColumn(6).setMaxWidth(60);
			jTable.getColumnModel().getColumn(7).setMaxWidth(60);
			
			JButton addBtn = new JButton("Aditional Order");
			addBtn.setBounds(490, 350, 120, 40);
			add(addBtn);
			addBtn.addActionListener(this);
		}
		
		
		
		jScrPane = new JScrollPane(jTable);
		jScrPane.setBounds(10, 50, 600, 280);
		add(jScrPane);
	}
}

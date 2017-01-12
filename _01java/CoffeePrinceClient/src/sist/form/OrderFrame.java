package sist.form;

import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import sist.dao.SingletonClass;
import sist.dto.MemDTO;
import sist.dto.OrderDTO;
import sist.network.OrderWriteClass;

public class OrderFrame extends JFrame implements KeyListener, ActionListener, ItemListener{
	
	Choice choice;
	JButton menuBtn;
	JButton orderBtn;
	JTextField count;
	JLabel choiceLb;
	JLabel sizeLb;
	JLabel syrupLb;
	JLabel etcLb1;
	JLabel etcLb2;
	
	boolean isShot;
	boolean isCream;
	
	
	public OrderFrame() {
		
		
		choiceLb = new JLabel("");
		sizeLb = new JLabel("");
		syrupLb = new JLabel("");
		etcLb1 = new JLabel("");
		etcLb2 = new JLabel("");
		
		setBounds(100, 100, 640, 480);
		setLayout(null);
		
		choice = new Choice();
		choice.add("Select Beverage");
		choice.add("Hazelnut Caramel Mocha");
		choice.add("Caramel Makiatto");
		choice.add("White Chocolate Mocha");
		choice.add("Caramel Mocha");
		choice.add("Caffe Mocha");
		choice.add("Caramel Latte");
		choice.add("Caffe Latte");
		choice.add("Cappuccino");
		choice.add("Americano");
		choice.add("Today's Coffee");
		choice.setBounds(80, 110, 480, 20);
		add(choice);
		ItemListener choiceListen = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				choiceLb.setText(choice.getSelectedItem());
				
			}
		};
		
		choice.addItemListener(choiceListen);
		
		menuBtn = new JButton("Menu");
		menuBtn.setBounds(530, 10, 80, 30);
		add(menuBtn);
		menuBtn.addActionListener(this);
		
		
		//////////////////사이즈//////////////
		JLabel sizeLabel = new JLabel("Size");
		sizeLabel.setBounds(85, 180, 80, 30);
		add(sizeLabel);
		
		JRadioButton sizeShort = new JRadioButton("Short");
		sizeShort.setBounds(80, 210, 80, 30);
		
		JRadioButton sizeTall = new JRadioButton("Tall");
		sizeTall.setBounds(80, 250, 80, 30);
		
		JRadioButton sizeGrande = new JRadioButton("Grande");
		sizeGrande.setBounds(80, 290, 80, 30);
		
		ButtonGroup sizeGrp = new ButtonGroup();
		sizeGrp.add(sizeShort);
		sizeGrp.add(sizeTall);
		sizeGrp.add(sizeGrande);
		add(sizeShort);
		add(sizeTall);
		add(sizeGrande);
		ActionListener sizeAction = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					AbstractButton ab = (AbstractButton)e.getSource();
					JRadioButton jb = (JRadioButton) ab;
					
					if(jb.isSelected()){
						sizeLb.setText(jb.getText().trim());
					}
				
			}
		};
		
		sizeShort.addActionListener(sizeAction);
		sizeTall.addActionListener(sizeAction);
		sizeGrande.addActionListener(sizeAction);
		
		//////////////////시럽//////////////
		JLabel syrupLabel = new JLabel("Syrup");
		syrupLabel.setBounds(285, 180, 80, 30);
		add(syrupLabel);
		
		JRadioButton vanilla = new JRadioButton("Vanilla");
		vanilla.setBounds(280, 210, 80, 30);
		
		JRadioButton caramel = new JRadioButton("Caramel");
		caramel.setBounds(280, 250, 80, 30);
		
		JRadioButton hazelnut = new JRadioButton("Hazelnut");
		hazelnut.setBounds(280, 290, 80, 30);
		
		ButtonGroup syrupGrp = new ButtonGroup();
		syrupGrp.add(vanilla);
		syrupGrp.add(caramel);
		syrupGrp.add(hazelnut);
		add(vanilla);
		add(caramel);
		add(hazelnut);
		
		ActionListener syrupAction = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					AbstractButton ab = (AbstractButton)e.getSource();
					JRadioButton jb = (JRadioButton) ab;
					
					if(jb.isSelected()){
						syrupLb.setText(jb.getText().trim());
					}
				
			}
		};
		
		vanilla.addActionListener(syrupAction);
		caramel.addActionListener(syrupAction);
		hazelnut.addActionListener(syrupAction);
		
		//////////////////기타//////////////
		JLabel etcLabel = new JLabel("Etc");
		etcLabel.setBounds(485, 180, 80, 30);
		add(etcLabel);
		
		JCheckBox shot = new JCheckBox("shot");
		shot.setBounds(480, 220, 80, 30);
		shot.addItemListener(this);
		
		
		JCheckBox cream = new JCheckBox("cream");
		cream.setBounds(480, 270, 80, 30);
		cream.addItemListener(this);
		

		add(shot);
		add(cream);
		
		count = new JTextField("");
		count.setBounds(210, 350, 40, 30);
		add(count);
		count.addKeyListener(this);
		
		JLabel countLb = new  JLabel("cup");
		countLb.setBounds(260, 350, 30, 30);
		add(countLb);
		
		orderBtn = new JButton("Order");
		orderBtn.setBounds(300, 350, 80, 30);
		add(orderBtn);
		orderBtn.addActionListener(this);

		
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
		Object ob = e.getSource();
		if(ob == menuBtn){
			new MenuFrame();
		}else if(ob == orderBtn){
			OrderDTO odto = new OrderDTO();
			if(count.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Enter a couple of Beverage");
				return;
			}
			if(choiceLb.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Did not Choose Beverage!");
				return;
			}
			
			SingletonClass sc = SingletonClass.getInstance();
			odto.setId(sc.loginMem.getId());
			odto.setChoice(choiceLb.getText());
			odto.setSize(sizeLb.getText());
			odto.setSyrup(syrupLb.getText());
			odto.setCount(Integer.parseInt(count.getText()));
			odto.setShot(isShot);
			odto.setCream(isCream);
			
			sc.orderDao.addOrder(odto);
			sc.networkDto = odto;
			sc.networkDto.setAuth(0);
			sc.wc.sendMsg();
			
			sc.networkDto = null;
			
			new OrderHisFrame();
			dispose();
			
		}
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		 char c = e.getKeyChar();
		  
		  if (!Character.isDigit(c)) {
		   e.consume();
		   return;
		  }
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
		Object ob = e.getItemSelectable();
		JCheckBox cb = (JCheckBox) ob;
		if(cb.isSelected()){
			if(cb.getText().equals("shot")){
				etcLb1.setText(cb.getText());
				isShot = true;
			}else if(cb.getText().equals("cream")){
				etcLb2.setText(cb.getText());
				isCream = true;
			}
		}else{
			if(cb.getText().equals("shot")){
				etcLb1.setText("");
				isShot = false;
			}else if(cb.getText().equals("cream")){
				etcLb2.setText("");
				isCream = false;
			}
		}
		
		
	}

	
}









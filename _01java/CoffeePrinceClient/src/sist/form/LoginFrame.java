package sist.form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import sist.dao.SingletonClass;
import sist.dto.MemDTO;

public class LoginFrame extends JFrame implements ActionListener{
	private JButton btn1;
	private JButton btn2;
	private JTextField textField;
	private JPasswordField pwField;
	
	public LoginFrame() {
		super("로그인 창");
		
		//getContentPane().setBackground(new Color(, 0, 0));
		setLayout(null);
		setBounds(100, 100, 300, 280);
		
		
		JLabel title = new JLabel("로그인 화면", JLabel.CENTER);
		title.setBounds(41, 0, 200, 20);
		add(title);
		
		JLabel labelID = new JLabel("ID");
		labelID.setBounds(31, 40, 67, 15);
		add(labelID);
		
		textField = new JTextField();
		textField.setBounds(100, 40, 116, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel labelPW = new JLabel("Pass");
		labelPW.setBounds(31, 84, 67, 15);
		add(labelPW);
		
		pwField = new JPasswordField();
		pwField.setBounds(100, 84, 116, 21);
		add(pwField);
		
		btn1 = new JButton("login");
		btn1.setBounds(31, 130, 87, 50);
		
		btn2 = new JButton("join");
		btn2.setBounds(130, 130, 87, 50);
		
		add(btn1);
		add(btn2);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				SingletonClass sc = SingletonClass.getInstance();
				if(sc.memDao.list.size() == 0) System.exit(0);
				
				sc.memDao.fileLoad();
			}
			
		});
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
Object obj = e.getSource();
		
		if(obj == btn1){
			//System.out.println("btn1");
			if(textField.getText().equals("") ||
					pwField.getText().equals("")){
				JOptionPane.showMessageDialog(null, "빈칸을 채워주십시오");
				return;
			}
			SingletonClass sc = SingletonClass.getInstance();
			
			String id = textField.getText();
			String pw = pwField.getText();
			
			MemDTO dto = new MemDTO();
			dto.setId(id);
			dto.setPw(pw);
			
			dto = sc.memDao.login(dto);
			
			if(dto != null){
				if(dto.isConnect()){
					JOptionPane.showMessageDialog(null, "이미 다른 pc에서 로그인 되어있습니다.");
					return;
				}
				if(dto.getId().equals("admin")){
					
					JOptionPane.showMessageDialog(null,(dto.getId() + "님 반갑습니다."));
					sc.loginMem = dto;
					sc.memDao.list.get(0).setConnect(true);
					sc.memDao.fileLoad();
					new OrderHisFrame();
					dispose();
				}else{
					
					JOptionPane.showMessageDialog(null,(dto.getId() + "님 반갑습니다."));
					sc.loginMem = dto;
					
					for(int i=0; i< sc.memDao.list.size(); ++i){
						MemDTO d = sc.memDao.list.get(i);
						if(d.getId().equals(sc.loginMem.getId())){
							sc.memDao.list.get(i).setConnect(true);
						}
					}
					sc.memDao.fileLoad();
					new OrderFrame();
					dispose();
				}
				
				
			}else{
				JOptionPane.showMessageDialog(null, "아이디나 비밀번호가 틀립니다.");
			}
			
			
		}else if(obj == btn2){
			//System.out.println("btn2");
			new JoinFrame();
			dispose();

		}
		
	}
	
	
}

package com.sist.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sist.dao.MemberDAO;
import com.sist.dto.MemberDTO;

public class LoginFrame extends JFrame implements ActionListener{
	private JButton btn1;
	private JButton btn2;
	private JTextField textField;
	private JPasswordField pwField;
	
	public LoginFrame() {
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
		
		setVisible(true);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn2){
			new JoinFrame();
			dispose();
		}else if(obj == btn1){
			if(textField.getText().equals("") ||
					pwField.getText().equals("")){
				JOptionPane.showMessageDialog(null, "빈칸을 채워주십시오");
				return;
			}
			MemberDAO dao = MemberDAO.getInstance();
			
			String id = textField.getText();
			String pw = pwField.getText();
			
			MemberDTO dto = new MemberDTO();
			dto.setId(id);
			dto.setPw(pw);
			
			dto = dao.login(dto);
			
			if(dto != null){
				JOptionPane.showMessageDialog(null, dto.getId()+"님 반갑습니다.");
				dao.loginMem = dto;
				new MainFrame();
				dispose();
			}else{
				JOptionPane.showMessageDialog(null, "아이디나 비밀번호가 틀립니다.");
			}
		}
		
	}
	
	
}

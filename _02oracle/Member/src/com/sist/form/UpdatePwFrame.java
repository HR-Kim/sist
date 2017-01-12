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

public class UpdatePwFrame extends JFrame {
	private JPasswordField inputPw;
	private JPasswordField inputPw2;
	
	public UpdatePwFrame(MypageFrame mf) {
		setLayout(null);
		setBounds(500, 100, 250, 200);
		
		JLabel labelPw = new JLabel("New pw");
		labelPw.setBounds(31, 40, 67, 15);
		add(labelPw);
		
		inputPw = new JPasswordField();
		inputPw.setBounds(100, 40, 116, 21);
		add(inputPw);
		inputPw.setColumns(10);
		
		JLabel labelPw2 = new JLabel("번호 확인");
		labelPw2.setBounds(31, 84, 67, 15);
		add(labelPw2);
		
		inputPw2 = new JPasswordField();
		inputPw2.setBounds(100, 84, 116, 21);
		add(inputPw2);
		inputPw2.setColumns(10);
		
		JButton btn = new JButton("수정");
		btn.setBounds(100, 120, 80, 30);
		add(btn);
		
		
		setVisible(true);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberDAO dao = MemberDAO.getInstance();
				if(inputPw.getText().equals("")){
					JOptionPane.showMessageDialog(null, "빈칸을 채워주십시오");
					return;
				}
				if(inputPw.getText().equals(inputPw2.getText())){
					String id = dao.loginMem.getId();
					String pw = inputPw.getText();
					
					boolean suc = dao.updatePw(id, pw);
					
					if(suc) JOptionPane.showMessageDialog(null, "변경 성공!");
					else JOptionPane.showMessageDialog(null, "변경 실패..");
					
					mf.setVisible(true);
					dispose();
					
				}else{
					JOptionPane.showMessageDialog(null, "비밀번호 확인과 새로운 비밀번호가 일치 하지 않습니다.");
				}
			}
		});
	}
}

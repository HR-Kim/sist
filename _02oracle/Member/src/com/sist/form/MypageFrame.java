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

public class MypageFrame extends JFrame implements ActionListener{
	private JTextField inputId;
	private JPasswordField inputPw;
	private JTextField inputName;
	private JTextField inputEmail;
	
	public MypageFrame() {
		MemberDAO dao = MemberDAO.getInstance();
		setLayout(null);
		setBounds(200, 100, 300, 400);
		
		JLabel title = new JLabel("My page", JLabel.CENTER);
		title.setBounds(41, 0, 200, 20);
		add(title);
		
		JLabel labelId = new JLabel("ID");
		labelId.setBounds(31, 40, 67, 15);
		add(labelId);
		
		inputId = new JTextField(dao.loginMem.getId());
		inputId.setBounds(100, 40, 116, 21);
		add(inputId);
		inputId.setEditable(false);
		inputId.setColumns(10);
		
		JLabel labelPw = new JLabel("PW");
		labelPw.setBounds(31, 84, 67, 15);
		add(labelPw);
		
		inputPw = new JPasswordField();
		inputPw.setBounds(100, 84, 116, 21);
		add(inputPw);
		inputPw.setColumns(10);
		
		JButton updatePw = new JButton("변경");
		updatePw.setBounds(220, 84, 64, 21);
		add(updatePw);
		
		JLabel labelName = new JLabel("Name");
		labelName.setBounds(31, 128, 67, 15);
		add(labelName);
		
		inputName = new JTextField(dao.loginMem.getName());
		inputName.setBounds(100, 128, 116, 21);
		add(inputName);
		inputName.setColumns(10);
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(31, 172, 67, 15);
		add(labelEmail);
		
		inputEmail = new JTextField(dao.loginMem.getEmail());
		inputEmail.setBounds(100, 172 , 116, 21);
		add(inputEmail);
		inputEmail.setColumns(10);
		
		JButton updateBtn = new JButton("수정");
		updateBtn.setBounds(31, 230, 180, 50);
		add(updateBtn);
		
		JButton deleteBtn = new JButton("회원탈퇴");
		deleteBtn.setBounds(31, 300, 180, 50);
		add(deleteBtn);
		
		updateBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		updatePw.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MemberDAO dao = MemberDAO.getInstance();
		JButton btn = (JButton)e.getSource();
		String btnStr = btn.getLabel();
		
		if(btnStr.equals("수정")){
			if(inputId.getText().equals("") ||
					inputPw.getText().equals("") ||
					inputName.getText().equals("") ||
					inputEmail.getText().equals("")){
				JOptionPane.showMessageDialog(null, "빈칸을 채워주십시오");
				return;
			}
			
			if(inputPw.getText().equals(dao.loginMem.getPw())){
				String id = inputId.getText();
				String pw = inputPw.getText();
				String name = inputName.getText();
				String email = inputEmail.getText();
				
				MemberDTO dto = new MemberDTO(id, name, pw, email, 3);
				boolean suc = dao.update(dto);
				
				if(suc) JOptionPane.showMessageDialog(null, "수정 성공!");
				else JOptionPane.showMessageDialog(null, "수정 실패..");
				
				new MainFrame();
				dispose();
			}else{
				JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
			}
		}else if(btnStr.equals("회원탈퇴")){
			int ch = JOptionPane.showConfirmDialog(null, "정말로 탈퇴하시겠습니까?");
			if(ch== 0){
				boolean suc = dao.delete();
				
				if(suc) {
					JOptionPane.showMessageDialog(null, "탈퇴 성공!");
					new LoginFrame();
					dispose();
				}
				else{ 
					JOptionPane.showMessageDialog(null, "탈퇴 실패..");
					new MainFrame();
					dispose();
				}
			}
		}else if(btnStr.equals("변경")){
			this.setVisible(false);
			new UpdatePwFrame(this);
		}

	}	
	
}











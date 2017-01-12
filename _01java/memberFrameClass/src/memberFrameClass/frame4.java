package memberFrameClass;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import memberFrameDTO.memberDTO;

public class frame4 extends JFrame implements ActionListener, WindowListener {
	
	private JTextField inputId;
	private JPasswordField inputPw;
	private JTextField inputName;
	private JTextField inputEmail;
	
	public frame4() {
		SingletonClass sc = SingletonClass.getInstance();
		setLayout(null);
		getContentPane().setBackground(new Color(0, 255, 0));
		
		setBounds(200, 100, 300, 400);
		
		

		
		JLabel title = new JLabel("회원정보 수정", JLabel.CENTER);
		title.setBounds(41, 0, 200, 20);
		add(title);
		
		JLabel labelId = new JLabel("ID");
		labelId.setBounds(31, 40, 67, 15);
		add(labelId);
		
		inputId = new JTextField(sc.loginMem.getId());
		inputId.setBounds(100, 40, 116, 21);
		add(inputId);
		inputId.setColumns(10);
		
		JLabel labelPw = new JLabel("PW");
		labelPw.setBounds(31, 84, 67, 15);
		add(labelPw);
		
		inputPw = new JPasswordField();
		inputPw.setBounds(100, 84, 116, 21);
		add(inputPw);
		inputPw.setColumns(10);
		
		JLabel labelName = new JLabel("Name");
		labelName.setBounds(31, 128, 67, 15);
		add(labelName);
		
		inputName = new JTextField(sc.loginMem.getName());
		inputName.setBounds(100, 128, 116, 21);
		add(inputName);
		inputName.setColumns(10);
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(31, 172, 67, 15);
		add(labelEmail);
		
		inputEmail = new JTextField(sc.loginMem.getEmail());
		inputEmail.setBounds(100, 172 , 116, 21);
		add(inputEmail);
		inputEmail.setColumns(10);
		
		JButton btn = new JButton("수정");
		btn.setBounds(31, 230, 180, 50);
		add(btn);
		
		btn.addActionListener(this);
		
		setVisible(true);
		addWindowListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		SingletonClass sc = SingletonClass.getInstance();
		if(inputId.getText().equals("") ||
				inputPw.getText().equals("") ||
				inputName.getText().equals("") ||
				inputEmail.getText().equals("")){
			JOptionPane.showMessageDialog(null, "빈칸을 채워주십시오");
			return;
		}
		
		if(inputPw.getText().equals(sc.loginMem.getPw())){
			String id = inputId.getText();
			String pw = inputPw.getText();
			String name = inputName.getText();
			String email = inputEmail.getText();
			memberDTO dto = new memberDTO(id, pw, name, email);
			dto.setSeqNum(sc.loginMem.getSeqNum());
			dto.setAuth(1);
			sc.memDao.updateMember(dto);
			
			sc.memDao.fileLoad();
			sc.loginMem = dto;
			new frame3();
			dispose();
		}else{
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
		}
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		int ch = JOptionPane.showConfirmDialog(null, "창을 닫으시면 회원정보가 수정되지 않습니다. 그래도 끄시겠습니까?");
		if(ch == 0){
			System.exit(0);
		}else{
			new frame4();
			this.dispose();
		}
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}

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



public class frame1 extends JFrame implements ActionListener, WindowListener {

	private JButton btn1;
	private JButton btn2;
	private JTextField textField;
	private JPasswordField pwField;
	
	
	public frame1() {
		super("첫번째 프레임");
		
//		JButton btn = new JButton("이동");
//		btn.setBounds(10, 10, 100, 100);
//		btn.addActionListener(this);
//		add(btn);
		
		getContentPane().setBackground(new Color(255, 0, 0));
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
		addWindowListener(this);
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
			
			memberDTO dto = new memberDTO();
			dto.setId(id);
			dto.setPw(pw);
			
			dto = sc.memDao.login(dto);
			
			if(dto != null){
				JOptionPane.showMessageDialog(null,(dto.getId() + "님 반갑습니다."));
				sc.loginMem = dto;
				new frame3();
				dispose();
			}else{
				JOptionPane.showMessageDialog(null, "아이디나 비밀번호가 틀립니다.");
			}
			
			
		}else if(obj == btn2){
			new frame2();
			dispose();

		}
		
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		//System.out.println("frame1종료!!");
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		//System.out.println("frame1종료!!");
		SingletonClass sc = SingletonClass.getInstance();
		System.out.println("frame1종료!!");
		sc.memDao.fileLoad();
		
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

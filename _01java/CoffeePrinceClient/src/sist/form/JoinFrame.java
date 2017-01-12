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

public class JoinFrame extends JFrame implements ActionListener{
	private JTextField inputId;
	private JPasswordField inputPw;
	private JTextField inputName;
	private JTextField inputAge;
	private boolean chId;
	private String selId;
	
	public JoinFrame() {
		setLayout(null);
		getContentPane().setBackground(new Color(255, 255, 255));
		chId = false;
		setBounds(200, 100, 320, 400);
		
		

		
		JLabel title = new JLabel("회원가입 화면", JLabel.CENTER);
		title.setBounds(41, 0, 200, 20);
		add(title);
		
		JLabel labelId = new JLabel("ID");
		labelId.setBounds(31, 40, 67, 15);
		add(labelId);
		
		inputId = new JTextField();
		inputId.setBounds(100, 40, 116, 21);
		add(inputId);
		inputId.setColumns(10);
		
		JButton checkId = new JButton("chId");
		checkId.setBounds(220, 40, 62, 21);
		add(checkId);
		
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
		
		inputName = new JTextField();
		inputName.setBounds(100, 128, 116, 21);
		add(inputName);
		inputName.setColumns(10);
		
		JLabel labelEmail = new JLabel("Age");
		labelEmail.setBounds(31, 172, 67, 15);
		add(labelEmail);
		
		inputAge = new JTextField();
		inputAge.setBounds(100, 172 , 116, 21);
		add(inputAge);
		inputAge.setColumns(10);
		
		JButton btn = new JButton("JOIN");
		btn.setBounds(31, 230, 180, 50);
		add(btn);
		
		btn.addActionListener(this);
		checkId.addActionListener(this);
		
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				SingletonClass sc = SingletonClass.getInstance();
				
				if(sc.memDao.list.size() == 0) System.exit(0);
		
				sc.memDao.fileLoad();
				
			}
			
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		String btnStr = btn.getLabel();
		if(btnStr.equals("JOIN")){
			String id = inputId.getText();
			if(inputId.getText().equals("") ||
					inputPw.getText().equals("") ||
					inputName.getText().equals("") ||
					inputAge.getText().equals("")){
				JOptionPane.showMessageDialog(null, "빈칸을 채워주십시오");
				return;
			}
			if(!(selId.equals(id)))	chId = false;
			if(chId){
				
				
				SingletonClass sc = SingletonClass.getInstance();
				
				
				String pw = inputPw.getText();
				String name = inputName.getText();
				String age = inputAge.getText();
				MemDTO dto = new MemDTO(id, pw, name, Integer.parseInt(age), 0);
				dto.setConnect(false);
				
				sc.memDao.addMember(dto);
				sc.networkDto1 = dto;
				sc.networkDto1.setJoin(true);
				sc.wc.sendMsg();
				sc.memDao.fileLoad();
				
				sc.networkDto1 = null;
				new LoginFrame();
				dispose();
			}else{
				JOptionPane.showMessageDialog(null, "Id 중복체크를 하셔야 합니다.");
			}
			
		}else if(btnStr.equals("chId")){
			SingletonClass sc = SingletonClass.getInstance();
			
			String id = inputId.getText();
			
			if(id.equals("")){
				JOptionPane.showMessageDialog(null, "Id를 기입하십시오");
				return;
			}
			chId = sc.memDao.checkId(id);
			if(!chId){
				JOptionPane.showMessageDialog(null, "중복된 Id가 존재합니다");
			}else{
				JOptionPane.showMessageDialog(null, "Id 사용 가능!");
				selId = id;
			}
			
		}
		
	}
	
}





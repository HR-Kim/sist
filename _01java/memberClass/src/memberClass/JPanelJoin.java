package memberClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JPanelJoin extends JPanel implements ActionListener{
	
	private JPanelContainer jc;
	private JTextField inputId;
	private JPasswordField inputPw;
	private JTextField inputName;
	private JTextField inputEmail;
	
	public JPanelJoin(JPanelContainer jc) {
		this.jc = jc;
		setLayout(null);
		
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
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(31, 172, 67, 15);
		add(labelEmail);
		
		inputEmail = new JTextField();
		inputEmail.setBounds(100, 172 , 116, 21);
		add(inputEmail);
		inputEmail.setColumns(10);
		
		JButton btn = new JButton("JOIN");
		btn.setBounds(31, 230, 180, 50);
		add(btn);
		
		btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		jc.chage("login");
		
	}
	
	
}







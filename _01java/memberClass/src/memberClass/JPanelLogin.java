package memberClass;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JPanelLogin extends JPanel implements ActionListener{
	
	private JButton btn1;
	private JButton btn2;
	private JTextField textField;
	private JPasswordField pwField;
	private JPanelContainer jc;
	
	public JPanelLogin(JPanelContainer jc) {
		this.jc = jc;
		
		setLayout(null);
		
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btn1){
			//System.out.println("btn1");
			
		}else if(obj == btn2){
			//System.out.println("btn2");
			jc.chage("join");
		}
		
	}
	
	

}









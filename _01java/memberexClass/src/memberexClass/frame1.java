package memberexClass;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frame1 extends JFrame implements ActionListener{
	JTextField textId = null;
	JTextField textPw = null;
	
	JButton joinbtn = null;
	JButton logbtn = null;
	
	public frame1() {
		setSize(200, 280);
		setLayout(null);
		getContentPane().setBackground(Color.green);
		
		
		JLabel labelId = new JLabel("ID");
		labelId.setBounds(40, 40, 20, 25);
		add(labelId);
		
		textId = new JTextField();
		textId.setBounds(80, 40, 80, 25);
		add(textId);
		
		JLabel labelPw = new JLabel("PW");
		labelPw.setBounds(40, 80, 20, 25);
		add(labelPw);
		
		textPw = new JTextField();
		textPw.setBounds(80, 80, 80, 25);
		add(textPw);
		
		logbtn = new JButton("login");
		logbtn.setBounds(20, 120, 70, 30);
		add(logbtn);
		
		joinbtn = new JButton("join");
		joinbtn.setBounds(100, 120, 70, 30);
		add(joinbtn);
		
		logbtn.addActionListener(this);
		joinbtn.addActionListener(this);
		
		setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob == logbtn){
			
		}else if(ob == joinbtn){
			
		}
		
	}
	
	
}









import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JPanel02 extends JPanel implements ActionListener{
	private JTextField textField;
	private JPasswordField pwField;
	private JPanelTest win;
	
	public JPanel02(JPanelTest win) {
		setLayout(null);
		this.win = win;
		
		JLabel labelID = new JLabel("ID");
		labelID.setBounds(31, 40, 67, 15);
		add(labelID);
		
		textField = new JTextField();
		textField.setBounds(100, 40, 116, 21);
		add(textField);
		textField.setColumns(10);
		
		pwField = new JPasswordField();
		JLabel labelPW = new JLabel("Pass");
		labelPW.setBounds(31, 84, 67, 15);
		add(labelPW);
		
		pwField = new JPasswordField();
		pwField.setBounds(100, 84, 116, 21);
		add(pwField);
		
		JButton btn = new JButton("button");
		btn.setSize(70, 20);
		btn.setLocation(10, 10);
		add(btn);
		
		btn.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		win.change("panel01");
		
	}
	
}

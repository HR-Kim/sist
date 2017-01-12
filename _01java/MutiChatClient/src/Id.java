import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Id extends JFrame implements ActionListener{

	private static JTextField tf = new JTextField(8);
	private JButton btn = new JButton("입력");
	WriteClass wt; 
	ClientFrame cf;
	public Id() {}
	
	public Id(WriteClass wt, ClientFrame cf) {
		super("아이디 입력");
		this.wt = wt;
		this.cf = cf;
		
		setLayout(new FlowLayout());
		add(new Label("아이디"));
		
		
		add(tf);
		
		
		add(btn);
		
		btn.addActionListener(this);
		
		setBounds(300, 300, 250, 200);
		setVisible(true);
		
	}
	
	public static String getId(){
		return tf.getText();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		wt.sendMsg();
		cf.isFirst = false;
		cf.setVisible(true);
		cf.setTitle(getId() + "님");
		this.dispose();
	}

}

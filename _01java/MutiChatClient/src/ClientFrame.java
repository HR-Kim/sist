import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientFrame extends JFrame implements ActionListener {

	JTextArea txtA = new JTextArea();
	JTextField txtF = new JTextField(14);
	JButton btnTransfer = new JButton("전송");
	JButton btnExit = new JButton("닫기");
	
	boolean isFirst = true;
	
	JPanel pl = new JPanel();
	
	Socket socket = null;
	WriteClass wt;
	public ClientFrame(Socket socket) {
		super("채팅");
		
		
		this.socket = socket;
		wt = new WriteClass(this);
		new Id(wt, this);
		
		
	
		add("Center", txtA);
		
		pl.add(txtF);
		pl.add(btnTransfer);
		pl.add(btnExit);
		
		add("South", pl);
		
		btnTransfer.addActionListener(this);
		btnExit.addActionListener(this);
		
		setBounds(300, 300, 350, 300);
		setVisible(false);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String id = Id.getId();
		
		if(e.getSource() == btnTransfer){
			if(txtF.getText().equals(""))return;
			
			txtA.append("[" + id + "]" + txtF.getText() + "\n");
			wt.sendMsg();
			txtF.setText("");
		}else{
			this.dispose();
		}

	}

}

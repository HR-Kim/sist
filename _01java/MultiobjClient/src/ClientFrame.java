import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	
	Socket socket;
	WriteClass wt;
	
	NetworkDTO dto;
	
	public ClientFrame(Socket socket) {
		super("채팅");
		
		this.socket = socket;
		wt = new WriteClass(this);		
						
		add("Center", txtA);
		
		//pl.setLayout(null);
		//pl.setBounds(250, 0, 350, 100);
		
		//txtF.setBounds(250, 0, 150, 30);
		
		pl.add(txtF);
		pl.add(btnTransfer);
		pl.add(btnExit);		
		add("South", pl);
		
		btnTransfer.addActionListener(this);
		btnExit.addActionListener(this);		
		setBounds(300, 300, 350, 300);
		setVisible(true);
		
		dto = new NetworkDTO();		
		dto.setNumber(1);
		dto.setName("홍길동");
		dto.setPlay(1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				
		if(e.getSource() == btnTransfer){
			
			if(txtF.getText().equals("")) return;
						
			if(dto.getNumber() == dto.getPlay()){
				wt.sendMsg();
			}else{
				JOptionPane.showMessageDialog(null, "당신 차례가 아닙니다");
			}
						
			txtF.setText("");
		}else{
			this.dispose();
		}
	}

}

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class WindowTest extends Frame implements WindowListener, ActionListener {

	Button button1;
	Button button2;
	
	Label label;
	
	public WindowTest() {
		/*
		 * Handle : 번호 
		 * 		버튼, 레이블,  
		 * 
		 */
		
		
		setSize(640, 480);
		setTitle("button event");
		setLayout(new GridLayout(2, 1));
		
		label = new Label("----");
		add(label);
		
		Panel panel = new Panel();
		
		panel.setLayout(new GridLayout(1, 2));
		
		
		button1 = new Button("Button1");
		button1.addActionListener(this);
		panel.add(button1);
		
		button2 = new Button("Button2");
		button2.addActionListener(this);
		panel.add(button2);
		add(panel);
		setVisible(true);
		
		addWindowListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		Button btn = (Button)e.getSource();
		String btnStr = btn.getLabel();
		
		if(btnStr.equals("Button1")){
			System.out.println("Button1 Click");
			label.setText("Button1 클릭");
			
			JOptionPane.showMessageDialog(null, "자신의메세지");
		}else if(btnStr.equals("Button2")){
			System.out.println("Button2 Click");
			label.setText("Button2 클릭");
		}
		
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}

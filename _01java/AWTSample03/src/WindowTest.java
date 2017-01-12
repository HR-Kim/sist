import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowTest extends JFrame implements WindowListener {
	Label label;
	Button button;
	TextField textField;
	public WindowTest() {
		//super("title");
		setSize(640, 480);
		setTitle("title");
		setLayout(new GridLayout(3, 2));
		
		//label
		label = new Label();
		label.setText("레이블");
		add(label);
		
		//button
		button = new Button();
		button.setLabel("버튼");
		add(button);
		
		//textfield
		textField = new TextField();
		textField.setText("text");
		add(textField);
		
		System.out.println(textField.getText());
		
		setLocation(200, 200);
		setVisible(true);
		
		addWindowListener(this);
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

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

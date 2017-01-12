import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.*;

import javax.swing.JFrame;

public class WindowListenerImpl extends JFrame implements WindowListener{

	public WindowListenerImpl() {
		super("simpe Example");
		
		setSize(640, 480);
		setLocation(300, 300);
		setVisible(true);
		
		addWindowListener(this);
	}
	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("WindowClosed");
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("WindowOpened");
	}
	
}

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest implements WindowListener{
	public WindowTest() {
		Frame frame;
		frame = new Frame("Window Test");
		frame.setSize(240, 240);
		frame.setVisible(true);
		
		// Label
		Label label;
		label = new Label("Here is label");
		
		frame.add(label);
		
		
		frame.addWindowListener(this);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("WindowClosed");
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("WindowClosing");
		System.exit(0);
		
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

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowTest extends JFrame implements WindowListener {
	public WindowTest() {
		
		setSize(640, 480);
		
		//Layout - BorderLayout
		setLayout(new BorderLayout());	//동서남북 센터로 나뉘어진 레이아웃
				
		Label label = new Label("북쪽 레이블");
		add(label, BorderLayout.NORTH);
		
		Label label1 = new Label("서쪽 레이블");
		add(label1, BorderLayout.WEST);
		
		Label label2 = new Label("동쪽 레이블");
		add(label2, BorderLayout.EAST);
		
		Label label3 = new Label("남쪽 레이블");
		add(label3, BorderLayout.SOUTH);
		
		Label label4 = new Label("중앙 레이블");
		add(label4, BorderLayout.CENTER);
		
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

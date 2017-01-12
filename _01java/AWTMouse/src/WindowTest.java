import java.applet.Applet;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WindowTest extends Applet implements MouseListener{

	Label label;
	int x, y;
	public WindowTest() {
		Frame frame = new Frame();
		
		frame.setSize(640, 480);
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());
		
		frame.addMouseListener(this);
		
		label = new Label("x = y = ");
		frame.add(label);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 UP");
		x = e.getX();
		y = e.getY();
		
		label.setText("x:" + x + "y:" + y);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("마우스 Move");
		x = e.getX();
		y = e.getY();
		
		label.setText("x:" + x + "y:" + y);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		
		label.setText("x:" + x + "y:" + y);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("마우스 DOWN");
		x = e.getX();
		y = e.getY();
		
		label.setText("x:" + x + "y:" + y);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		
		label.setText("x:" + x + "y:" + y);
		System.out.println("마우스 Up");
	}

}

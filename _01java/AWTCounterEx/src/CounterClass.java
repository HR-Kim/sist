import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CounterClass extends Frame implements WindowListener, ActionListener {

	Label label;
	Button button1;
	Button button2;
	Button button3;
	int res = 0;
	public CounterClass() {
		setSize(640, 480);
		setTitle("Counter Event");
		
		label = new Label(String.valueOf(res));
		setLayout(new GridLayout(3, 1));
		add(label);
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(1, 2));
		
		button1 = new Button("+");
		button1.addActionListener(this);
		panel.add(button1);
		
		button2 = new Button("-");
		button2.addActionListener(this);
		panel.add(button2);
		
		add(panel);
		
		button3 = new Button("RESET");
		button3.addActionListener(this);
		add(button3);
		
		setVisible(true);
		
		
		
		addWindowListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		Button btn = (Button)e.getSource(); 
		String btnStr = btn.getLabel();
		
		if(btnStr.equals("+")){
			res++;
			System.out.println("+ Click");
			label.setText(String.valueOf(res));
		}else if(btnStr.equals("-")){
			res--;
			System.out.println("- Click");
			label.setText(String.valueOf(res));
		}else if(btnStr.equals("RESET")){
			res = 0;
			System.out.println("RESET Click");
			label.setText(String.valueOf(res));
		}
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
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

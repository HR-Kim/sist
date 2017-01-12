import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowTest extends JFrame implements ActionListener, WindowListener, ItemListener {
	
	Checkbox cb1, cb2, cb3, cb4, cb5;
	Label label1, label2;

	public WindowTest() {	//Constructor
		setSize(200, 200);
		setTitle("Radio");
		
		setLayout(new FlowLayout());
		
		CheckboxGroup cbg1 = new CheckboxGroup();
		CheckboxGroup cbg2 = new CheckboxGroup();
		
		cb1 = new Checkbox("C Language", cbg1, false);
		cb2 = new Checkbox("Java", cbg1, true);
		
		cb3 = new Checkbox("Oracle", cbg2, false);
		cb4 = new Checkbox("ObjectiveC", cbg2, false);
		cb5 = new Checkbox("Exit");
		
		label1 = new Label("Label");
		label2 = new Label();
		
		add(cb1);
		add(cb2);
		add(cb3);
		add(cb4);
		add(cb5);
		add(label1);
		add(label2);
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		cb4.addItemListener(this);
		cb5.addItemListener(this);
		
		
		setVisible(true);
		addWindowListener(this);
		
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getItemSelectable();
		Checkbox cb = (Checkbox) obj;
		
		if(cb.getState()){
			label1.setText(cb.getLabel());
			
			String lab = cb.getLabel();
			if(lab.equalsIgnoreCase("exit")){
				System.exit(0);
			}
		}
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

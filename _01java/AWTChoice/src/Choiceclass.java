import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;

public class Choiceclass extends JFrame implements ItemListener {

	Choice choice;
	Label label;
	
	public Choiceclass() {
		
		setSize(400, 400);
		setLayout(new FlowLayout());
		setVisible(true);
		
		choice = new Choice();
		label = new Label("df");
		
		choice.add("Apple");
		choice.add("Mango");
		choice.add("Guava");
		choice.add("Orange");
		choice.add("Pineapple");
		choice.add("Grape");
		choice.addItemListener(this);
		label.setText(choice.getSelectedItem());
		
		add(choice);
		add(label);
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		//Choice c = (Choice)e.getSource();
		//String selected = c.getSelectedItem();
//		if(selected.equals("Apple")){
//			label.setText("Apple Choice");
//		}else if(selected.equals("Mango")){
//			label.setText("Mango Choice");
//		}else if(selected.equals("Guava")){
//			label.setText("Guava Choice");
//		}
		label.setText(choice.getSelectedItem());

	}

}

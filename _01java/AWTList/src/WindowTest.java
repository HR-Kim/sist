import java.awt.Checkbox;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WindowTest extends JFrame implements WindowListener, ActionListener, ItemListener {
	

	List list;
	Checkbox check;
	
	Label label;
	
	double toRad;
	String num = "45";
	
	public WindowTest() {
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		
		toRad = 1.0;
		
		label = new Label(num);
		
		add(label);
		
		list = new List();
		list.add("root");
		list.add("sin");
		list.add("cos");
		list.add("tan");
		list.addItemListener(this);
		add(list);
		
		//CheckBox
		check = new Checkbox("Degree", false);
		//check.setState(false);
		check.addItemListener(this);
		
		add(check);
		
		setSize(640, 480);
		setTitle("List CheckBox");
		setLayout(gridbag);
		
		
		setVisible(true);
		addWindowListener(this);
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		//누르고 있는 상태에서 이벤트를 가하는 상황에서 사용
		Object scr = e.getSource();
		if(scr == list){
			  int itemNo = list.getSelectedIndex();
			  
			  double b, c;
			  
			  b = Double.parseDouble(num);
			  c = 0.0;
			  
			  switch(itemNo) {
			  case 0:
				  c = Math.sqrt(b);
//				  JOptionPane.showMessageDialog(null, "루트를 선택");
				  break;
			  case 1:
				  c = Math.sin(toRad*b);
//				  JOptionPane.showMessageDialog(null, "sin을 선택");
				  break;
			  case 2:
				  c = Math.cos(toRad*b);
//				  JOptionPane.showMessageDialog(null, "cos를 선택");
				  break;
			  case 3:
				  c = Math.tan(toRad*b);
//				  JOptionPane.showMessageDialog(null, "tan를 선택");
				  break;
			  }
			  
			  label.setText(c+"");
		 }
			  
		 if(scr == check){
				  
				 
				  if(check.getState()){
					  JOptionPane.showMessageDialog(null, "check를 선택");
					  
					  /*
					  String str = label.getText();
					  double d = Double.parseDouble(str);
					  d = d * Math.PI / 180.0;
					  label.setText(d+"");
					  */
					  
				  }else{
					  label.setText("1");
				  }
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//클릭할 때 마다 이벤트를 가하는 상황에서 사용

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		
	}
		

	@Override
	public void windowIconified(WindowEvent arg0) {
	

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		

	}

}

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class Explore extends Frame implements MouseListener, ActionListener, FocusListener {

	Panel pW = new Panel();
	Panel pC = new Panel();
	Panel pE = new Panel();
	Panel global = new Panel();
	
	List listL = new List(20, true);
	List listR = new List(20, true);
	
	TextField tfL = new TextField();
	TextField tfR = new TextField();
	
	Button btR = new Button(">");
	Button btR_all = new Button(">>");
	
	Button btL = new Button("<");
	Button btL_all = new Button("<<");
	
	public Explore() {
		super("Explorer");
		
		pW.setLayout(new BorderLayout(0, 10));
		pW.add("Center", listL);
		pW.add("South", tfL);
		pE.setLayout(new BorderLayout(0, 10));
		pE.add("Center", listR);
		pE.add("South", tfR);
		
		pC.setLayout(new GridLayout(4, 1, 0, 20));
		pC.add(btR);
		pC.add(btR_all);
		pC.add(btL);
		
		btL_all.setBounds(10, 10, 30, 20);
		pC.add(btL_all);
		
		global.setLayout(new GridLayout(1, 3, 15, 0));
		global.add(pW);
		global.add(pC);
		global.add(pE);
		
		setLayout(null);
		global.setBounds(10,  30 , 280, 360);
		add(global);
		
		setBounds(200, 150, 300, 400);
		setResizable(false);
		setVisible(true);
		
		tfL.addActionListener(this);
		tfR.addActionListener(this);
		
		btL.addActionListener(this);
		btL_all.addActionListener(this);
		
		btR.addActionListener(this);
		btR_all.addActionListener(this);
		
		addWindowListener(new WindowListenerImpl());
		
		tfL.addFocusListener(this);
		tfR.addFocusListener(this);
		
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		System.out.println("포커스가 들어왔다.");

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		System.out.println("포커스가 나갔다.");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == tfL){
			String tmp = tfL.getText();
			tfL.setText("");
			if(tmp.trim().isEmpty()){
				return;
			}
			listL.add(tmp);
		}else if(ob == tfR){
			
		}else if(ob == btL){
			
		}else if(ob == btL_all){
		
		}else if(ob == btR){
			System.out.println("btR");
			String tmp = listL.getSelectedItem();
			if(tmp == null){
				JOptionPane.showMessageDialog(null, "Please Select");
				return;
			}
			listR.add(tmp);
			listL.remove(tmp);
		}else if(ob == btR_all){
			System.out.println("btR_all");
			String tmp[] = listL.getItems();
			for(int i=0; i<tmp.length; ++i){
				listR.add(tmp[i]);
			}
			listL.removeAll();
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

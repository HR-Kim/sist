import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JPanel01 extends JPanel {
	private JButton btn01;
	private JScrollPane jScrollPane01;
	private JTextArea jTextArea01;
	private JPanelTest win;
	
	public JPanel01(JPanelTest win) {
		this.win = win;
		setLayout(null);
		
		btn01 = new JButton("button");
		btn01.setSize(70, 20);
		btn01.setLocation(10, 10);
		add(btn01);
		
		jTextArea01 = new JTextArea();
		jScrollPane01 = new JScrollPane(jTextArea01);
		jScrollPane01.setSize(200, 150);
		jScrollPane01.setLocation(10, 40);
		add(jScrollPane01);
		
		btn01.addActionListener(new MyActionListener());
		
		
	}
	
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			win.change("panel02");
			
		}
		
	}
}









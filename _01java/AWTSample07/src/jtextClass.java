import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

public class jtextClass extends JFrame {
	
	JTextArea area;
	JTextField textf;
	
	public jtextClass() {
		
		setTitle("textArea textField");
		setBounds(100, 100, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JPanel panel = new JPanel();
		
		area = new JTextArea();
		area.setLineWrap(true);
		
		JScrollPane scrPane = new JScrollPane(area);
		scrPane.setPreferredSize(new Dimension(200, 120));
		panel.add(scrPane);
		
		JPanel botpan = new JPanel();
		
		textf = new JTextField(10);
		
		JButton btn1 = new JButton("끝에 추가");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				area.append("\n" + textf.getText());
				
			}
		});
		
		JButton btn2 = new JButton("앞에 추가");
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					area.insert(textf.getText(), area.getLineStartOffset(0));
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		botpan.add(textf);
		botpan.add(btn1);
		botpan.add(btn2);
		
		Container contentPane = getContentPane();
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(botpan, BorderLayout.SOUTH);
	}
}

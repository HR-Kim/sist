package swingClass;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JPanelEx extends JPanel {
	public JPanelEx() {
		setBackground(Color.red);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawRect(1, 1, 198, 198);
		g.fillOval(20, 20, 160, 160);
	}
	
	public Dimension getPerFerredSize() {
		return new Dimension(100, 100);
	}
}

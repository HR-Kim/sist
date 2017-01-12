package sist.form;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import sist.dao.SingletonClass;
import sist.dto.MemDTO;

public class MenuFrame extends JFrame implements MouseMotionListener{
	JLabel mPos;
	
	public MenuFrame() {

		Font f = new Font("Monospaced", Font.BOLD, 25);
		Font f1 = new Font("Monospaced", Font.BOLD, 17);
		Font f2 = new Font("Monospaced", Font.PLAIN, 13);
		setLayout(null);
		setBounds(800, 100, 640, 480);
		
		//mPos = new JLabel("");
		//mPos.setBounds(10, 10, 80, 30);
		//add(mPos);
		
		JLabel title = new JLabel("Menu");
		title.setBounds(280, 20, 80, 50);
		title.setFont(f);
		add(title);
		
		JLabel m = new JLabel("Espresso Beverages");
		m.setBounds(30, 70, 450, 50);
		m.setFont(f1);
		add(m);
		
		JLabel sp = new JLabel("Short");
		sp.setBounds(250, 70, 450, 50);
		sp.setFont(f1);
		add(sp);
		
		JLabel tp = new JLabel("Tall");
		tp.setBounds(370, 70, 450, 50);
		tp.setFont(f1);
		add(tp);
		
		JLabel gp = new JLabel("Grande");
		gp.setBounds(490, 70, 450, 50);
		gp.setFont(f1);
		add(gp);
		
		JLabel m1 = new JLabel("Hazelnut Caramel Mocha");
		m1.setBounds(30, 100, 450, 50);
		m1.setFont(f2);
		add(m1);
		
		JLabel sp1 = new JLabel("4800");
		sp1.setBounds(250, 100, 450, 50);
		sp1.setFont(f2);
		add(sp1);
		
		JLabel tp1 = new JLabel("5300");
		tp1.setBounds(370, 100, 450, 50);
		tp1.setFont(f2);
		add(tp1);
		
		JLabel gp1 = new JLabel("5800");
		gp1.setBounds(490, 100, 450, 50);
		gp1.setFont(f2);
		add(gp1);
		
		JLabel m2 = new JLabel("Caramel Makiatto");
		m2.setBounds(30, 130, 450, 50);
		m2.setFont(f2);
		add(m2);
		
		JLabel sp2 = new JLabel("4300");
		sp2.setBounds(250, 130, 450, 50);
		sp2.setFont(f2);
		add(sp2);
		
		JLabel tp2 = new JLabel("4800");
		tp2.setBounds(370, 130, 450, 50);
		tp2.setFont(f2);
		add(tp2);
		
		JLabel gp2 = new JLabel("5300");
		gp2.setBounds(490, 130, 450, 50);
		gp2.setFont(f2);
		add(gp2);
		
		JLabel m3 = new JLabel("White Chocolate Mocha");
		m3.setBounds(30, 160, 450, 50);
		m3.setFont(f2);
		add(m3);
		
		JLabel sp3 = new JLabel("4300");
		sp3.setBounds(250, 160, 450, 50);
		sp3.setFont(f2);
		add(sp3);
		
		JLabel tp3 = new JLabel("4800");
		tp3.setBounds(370, 160, 450, 50);
		tp3.setFont(f2);
		add(tp3);
		
		JLabel gp3 = new JLabel("5300");
		gp3.setBounds(490, 160, 450, 50);
		gp3.setFont(f2);
		add(gp3);
		
		JLabel m4 = new JLabel("Caramel Mocha");
		m4.setBounds(30, 190, 450, 50);
		m4.setFont(f2);
		add(m4);
		
		JLabel sp4 = new JLabel("4300");
		sp4.setBounds(250, 190, 450, 50);
		sp4.setFont(f2);
		add(sp4);
		
		JLabel tp4 = new JLabel("4800");
		tp4.setBounds(370, 190, 450, 50);
		tp4.setFont(f2);
		add(tp4);
		
		JLabel gp4 = new JLabel("5300");
		gp4.setBounds(490, 190, 450, 50);
		gp4.setFont(f2);
		add(gp4);
		
		JLabel m5 = new JLabel("Caffe Mocha");
		m5.setBounds(30, 220, 450, 50);
		m5.setFont(f2);
		add(m5);
		
		JLabel sp5 = new JLabel("3800");
		sp5.setBounds(250, 220, 450, 50);
		sp5.setFont(f2);
		add(sp5);
		
		JLabel tp5 = new JLabel("4300");
		tp5.setBounds(370, 220, 450, 50);
		tp5.setFont(f2);
		add(tp5);
		
		JLabel gp5 = new JLabel("4800");
		gp5.setBounds(490, 220, 450, 50);
		gp5.setFont(f2);
		add(gp5);
		
		JLabel m6 = new JLabel("Caramel Latte");
		m6.setBounds(30, 250, 450, 50);
		m6.setFont(f2);
		add(m6);
		
		JLabel sp6 = new JLabel("3800");
		sp6.setBounds(250, 250, 450, 50);
		sp6.setFont(f2);
		add(sp6);
		
		JLabel tp6 = new JLabel("4300");
		tp6.setBounds(370, 250, 450, 50);
		tp6.setFont(f2);
		add(tp6);
		
		JLabel gp6 = new JLabel("4800");
		gp6.setBounds(490, 250, 450, 50);
		gp6.setFont(f2);
		add(gp6);
		
		JLabel m7 = new JLabel("Caffe Latte");
		m7.setBounds(30, 280, 450, 50);
		m7.setFont(f2);
		add(m7);
		
		JLabel sp7 = new JLabel("3300");
		sp7.setBounds(250, 280, 450, 50);
		sp7.setFont(f2);
		add(sp7);
		
		JLabel tp7 = new JLabel("3800");
		tp7.setBounds(370, 280, 450, 50);
		tp7.setFont(f2);
		add(tp7);
		
		JLabel gp7 = new JLabel("4300");
		gp7.setBounds(490, 280, 450, 50);
		gp7.setFont(f2);
		add(gp7);
		
		JLabel m8 = new JLabel("Cappuccino");
		m8.setBounds(30, 310, 450, 50);
		m8.setFont(f2);
		add(m8);
		
		JLabel sp8 = new JLabel("3300");
		sp8.setBounds(250, 310, 450, 50);
		sp8.setFont(f2);
		add(sp8);
		
		JLabel tp8 = new JLabel("3800");
		tp8.setBounds(370, 310, 450, 50);
		tp8.setFont(f2);
		add(tp8);
		
		JLabel gp8 = new JLabel("4300");
		gp8.setBounds(490, 310, 450, 50);
		gp8.setFont(f2);
		add(gp8);
		
		JLabel m9 = new JLabel("Americano");
		m9.setBounds(30, 340, 450, 50);
		m9.setFont(f2);
		add(m9);
		
		JLabel sp9 = new JLabel("2800");
		sp9.setBounds(250, 340, 450, 50);
		sp9.setFont(f2);
		add(sp9);
		
		JLabel tp9 = new JLabel("3300");
		tp9.setBounds(370, 340, 450, 50);
		tp9.setFont(f2);
		add(tp9);
		
		JLabel gp9 = new JLabel("3800");
		gp9.setBounds(490, 340, 450, 50);
		gp9.setFont(f2);
		add(gp9);
		
		JLabel m10 = new JLabel("Today's Coffee");
		m10.setBounds(30, 370, 450, 50);
		m10.setFont(f2);
		add(m10);
		
		JLabel sp10 = new JLabel("2500");
		sp10.setBounds(250, 370, 450, 50);
		sp10.setFont(f2);
		add(sp10);
		
		JLabel tp10 = new JLabel("3000");
		tp10.setBounds(370, 370, 450, 50);
		tp10.setFont(f2);
		add(tp10);
		
		JLabel gp10 = new JLabel("3500");
		gp10.setBounds(490, 370, 450, 50);
		gp10.setFont(f2);
		add(gp10);
		
		setVisible(true);
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//mPos.setText("x : " + e.getX() + " y : " + e.getY());
		
	}
	
	
}

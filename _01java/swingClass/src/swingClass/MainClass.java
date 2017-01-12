package swingClass;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainClass extends JApplet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("mainClass destroy");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("mainClass init");
		
		JFrame jframe = new JFrame("jframe");
		
//		jframe.setBounds(0, 0, 400, 00);
//		jframe.setVisible(true);
//		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		
//		Icon icon = new ImageIcon("C:\\javaCollection\\swingClass\\WebContent\\__.jpg");
//		
//		JButton btn1 = new JButton("Image button", icon);
//		JButton btn2 = new JButton("Text button");
//		
//		setLayout(new GridLayout(2, 1));
//		add(btn1);
//		add(btn2);
		
		//Pannel
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
//		JPanelEx opq = new JPanelEx();
//		JPanelEx tp = new JPanelEx();
//		
//		
//		
//		tp.setOpaque(false);
//		contentPane.add(opq);
//		contentPane.add(tp);
		
		//Label
		Icon icon = new ImageIcon("C:\\javaCollection\\swingClass\\WebContent\\__.jpg");
		JLabel jlabel = new JLabel(icon, SwingConstants.CENTER);
		
		getContentPane().add(jlabel);
		
		//textfield
		JTextField textField = new JTextField("여기에 입력");
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(textField, BorderLayout.NORTH);
		
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		super.start();
		System.out.println("mainClass start");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
		System.out.println("mainClass stop");
	}

//	public static void main(String[] args) {
		/*
		JFrame jframe = new JFrame("jframe");
		
		//JButton
		
//		
//		jframe.setLayout(new GridLayout(2, 1));
//		//getContentPane();
//		
//		jframe.add(btn1);
//		jframe.add(btn2);
		
		//JPanel
		Container contentPane = jframe.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JPanelEx opq = new JPanelEx();
		JPanelEx tp = new JPanelEx();
		
		tp.setOpaque(false);
		contentPane.add(opq);
		contentPane.add(tp);
		
		jframe.setBounds(100, 100, 200, 300);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		*/
//	}

}

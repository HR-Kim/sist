import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener, ActionListener {

	

	Button button;
	String regA = "";	//이전에 입력한 값
	String regB = "";	//현재에 입력한 값
	String regC	= "";	
	String regD = "";
	Label label;
	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button)e.getSource();
		String btnLabel = btn.getLabel();
		double a, b, c; //숫자 두개와 결과값
		
		if(!btnLabel.equals("=")){
			if(btnLabel.equals("+") ||
				btnLabel.equals("-") ||
				btnLabel.equals("*") ||
				btnLabel.equals("/")){
				regC = btnLabel;
				regB = regA;
				regA = "";
			}else{
				regA = regA + btnLabel;
			}
		}
		System.out.println("regA = " + regA + "regB = " + regB);
		System.out.println("regC = " + regC);
		
		if(btnLabel.length() ==1){
			regD = regD + btnLabel;
		}
		if(btnLabel.equals("C")){
			regA = regB;
			regB = "";
			regD = "";
		}
		if(btnLabel.equals("=")){
			c = 0;
			a = Double.parseDouble(regB);
			b = Double.parseDouble(regA);
			if(regC.equals("+")){
				c = a+b;
			}else if(regC.equals("-")){
				c = a-b;
			}else if(regC.equals("*")){
				c = a*b;
			}else if(regC.equals("/")){
				c = a/b;
			}
			
			regD = String.valueOf(c);
			
		}
		
		label.setText(regD);
	}
	
	public WindowTest() {
		
		setSize(240, 240);
		setLayout(new GridLayout(2, 1));
		
		Label label = new Label("0");
		add(label);
		
		
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(4, 4));
		/*
		Label label2 = new Label("label1");
		panel.add(label2);
		
		Label label3 = new Label("label2");
		panel.add(label3);
		*/
		button = new Button();
		button.setLabel("1");
		button.addActionListener(this);
		panel.add(button);
		
		button = new Button();
		button.setLabel("2");
		button.addActionListener(this);
		panel.add(button);
		
		button = new Button();
		button.setLabel("3");
		button.addActionListener(this);
		panel.add(button);
		
		button = new Button();
		button.setLabel("+");
		button.addActionListener(this);
		panel.add(button);
		
		button = new Button();
		button.setLabel("4");
		button.addActionListener(this);
		panel.add(button);
		
		button = new Button();
		button.setLabel("5");
		button.addActionListener(this);
		panel.add(button);
		
		button = new Button();
		button.setLabel("6");
		button.addActionListener(this);
		panel.add(button);
		
		button = new Button();
		button.setLabel("-");
		button.addActionListener(this);
		panel.add(button);
		
		button = new Button();
		button.setLabel("7");
		button.addActionListener(this);
		panel.add(button);
		
		button = new Button();
		button.setLabel("8");
		button.addActionListener(this);
		panel.add(button);
		
		button = new Button();
		button.setLabel("9");
		button.addActionListener(this);
		panel.add(button);
		
		button = new Button();
		button.setLabel("*");
		button.addActionListener(this);
		panel.add(button);
		
		button = new Button();
		button.setLabel("C");
		button.addActionListener(this);
		panel.add(button);
		
		button = new Button();
		button.setLabel("0");
		button.addActionListener(this);
		panel.add(button);
		
		button = new Button();
		button.setLabel("=");
		button.addActionListener(this);
		panel.add(button);
		
		button = new Button();
		button.setLabel("/");
		button.addActionListener(this);
		panel.add(button);
		
		add(panel);
		
		setVisible(true);
		
		addWindowListener(this);
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AwtTest extends Frame implements WindowListener, ActionListener {
	
	Panel pN = new Panel();
	Panel pS = new Panel();
	
	Label input = new Label("input", Label.CENTER);
	
	TextField tf = new TextField();
	TextArea ta = new TextArea();
	
	Button clear = new Button("eraser");
	Button send = new Button("send");
	Button exit = new Button("exit");
	
	
	public AwtTest() {
		this.setSize(300, 400);
		this.setLocation(400, 300);
		this.setVisible(true);
		
		pN.setLayout(new BorderLayout());
		pN.add("West", input);
		pN.add("Center", tf);
		
		pS.setLayout(new GridLayout(1, 3, 10, 0));
		
		//Font
		Font f = new Font("굴림", Font.BOLD, 20);
		clear.setFont(f);
		clear.setBackground(new Color(210, 210, 150));
		clear.setForeground(Color.magenta);
		
		clear.addActionListener(this);
		send.addActionListener(this);
		exit.addActionListener(this);
		
		send.setFont(f);
		exit.setFont(f);
		
		pS.add(clear);
		pS.add(send);
		pS.add(exit);
		
		setLayout(new BorderLayout(0, 5));
		add("North", pN);
		add("Center", ta);
		add("South", pS);
		
		
		
//		public Font myFont(int size){
//			//이런식으로 자주 바꾸는 부분만 따로 메소드를 편집해서 시간절약할 수 있다!!	
//		}
		
		
		addWindowListener(this);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button)e.getSource();
		String btnStr = btn.getLabel();
		
		if(btnStr.equals("eraser")){
			tf.setText("");
		}else if(btnStr.equals("send")){
			ta.append("\n" + tf.getText());
		}else if(btnStr.equals("exit")){
			System.exit(0);
		}
		
	}



	@Override
	public void windowActivated(WindowEvent arg0) {
		System.out.println("윈도우가 활성화");
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		System.out.println("윈도우가 닫혔다");

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		System.out.println("윈도우가 비활성화");

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		System.out.println("윈도우가 열린다");

	}

}

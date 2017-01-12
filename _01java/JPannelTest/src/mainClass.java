import javax.swing.JFrame;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JPanelTest win = new JPanelTest();
		
		win.setTitle("frame change");
		win.jpanel01 = new JPanel01(win);
		win.jpanel02 = new JPanel02(win);
		
		win.add(win.jpanel01);
		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		win.setSize(300, 500);
		win.setVisible(true);
	}

}

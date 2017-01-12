package memberClass;

import javax.swing.JFrame;

public class JPanelContainer extends JFrame{
	
	public JPanelLogin panelLog = null;
	public JPanelJoin panelJoin = null;
	
	public JPanelContainer() {
		// TODO Auto-generated constructor stub
	}
	
	public void chage(String panelName){
		if(panelName.equals("login")){
			getContentPane().removeAll();
			getContentPane().add(panelLog);
			revalidate();
			repaint();
		}else if(panelName.equals("join")){
			getContentPane().removeAll();
			getContentPane().add(panelJoin);
			revalidate();
			repaint();
		}
	}
}

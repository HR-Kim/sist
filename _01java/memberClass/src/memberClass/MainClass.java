package memberClass;

public class MainClass {

	public static void main(String[] args) {
		
		JPanelContainer jc = new JPanelContainer();
		
		jc.setTitle("login");
		jc.panelJoin = new JPanelJoin(jc);
		jc.panelLog = new JPanelLogin(jc);
		
		jc.add(jc.panelLog);
		jc.setSize(300, 500);
		jc.setDefaultCloseOperation(jc.DISPOSE_ON_CLOSE);
		jc.setVisible(true);

	}

}

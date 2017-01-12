import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EatingClass extends Frame implements ActionListener, ItemListener{

	
	Panel pN = new Panel();
	Panel pS = new Panel();
	
	CheckboxGroup cg = new CheckboxGroup();
	
	//라디오 버튼(복수선택 불가)
	Checkbox mor = new Checkbox("Monring", cg, true);
	Checkbox aft = new Checkbox("Afternoon", cg, false);
	Checkbox eve = new Checkbox("Evening", cg, false);
	
	// 체크박스 (복수선택 가능)
	Checkbox apple = new Checkbox("Apple", true);
	Checkbox pear = new Checkbox("Pear");
	Checkbox banana = new Checkbox("Banana");
	
	TextArea ta = new TextArea();

	Choice ch = new Choice();
	Button exit = new Button("Exit");
	
	
	
	
	public EatingClass() {
		 super("What Eat");
		 
		 pN.setLayout(new GridLayout(2, 3, 5, 5));
		 pN.add(mor);	//radio~
		 pN.add(aft);
		 pN.add(eve);
		 pN.add(apple);	//checkbox ~
		 pN.add(pear);
		 pN.add(banana);
		 
		 pS.setLayout(new BorderLayout(10, 0));
		 
		 ch.add("Morning");
		 ch.add("Afternoon");
		 ch.add("Evening");
		 pS.add("Center", ch);
		 pS.add("East", exit);
		 
		 this.setLayout(new BorderLayout(0, 5));
		 add("Center", ta);
		 add("South", pS);
		 add("North", pN);
		 
		 setBounds(200, 150, 300, 400);
		 setResizable(false);
		 setVisible(true);
		 
		 exit.addActionListener(this);
		 
		 mor.addItemListener(this);
		 aft.addItemListener(this);
		 eve.addItemListener(this);
		 
		 apple.addItemListener(this);
		 pear.addItemListener(this);
		 banana.addItemListener(this);
		 
		 ch.addItemListener(this);
		 
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		 Object ob = e.getSource();
		 if(ob == ch){
			String selItem = ch.getSelectedItem();
			if(selItem.equals("Morning")){
				mor.setState(true);
			}else if(selItem.equals("Afternoon")){
				aft.setState(true);
			}else if(selItem.equals("Evening")){
				eve.setState(true);
			}
		 }

		 Checkbox sel = cg.getSelectedCheckbox();
		 String selLabel = sel.getLabel();
		 ta.setText("---- " + selLabel + " ----\n");
		 ta.append("1. Apple  : " + eat(apple.getState()) + "\n");
		 ta.append("2. Pear  : " + eat(pear.getState()) + "\n");
		 ta.append("3. Banana : " + eat(banana.getState()) + "\n");
		
		 ch.select(selLabel);
	}
	
	private String eat(boolean flag){
		return flag ? "Yes" : "NO";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 System.exit(0);

	}

}

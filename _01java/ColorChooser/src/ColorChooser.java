import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ColorChooser extends Frame implements AdjustmentListener {

	Panel pL = new Panel();
	Panel pL1 = new Panel();
	Panel pL2 = new Panel();
	Panel pL3 = new Panel();
	
	Panel pR = new Panel();
	Panel pR1 = new Panel();
	
	Label lR = new Label("Red", Label.CENTER);
	Label lG = new Label("Green", Label.CENTER);
	Label lB = new Label("Blue", Label.CENTER);
	
	Scrollbar sbR = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265);
	Scrollbar sbG = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265);
	Scrollbar sbB = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265);
	
	Panel colorP = new Panel();
	Label colorL = new Label();
	
	Button change = new Button("Change");
	
	public ColorChooser() {
		super("Color Table");
		
		pL1.setLayout(new BorderLayout(3, 0));
		lR.setBackground(Color.red); 
		pL1.add("West", lR);
		pL1.add("Center", sbR);
		
		pL2.setLayout(new BorderLayout(3, 0));
		lG.setBackground(Color.green);
		pL2.add("West", lG);
		pL2.add("Center", sbG);
		
		pL3.setLayout(new BorderLayout(3, 0));
		lB.setBackground(Color.blue);
		pL3.add("West", lB);
		pL3.add("Center", sbB);
		
		pL.setLayout(new GridLayout(5, 1, 0, 20));
		pL.add(new Label(""));
		pL.add(pL1);
		pL.add(pL2);
		pL.add(pL3);
		
		pR1.setLayout(new BorderLayout(10, 0));
		pR1.add("Center", colorL);
		pR1.add("East", change);
		
		pR.setLayout(new BorderLayout());
		pR.add("Center", colorP);
		pR.add("South", pR1);
		
		setLayout(new GridLayout(1, 2, 10, 0));
		add(pL);
		add(pR);
		
		setBounds(200, 150, 400, 300);
		setResizable(false);	//크기변경 제한
		setVisible(true);
		
		sbR.addAdjustmentListener(this);
		sbG.addAdjustmentListener(this);
		sbB.addAdjustmentListener(this);
		
		addWindowListener(new WindowAdapter() {	//윈도우 종료버튼 

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
			
		});
	}
	
	private void changeColor() {
		int r = sbR.getValue();
		int g = sbG.getValue();
		int b = sbB.getValue();
		
		colorP.setBackground(new Color(r, g, b));
		colorL.setText("Red:" + r + "Green:" + g + "Blue:" + b);
	}
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		//System.out.println("adjustmentValueChanged");
		changeColor();
	}

}




























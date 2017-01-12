import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class NotePad extends Frame implements ActionListener {

	MenuBar mb = new MenuBar();
	Menu file = new Menu("file");
	Menu edit = new Menu("edit");
	Menu help = new Menu("help");
	
	MenuItem open = new MenuItem("open");
	MenuItem save = new MenuItem("save");
	MenuItem make = new MenuItem("make");
	MenuItem close = new MenuItem("close");
	
	TextArea ta = new TextArea();
	
	
	public NotePad() {
		super("NotePad");
		file.add(make);
		file.add(open);
		file.add(save);
		file.addSeparator();
		file.add(close);
		
		mb.add(file);
		mb.add(edit);
		mb.add(help);
		
		add(ta);
		this.setMenuBar(mb);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		
		int w = 500;
		int h = 400;
		
		int x = ((int)d.getWidth() - w) / 2;
		int y = ((int)d.getHeight()- h) / 2;
	
		
		setBounds(x, y, w, h);
		setVisible(true);
		
		open.addActionListener(this);
		make.addActionListener(this);
		save.addActionListener(this);
		close.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == open){
			FileDialog fdOpen = new FileDialog(this, "file open", FileDialog.LOAD);
			fdOpen.setVisible(true);
			
			String fileName = fdOpen.getDirectory() + fdOpen.getFile();
			
			//JOptionPane.showConfirmDialog(null, fileName);
			
			BufferedReader reader = null;
			
			try {
				reader = new BufferedReader(new FileReader(fileName));
				String text = "";
				while((text = reader.readLine()) != null){
					ta.setText("");
					ta.append(text + "\n");
				}
			} catch (FileNotFoundException e1) {e1.printStackTrace();}
			catch (IOException e1) {e1.printStackTrace();}
			finally{
				if(reader != null){
					try {
						reader.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}else if(obj == save){
			FileDialog fdSave = new FileDialog(this, "file save", FileDialog.SAVE);
			fdSave.setVisible(true);
			
			String fileName = fdSave.getDirectory() + fdSave.getFile();
			
			String text = ta.getText();	//textArea -> String
			FileWriter writer = null;
			try {
				writer = new FileWriter(new File(fileName + ".txt"));
				writer.write(text);
			} catch (IOException e1) {
				e1.printStackTrace();
			}finally {
				try{
					if(writer != null){
						writer.close();
					}
				}catch(IOException e2){
					e2.printStackTrace();
				}
			}
		}else if(obj == close){
			System.exit(0);
		}else if(obj == make){
			ta.setText("");
		}
	}

}











package memberFrameClass;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import memberFrameDTO.BbsDTO;

public class frame5 extends JFrame implements ActionListener, WindowListener {

	private JTextField inputId;
	private JTextField inputTitle;
	private JTextArea inputContent;
	private JScrollPane jScrPane;
	
	public frame5() {
		SingletonClass sc = SingletonClass.getInstance();
		setLayout(null);
		
		Font f = new Font("굴림", Font.BOLD, 15);
		JLabel labelId = new JLabel("작성자");
		labelId.setFont(f);
		labelId.setBounds(50, 50, 60, 30);
		add(labelId);
		
		inputId = new JTextField(sc.loginMem.getId() + "");
		inputId.setEditable(false);
		inputId.setBounds(120, 50, 300, 30);
		add(inputId);
		
		JLabel labelTitle = new JLabel("제목");
		labelTitle.setFont(f);
		labelTitle.setBounds(50, 90, 60, 30);
		add(labelTitle);
		
		inputTitle = new JTextField();
		inputTitle.setBounds(120, 90, 300, 30);
		add(inputTitle);
		
		JLabel labelContent = new JLabel("내용");
		labelContent.setFont(f);
		labelContent.setBounds(50, 130, 60, 30);
		add(labelContent);
		
		inputContent = new JTextArea();
		inputContent.setLineWrap(true);
		jScrPane = new JScrollPane(inputContent);
		jScrPane.setBounds(50, 170, 370, 200);
		add(jScrPane);
		
		JButton btn = new JButton("글올리기");
		btn.setBounds(50, 380, 100, 30);
		add(btn);
		btn.addActionListener(this);
		
		getContentPane().setBackground(new Color(102, 120, 120));
		setBounds(200, 100, 640, 480);
		setVisible(true);
		
		addWindowListener(this);
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		
		int ch = JOptionPane.showConfirmDialog(null, "창을 닫으시면 게시판에 게시되지않습니다. 그래도 끄시겠습니까?");
		if(ch == 0){
			System.exit(0);
		}else{
			new frame5();
			this.dispose();
		}

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

	@Override
	public void actionPerformed(ActionEvent e) {
		Calendar cal = Calendar.getInstance();
		
		
		if(inputId.getText().equals("") ||
				inputTitle.getText().equals("") ||
				inputContent.getText().equals("")){
			JOptionPane.showMessageDialog(null, "작성자, 제목, 내용을 모두 기입하여주십시오");
			return;
		}
		//System.out.println("현재시각 : " + cal.getTime());
		String id = inputId.getText();
		String title = inputTitle.getText();
		String content = inputContent.getText();
		content = content.replaceAll("[\r\n]+", "<br>");
		//Date wdate = cal.getTime();
		SingletonClass sc = SingletonClass.getInstance();
		
		BbsDTO dto = new BbsDTO(id, title, content);
		sc.bbsDao.writeBbs(dto);
		
		sc.bbsDao.fileLoad();
		new frame3();
		dispose();
		
	}

}

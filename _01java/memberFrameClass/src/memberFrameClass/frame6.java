package memberFrameClass;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class frame6 extends JFrame implements ActionListener, WindowListener{
	
	
	public frame6() {
		SingletonClass sc = SingletonClass.getInstance();
		setLayout(null);
		
		Font f = new Font("굴림", Font.BOLD, 12);
		JLabel labelId = new JLabel("작성자");
		labelId.setFont(f);
		labelId.setBounds(50, 10, 60, 20);
		add(labelId);
		
		JTextField inputId = new JTextField(sc.selBbs.getId());
		inputId.setEditable(false);
		inputId.setBounds(120, 10, 300, 20);
		add(inputId);
		
		JLabel labelTitle = new JLabel("제목");
		labelTitle.setFont(f);
		labelTitle.setBounds(50, 40, 60, 20);
		add(labelTitle);
		
		JTextField inputTitle = new JTextField(sc.selBbs.getTitle());
		inputTitle.setEditable(false);
		inputTitle.setBounds(120, 40, 300, 20);
		add(inputTitle);
		
		JLabel labelWdate = new JLabel("작성일");
		labelWdate.setFont(f);
		labelWdate.setBounds(50, 70, 60, 20);
		add(labelWdate);
		
		JTextField inputWdate = new JTextField(sc.selBbs.getWdate());
		inputWdate.setEditable(false);
		inputWdate.setBounds(120, 70, 300, 20);
		add(inputWdate);
		
		JLabel labelCount = new JLabel("조회수");
		labelCount.setFont(f);
		labelCount.setBounds(50, 100, 60, 20);
		add(labelCount);
		
		JTextField inputCount = new JTextField(sc.selBbs.getReadcount()+"");
		inputCount.setEditable(false);
		inputCount.setBounds(120, 100, 300, 20);
		add(inputCount);
		
		JLabel labelContent = new JLabel("내용");
		labelContent.setFont(f);
		labelContent.setBounds(50, 130, 60, 20);
		add(labelContent);
		
		JTextArea inputContent = new JTextArea(sc.selBbs.getContent().replaceAll("<br>", "\r\n"));
		inputContent.setLineWrap(true);
		inputContent.setEditable(false);
		JScrollPane jScrPane = new JScrollPane(inputContent);
		jScrPane.setBounds(50, 160, 370, 160);
		add(jScrPane);
		
		if(sc.loginMem.getId().equals(sc.selBbs.getId())){
			JButton listBtn = new JButton("목록");
			listBtn.setBounds(50, 350, 100, 30);
			add(listBtn);
			listBtn.addActionListener(this);
			
			JButton updateBtn = new JButton("수정");
			updateBtn.setBounds(185, 350, 100, 30);
			add(updateBtn);
			updateBtn.addActionListener(this);
			
			JButton delBtn = new JButton("삭제");
			delBtn.setBounds(320, 350, 100, 30);
			add(delBtn);
			delBtn.addActionListener(this);
		}else{
			JButton listBtn = new JButton("목록");
			listBtn.setBounds(185, 350, 100, 30);
			add(listBtn);
			listBtn.addActionListener(this);
		}
		
		
		getContentPane().setBackground(new Color(102, 120, 120));
		setBounds(200, 100, 640, 480);
		setVisible(true);
		
		addWindowListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		String btnStr = btn.getLabel();
		
		if(btnStr.equals("목록")){
			SingletonClass sc = SingletonClass.getInstance();
			sc.bbsDao.fileLoad();
			new frame3();
			dispose();
		}else if(btnStr.equals("수정")){
			new frame7();
			dispose();
		}else if(btnStr.equals("삭제")){
			int chNum = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?");
			if(chNum == 0){
				SingletonClass sc = SingletonClass.getInstance();
				boolean b = sc.bbsDao.deleteBbs(sc.selBbs);
				if(b) sc.selBbs = null;
				if(!b) JOptionPane.showMessageDialog(null, "삭제 실패..");
				new frame3();
				dispose();
			}
			
		}
		
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}

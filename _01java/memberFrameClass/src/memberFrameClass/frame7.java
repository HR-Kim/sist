package memberFrameClass;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import memberFrameDTO.BbsDTO;

public class frame7 extends JFrame implements ActionListener{
	
	private JTextField inputId;
	private JTextField inputTitle;
	private JTextArea inputContent;
	private JScrollPane jScrPane;
	
	
	public frame7() {
		
		SingletonClass sc = SingletonClass.getInstance();
		setLayout(null);
		
		Font f = new Font("굴림", Font.BOLD, 15);
		JLabel labelId = new JLabel("작성자");
		labelId.setFont(f);
		labelId.setBounds(50, 50, 60, 30);
		add(labelId);
		
		inputId = new JTextField(sc.selBbs.getId());
		inputId.setEditable(false);
		inputId.setBounds(120, 50, 300, 30);
		add(inputId);
		
		JLabel labelTitle = new JLabel("제목");
		labelTitle.setFont(f);
		labelTitle.setBounds(50, 90, 60, 30);
		add(labelTitle);
		
		inputTitle = new JTextField(sc.selBbs.getTitle());
		inputTitle.setBounds(120, 90, 300, 30);
		add(inputTitle);
		
		JLabel labelContent = new JLabel("내용");
		labelContent.setFont(f);
		labelContent.setBounds(50, 130, 60, 30);
		add(labelContent);
		
		inputContent = new JTextArea(sc.selBbs.getContent().replaceAll("<br>", "\r\n"));
		inputContent.setLineWrap(true);
		jScrPane = new JScrollPane(inputContent);
		jScrPane.setBounds(50, 170, 370, 200);
		add(jScrPane);
		
		JButton cancelBtn = new JButton("취소");
		cancelBtn.setBounds(50, 380, 100, 30);
		add(cancelBtn);
		cancelBtn.addActionListener(this);
		
		JButton completeBtn = new JButton("수정완료");
		completeBtn.setBounds(180, 380, 100, 30);
		add(completeBtn);
		completeBtn.addActionListener(this);
		
		getContentPane().setBackground(new Color(102, 120, 120));
		setBounds(200, 100, 640, 480);
		setVisible(true);
		
		
		
		addWindowListener(new WindowAdapter() {
			
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				int ch = JOptionPane.showConfirmDialog(null, "창을 닫으시면 게시판에 게시되지않습니다. 그래도 끄시겠습니까?");
				if(ch == 0){
					System.exit(0);
				}else{
					new frame7();
					dispose();
				}
			}
			
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		String btnStr = btn.getLabel();
		if(btnStr.equals("취소")){
			new frame3();
			dispose();
		}else if(btnStr.equals("수정완료")){
			BbsDTO dto = new BbsDTO();
			String id = inputId.getText();
			String title = inputTitle.getText();
			String content = inputContent.getText();
			content = content.replaceAll("[\r\n]+", "<br>");
			
			dto.setId(id);
			dto.setTitle(title);			
			dto.setContent(content);
			SingletonClass sc = SingletonClass.getInstance();
			sc.bbsDao.updateBbs(dto);
			
			sc.bbsDao.fileLoad();
			new frame3();
			dispose();
			
		}
	}
	
}

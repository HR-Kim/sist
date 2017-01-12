package com.sist.form;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sist.dao.BoardDAO;
import com.sist.dao.MemberDAO;
import com.sist.dto.BoardDTO;

public class WriteFrame extends JFrame {
	private JTextField inputId;
	private JTextField inputTitle;
	private JTextArea inputContent;
	private JScrollPane jScrPane;
	
	public WriteFrame() {
		BoardDAO bdao = BoardDAO.getInstance();
		MemberDAO dao = MemberDAO.getInstance();
		
		setLayout(null);
		
		Font f = new Font("굴림", Font.BOLD, 15);
		JLabel labelId = new JLabel("작성자");
		labelId.setFont(f);
		labelId.setBounds(50, 50, 60, 30);
		add(labelId);
		
		inputId = new JTextField(dao.loginMem.getId());
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
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(inputId.getText().equals("") ||
						inputTitle.getText().equals("") ||
						inputContent.getText().equals("")){
					JOptionPane.showMessageDialog(null, "작성자, 제목, 내용을 모두 기입하여주십시오");
					return;
				}
				String id = inputId.getText();
				String title = inputTitle.getText();
				String content = inputContent.getText();
				BoardDTO dto = new BoardDTO(id, title, content);
				bdao.write(dto);
				
				new MainFrame();
				dispose();
				
			}
		});
		
		setBounds(200, 100, 640, 480);
		setVisible(true);
	}
}

















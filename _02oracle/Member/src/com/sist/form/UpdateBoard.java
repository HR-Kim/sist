package com.sist.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sist.dao.BoardDAO;
import com.sist.dto.BoardDTO;

public class UpdateBoard extends JFrame implements ActionListener{
	private JTextField inputId;
	private JTextField inputTitle;
	private JTextArea inputContent;
	private JScrollPane jScrPane;
	
	public UpdateBoard() {
		BoardDAO bdao = BoardDAO.getInstance();
		setLayout(null);
		
		Font f = new Font("굴림", Font.BOLD, 15);
		JLabel labelId = new JLabel("작성자");
		labelId.setFont(f);
		labelId.setBounds(50, 50, 60, 30);
		add(labelId);
		
		inputId = new JTextField(bdao.selBoard.getId());
		inputId.setEditable(false);
		inputId.setBounds(120, 50, 300, 30);
		add(inputId);
		
		JLabel labelTitle = new JLabel("제목");
		labelTitle.setFont(f);
		labelTitle.setBounds(50, 90, 60, 30);
		add(labelTitle);
		
		inputTitle = new JTextField(bdao.selBoard.getTitle());
		inputTitle.setBounds(120, 90, 300, 30);
		add(inputTitle);
		
		JLabel labelContent = new JLabel("내용");
		labelContent.setFont(f);
		labelContent.setBounds(50, 130, 60, 30);
		add(labelContent);
		
		inputContent = new JTextArea(bdao.selBoard.getContent());
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		String btnStr = btn.getLabel();
		if(btnStr.equals("취소")){
			new ReadBoardFrame();
			dispose();
		}else if(btnStr.equals("수정완료")){
			BoardDTO dto = new BoardDTO();
			
			String title = inputTitle.getText();
			String content = inputContent.getText();
			
			
			dto.setTitle(title);			
			dto.setContent(content);
			
			BoardDAO bdao = BoardDAO.getInstance();
			bdao.update(dto);
			
			
			new MainFrame();
			dispose();
			
		}
		
	}
	
	
}






























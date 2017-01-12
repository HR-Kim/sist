package com.sist.form;

import java.awt.Color;
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

public class ReadBoardFrame extends JFrame implements ActionListener{
	MemberDAO dao = MemberDAO.getInstance();
	BoardDAO bdao = BoardDAO.getInstance();
	
	public ReadBoardFrame() {
		setLayout(null);
		
		Font f = new Font("굴림", Font.BOLD, 12);
		JLabel labelId = new JLabel("작성자");
		labelId.setFont(f);
		labelId.setBounds(50, 10, 60, 20);
		add(labelId);
		
		JTextField inputId = new JTextField(bdao.selBoard.getId());
		inputId.setEditable(false);
		inputId.setBounds(120, 10, 300, 20);
		add(inputId);
		
		JLabel labelTitle = new JLabel("제목");
		labelTitle.setFont(f);
		labelTitle.setBounds(50, 40, 60, 20);
		add(labelTitle);
		
		JTextField inputTitle = new JTextField(bdao.selBoard.getTitle());
		inputTitle.setEditable(false);
		inputTitle.setBounds(120, 40, 300, 20);
		add(inputTitle);
		
		JLabel labelWdate = new JLabel("작성일");
		labelWdate.setFont(f);
		labelWdate.setBounds(50, 70, 60, 20);
		add(labelWdate);
		
		JTextField inputWdate = new JTextField(bdao.selBoard.getWdate());
		inputWdate.setEditable(false);
		inputWdate.setBounds(120, 70, 300, 20);
		add(inputWdate);
		
		JLabel labelCount = new JLabel("조회수");
		labelCount.setFont(f);
		labelCount.setBounds(50, 100, 60, 20);
		add(labelCount);
		
		JTextField inputCount = new JTextField(bdao.selBoard.getReadcount()+"");
		inputCount.setEditable(false);
		inputCount.setBounds(120, 100, 300, 20);
		add(inputCount);
		
		JLabel labelContent = new JLabel("내용");
		labelContent.setFont(f);
		labelContent.setBounds(50, 130, 60, 20);
		add(labelContent);
		
		JTextArea inputContent = new JTextArea(bdao.selBoard.getContent().replaceAll("<br>", "\r\n"));
		inputContent.setLineWrap(true);
		inputContent.setEditable(false);
		JScrollPane jScrPane = new JScrollPane(inputContent);
		jScrPane.setBounds(50, 160, 370, 160);
		add(jScrPane);
		
		if(dao.loginMem.getId().equals(bdao.selBoard.getId())){
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		String btnStr = btn.getLabel();
		
		if(btnStr.equals("목록")){
			
			new MainFrame();
			dispose();
		}else if(btnStr.equals("수정")){
			new UpdateBoard();
			dispose();
		}else if(btnStr.equals("삭제")){
			int chNum = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?");
			if(chNum == 0){
				BoardDAO bdao = BoardDAO.getInstance();
				boolean b = bdao.deleteBbs();
				if(b) JOptionPane.showMessageDialog(null, "삭제 성공..");
				if(!b) JOptionPane.showMessageDialog(null, "삭제 실패..");
				new MainFrame();
				dispose();
			}
			
		}
		
	}
	
	
	
}

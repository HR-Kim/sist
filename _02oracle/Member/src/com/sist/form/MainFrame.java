package com.sist.form;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import com.sist.dao.BoardDAO;
import com.sist.dao.MemberDAO;
import com.sist.dto.BoardDTO;

public class MainFrame extends JFrame implements ActionListener, ItemListener{
	private JButton logoutBtn;
	private JButton updateBtn;
	private JButton writeBtn;
	private JButton selBtn;
	
	private JTextField selField;
	
	private JTable jTable;
	private JScrollPane jScrPane;
	private Choice selChoice;
	
	String columnNames[] = {
			"번호", "제목", "작성자"	
		};
		
		
	Object rowData[][];
	
	public MainFrame(String ChoiceTxt, String selT) {
		MemberDAO dao = MemberDAO.getInstance();
		BoardDAO bdao = BoardDAO.getInstance();
		
		bdao.list = bdao.loadAll();
		
		setLayout(null);
		setBounds(200, 100, 640, 480);
		
		JLabel theme = new JLabel("게시판");
		theme.setBounds(10, 10, 200, 50);
		add(theme);
		
		JLabel title = new JLabel(dao.loginMem.getId()+"님", JLabel.CENTER);
		title.setBounds(200, 0, 200, 50);
		add(title);
		
		updateBtn = new JButton("my page");
		updateBtn.setBounds(410, 10, 100, 50);
		add(updateBtn);
		
		logoutBtn = new JButton("log-out");
		logoutBtn.setBounds(530, 10, 80, 50);
		add(logoutBtn);
		
		if(bdao.list.size() != 0){
			rowData = new Object[bdao.list.size()][3];
			
			for(int i=0; i<rowData.length; ++ i){
				BoardDTO d = bdao.list.get(i);
				rowData[i][0] = d.getSeq();
				rowData[i][1] = d.getTitle();
				rowData[i][2] = d.getId();
			}
		}else{
			rowData = new Object[1][3];
		}
		
		jTable = new JTable(rowData, columnNames);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		jTable.getColumnModel().getColumn(0).setMaxWidth(50);
		jTable.getColumnModel().getColumn(1).setMaxWidth(500);
		jTable.getColumnModel().getColumn(2).setMaxWidth(200);
		
		jTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		jTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		jScrPane = new JScrollPane(jTable);
		jScrPane.setBounds(10, 100, 600, 280);
		add(jScrPane);
		
		writeBtn = new JButton("write");
		writeBtn.setBounds(10, 400, 100, 30);
		add(writeBtn);
		
		selChoice = new Choice();
		selChoice.add("All");
		selChoice.add("Writer");
		selChoice.add("Title");
		selChoice.add("Content");
		selChoice.setBounds(240, 400, 100, 30);
		add(selChoice);
		selChoice.addItemListener(this);
		
		selField = new JTextField("");
		selField.setBounds(360, 400, 120, 30);
		add(selField);
		
		selBtn = new JButton("검색");
		selBtn.setBounds(510, 400, 100, 30);
		add(selBtn);
		
		logoutBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		writeBtn.addActionListener(this);
		selBtn.addActionListener(this);
		
		jTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int rowNum = jTable.getSelectedRow();
				bdao.selBoard = bdao.list.get(rowNum);
				bdao.selBoard.setReadcount(bdao.selBoard.getReadcount()+1);
				
				bdao.updateReadCount();
				new ReadBoardFrame();
				dispose();
			}
			
		});
		
		setVisible(true);
	}
		
	public MainFrame() {
		MemberDAO dao = MemberDAO.getInstance();
		BoardDAO bdao = BoardDAO.getInstance();
		
		bdao.list = bdao.loadAll();
		
		setLayout(null);
		setBounds(200, 100, 640, 480);
		
		JLabel theme = new JLabel("게시판");
		theme.setBounds(10, 10, 200, 50);
		add(theme);
		
		JLabel title = new JLabel(dao.loginMem.getId()+"님", JLabel.CENTER);
		title.setBounds(200, 0, 200, 50);
		add(title);
		
		updateBtn = new JButton("my page");
		updateBtn.setBounds(410, 10, 100, 50);
		add(updateBtn);
		
		logoutBtn = new JButton("log-out");
		logoutBtn.setBounds(530, 10, 80, 50);
		add(logoutBtn);
		
		if(bdao.list.size() != 0){
			rowData = new Object[bdao.list.size()][3];
			
			for(int i=0; i<rowData.length; ++ i){
				BoardDTO d = bdao.list.get(i);
				rowData[i][0] = d.getSeq();
				rowData[i][1] = d.getTitle();
				rowData[i][2] = d.getId();
			}
		}else{
			rowData = new Object[1][3];
		}
		
		jTable = new JTable(rowData, columnNames);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		jTable.getColumnModel().getColumn(0).setMaxWidth(50);
		jTable.getColumnModel().getColumn(1).setMaxWidth(500);
		jTable.getColumnModel().getColumn(2).setMaxWidth(200);
		
		jTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		jTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		jScrPane = new JScrollPane(jTable);
		jScrPane.setBounds(10, 100, 600, 280);
		add(jScrPane);
		
		writeBtn = new JButton("write");
		writeBtn.setBounds(10, 400, 100, 30);
		add(writeBtn);
		
		selChoice = new Choice();
		selChoice.add("All");
		selChoice.add("Writer");
		selChoice.add("Title");
		selChoice.add("Content");
		selChoice.setBounds(240, 400, 100, 30);
		add(selChoice);
		selChoice.addItemListener(this);
		
		selField = new JTextField("");
		selField.setBounds(360, 400, 120, 30);
		add(selField);
		
		selBtn = new JButton("검색");
		selBtn.setBounds(510, 400, 100, 30);
		add(selBtn);
		
		logoutBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		writeBtn.addActionListener(this);
		selBtn.addActionListener(this);
		
		jTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int rowNum = jTable.getSelectedRow();
				bdao.selBoard = bdao.list.get(rowNum);
				bdao.selBoard.setReadcount(bdao.selBoard.getReadcount()+1);
				
				bdao.updateReadCount();
				new ReadBoardFrame();
				dispose();
			}
			
		});
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == logoutBtn){
			MemberDAO dao = MemberDAO.getInstance();
			dao.loginMem = null;
			new LoginFrame();
			dispose();
		}else if(obj == updateBtn) {
			new MypageFrame();
			dispose();
		}else if(obj == writeBtn){
			new WriteFrame();
			dispose();
		}else if(obj == selBtn) {
			String choiceTxt = selChoice.getSelectedItem();
			String txt = selField.getText().trim();
			if(txt.equals("")){
				JOptionPane.showMessageDialog(null, "검색어를 입력하시오!");
				return;
			}
			new MainFrame(choiceTxt, txt);
			dispose();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}
	
	
}























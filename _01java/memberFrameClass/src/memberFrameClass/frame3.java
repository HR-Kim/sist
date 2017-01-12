package memberFrameClass;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import memberFrameDTO.BbsDTO;

public class frame3 extends JFrame implements ActionListener, WindowListener, ItemListener{
	private JButton logoutBtn;
	private JButton updateBtn;
	private JButton writeBtn;
	private JButton selBtn;
	private JButton allBtn;
	private JTable jTable;
	private JTextField selField;
	private JScrollPane jScrPane;
	private Choice selChoice;
	
	String columnNames[] = {
		"번호", "제목", "작성자"	
	};
	
	
	Object rowData[][];
	
	public frame3(String ChoiceTxt, String selT){
SingletonClass sc = SingletonClass.getInstance();
		
		setLayout(null);
		JLabel theme = new JLabel("게시판");
		theme.setBounds(10, 10, 200, 50);
		add(theme);
		
		JLabel title = new JLabel(sc.loginMem.getName()+"님의 메인", JLabel.CENTER);
		title.setBounds(200, 0, 200, 50);
		add(title);
		
		updateBtn = new JButton("my page");
		updateBtn.setBounds(410, 10, 100, 50);
		add(updateBtn);
		
		
		logoutBtn = new JButton("log-out");
		logoutBtn.setBounds(530, 10, 80, 50);
		add(logoutBtn);
		
		if(sc.bbsDao.selBbs(ChoiceTxt, selT)){
			rowData = new Object[sc.bbsDao.selList.size()][3];
			
			for(int i=0; i<sc.bbsDao.selList.size(); ++i){
				BbsDTO d = sc.bbsDao.selList.get(i);
				rowData[i][0] = d.getSeq();
				rowData[i][1] = d.getTitle();
				rowData[i][2] = d.getId();
				
			}
		}else{
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다. ");
			rowData = new Object[1][3];
			new frame3();
			dispose();
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
		
		allBtn = new JButton("전체보기");
		allBtn.setBounds(130, 400, 100, 30);
		add(allBtn);
		
		selChoice = new Choice();
		selChoice.add("전체");
		selChoice.add("작성자");
		selChoice.add("제목");
		selChoice.add("내용");
		selChoice.setBounds(240, 400, 100, 30);
		add(selChoice);
		selChoice.addItemListener(this);
		
		selField = new JTextField("");
		selField.setBounds(360, 400, 120, 30);
		add(selField);
		
		selBtn = new JButton("검색");
		selBtn.setBounds(510, 400, 100, 30);
		add(selBtn);
		
		
		getContentPane().setBackground(new Color(0, 255, 0));		
		setBounds(200, 100, 640, 480);
		setVisible(true);
		
		logoutBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		writeBtn.addActionListener(this);
		selBtn.addActionListener(this);
		allBtn.addActionListener(this);
		
		jTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				SingletonClass sc = SingletonClass.getInstance();
				int rowNum = jTable.getSelectedRow();
				//System.out.println("선택한 Row = " + rowNum);
				sc.selBbs = sc.bbsDao.list.get(rowNum);
				sc.selBbs.setReadcount(sc.selBbs.getReadcount()+1);
				new frame6();
				dispose();
			}
			
		});
		
		addWindowListener(this);
	}
	//////////////////////////////////////////////////////////////////////////
	public frame3() {
		SingletonClass sc = SingletonClass.getInstance();
		
		setLayout(null);
		JLabel theme = new JLabel("게시판");
		theme.setBounds(10, 10, 200, 50);
		add(theme);
		
		JLabel title = new JLabel(sc.loginMem.getName()+"님의 메인", JLabel.CENTER);
		title.setBounds(200, 0, 200, 50);
		add(title);
		
		updateBtn = new JButton("my page");
		updateBtn.setBounds(410, 10, 100, 50);
		add(updateBtn);
		
		
		logoutBtn = new JButton("log-out");
		logoutBtn.setBounds(530, 10, 80, 50);
		add(logoutBtn);
		
		if(sc.bbsDao.list.size()!= 0){
			rowData = new Object[sc.bbsDao.list.size()][3];
			
			for(int i=0; i<sc.bbsDao.list.size(); ++i){
				BbsDTO d = sc.bbsDao.list.get(i);
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
		selChoice.add("전체");
		selChoice.add("작성자");
		selChoice.add("제목");
		selChoice.add("내용");
		selChoice.setBounds(240, 400, 100, 30);
		add(selChoice);
		selChoice.addItemListener(this);
		
		selField = new JTextField("");
		selField.setBounds(360, 400, 120, 30);
		add(selField);
		
		selBtn = new JButton("검색");
		selBtn.setBounds(510, 400, 100, 30);
		add(selBtn);
		
		
		getContentPane().setBackground(new Color(0, 255, 0));		
		setBounds(200, 100, 640, 480);
		setVisible(true);
		
		logoutBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		writeBtn.addActionListener(this);
		selBtn.addActionListener(this);
		
		jTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				SingletonClass sc = SingletonClass.getInstance();
				int rowNum = jTable.getSelectedRow();
				//System.out.println("선택한 Row = " + rowNum);
				sc.selBbs = sc.bbsDao.list.get(rowNum);
				sc.selBbs.setReadcount(sc.selBbs.getReadcount()+1);
				
				new frame6();
				dispose();
			}
			
		});
		
		addWindowListener(this);
	}
	
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		
		if(ob == logoutBtn){
			SingletonClass sc = SingletonClass.getInstance();
			sc.loginMem = null;
			new frame1();
			dispose();
		}else if(ob == updateBtn) {
			new frame4();
			dispose();
		}else if(ob == writeBtn) {
			new frame5();
			dispose();
		}else if(ob == selBtn) {
			String choiceTxt = selChoice.getSelectedItem();
			String txt = selField.getText().trim();
			if(txt.equals("")){
				JOptionPane.showMessageDialog(null, "검색어를 입력하시오!");
				return;
			}
			new frame3(choiceTxt, txt);
			dispose();
		}else if(ob == allBtn) {
			new frame3();
			dispose();
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
		SingletonClass sc = SingletonClass.getInstance();
		
		sc.memDao.fileLoad();
		
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

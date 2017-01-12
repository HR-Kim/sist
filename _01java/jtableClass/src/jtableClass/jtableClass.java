package jtableClass;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class jtableClass extends JFrame{
	
	JTable jtable;
	JScrollPane jScrollPane;
	
	String columnNames[] = {
			"상품번호", "상품이름", "상품가격", "상품설명"
	};
	
//	Object rowData[][] = {
//			{1, "맛동산", "100" ,"오리온"},
//			{2, "아폴로", "200" ,"불량식품"},
//			{3, "칸쵸", "300" ,"해태"}
//	};
	
	Object rowData[][];
	
	ArrayList<DTO> list = new ArrayList<DTO>();
	
	public jtableClass() {
		super("JTable");
		
		DTO dto = new DTO(1, 100, "맛동산", "오린온");
		list.add(dto);
		
		// select
		
		DTO odto = list.get(0);	
		rowData = new Object[3][4];
		
		rowData[0][0] = odto.getSeqNum();
		rowData[0][1] = odto.getMoney();
		rowData[0][2] = odto.getName();
		rowData[0][3] = odto.getCompany();
		
		jtable = new JTable(rowData, columnNames);
		jScrollPane = new JScrollPane(jtable);
		this.add(jScrollPane);
		this.setSize(400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
}

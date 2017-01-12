package sist.dao;

import java.util.ArrayList;
import java.util.List;

import sist.dto.OrderDTO;

public class OrderDAO {
	public List<OrderDTO> list = new ArrayList<OrderDTO>();
	public List<OrderDTO> memList = new ArrayList<OrderDTO>();
	
	public OrderDAO() {
	
	}
	
	public int totalCount(OrderDTO dto){
		int price = 0;
		int total = 0;
		if(dto.getChoice().equals("Hazelnut Caramel Mocha")){
			if(dto.getSize().equals("Short")){
				price = 4800;
			}else if(dto.getSize().equals("Tall")){
				price = 5300;
			}else if(dto.getSize().equals("Grande")){
				price = 5800;
			}
 		}else if(dto.getChoice().equals("Caramel Makiatto") ||
 				dto.getChoice().equals("White Chocolate Mocha") ||
 				dto.getChoice().equals("Caramel Mocha")){
 			if(dto.getSize().equals("Short")){
				price = 4300;
			}else if(dto.getSize().equals("Tall")){
				price = 4800;
			}else if(dto.getSize().equals("Grande")){
				price = 5300;
			}
 		}else if(dto.getChoice().equals("Caffe Mocha") ||
 				dto.getChoice().equals("Caramel Latte")){
 			if(dto.getSize().equals("Short")){
				price = 3800;
			}else if(dto.getSize().equals("Tall")){
				price = 4300;
			}else if(dto.getSize().equals("Grande")){
				price = 4800;
			}
 		}else if(dto.getChoice().equals("Caffe Latte") ||
 				dto.getChoice().equals("Cappuccino")){
 			if(dto.getSize().equals("Short")){
				price = 3300;
			}else if(dto.getSize().equals("Tall")){
				price = 3800;
			}else if(dto.getSize().equals("Grande")){
				price = 4300;
			}
 		}else if(dto.getChoice().equals("Americano")){
 			if(dto.getSize().equals("Short")){
				price = 2800;
			}else if(dto.getSize().equals("Tall")){
				price = 3300;
			}else if(dto.getSize().equals("Grande")){
				price = 3800;
			}
 		}else{
 			if(dto.getSize().equals("Short")){
				price = 2500;
			}else if(dto.getSize().equals("Tall")){
				price = 3000;
			}else if(dto.getSize().equals("Grande")){
				price = 3500;
			}
 		}
		total = price * dto.getCount();
		return total;
	}
	
	public void setMemList(){
		memList.removeAll(memList);
		SingletonClass sc = SingletonClass.getInstance();
		
		for(int i=0; i<list.size(); ++i){
			OrderDTO d = list.get(i);
			if(sc.loginMem.getId().equals(d.getId())){
				memList.add(d);
			}
		}
		
	}
	
	public boolean addOrder(OrderDTO dto){
		dto.setConfirm(false);
		dto.setTotal(this.totalCount(dto));
		SingletonClass sc = SingletonClass.getInstance();
		
		sc.seqNum++;
		dto.setSeqNum(sc.seqNum);
		boolean b = list.add(dto);
		
		
		allPrint();
		
		return b;
	}
	
	public void allPrint(){
		for(int i=0; i<list.size(); ++i){
			OrderDTO d = list.get(i);
			System.out.println(d.toString());
		}
	}
}




package sist.dao;

import java.util.ArrayList;
import java.util.List;

import sist.dto.MemDTO;
import sist.file.FileClass;

public class MemDAO {
	public List<MemDTO> list = new ArrayList<MemDTO>();
	FileClass fc = null;
	
	
	
	public MemDAO() {
		//fileRead();
		fc = new FileClass();
		
		String[] copy;
		String[] temp;
		MemDTO dto = new MemDTO();
		boolean b = fc.checkBeforeReadFile("coffeeDB");
		if(!b) fc.fileCreate("coffeeDB");
		
		copy = fc.fileRead("coffeeDB");
		
		for(int i=0; i<copy.length; ++i){
			temp = copy[i].split("-");
			
			dto.setId(temp[0]);
			dto.setPw(temp[1]);
			dto.setName(temp[2]);
			dto.setAge(Integer.parseInt(temp[3]));
			dto.setAuth(Integer.parseInt(temp[4]));
			dto.setConnect(Boolean.parseBoolean(temp[5]));
			
			list.add(dto);
		}
		if(copy.length == 0){
			MemDTO admin = new MemDTO("admin", "123", "배한주", 25, 1);
			admin.setConnect(false);
			list.add(admin);
		}
	}
	
	
	
	public boolean checkId(String id){
		for(int i=0; i<list.size(); ++i){
			MemDTO d = list.get(i);
			if(d.getId().equals(id)){
				System.out.println("같은 아이디가 존재합니다.");
				return false;
			}
		}
		return true;
	}
	
	public boolean addMember(MemDTO dto){
		dto.setAuth(0);
		dto.setJoin(false);
		
		boolean b = list.add(dto);
		
		allPrint();
		
		return b;
	}
	
	public MemDTO login(MemDTO dto) {
		//frame1
		boolean isExist = false;
		if(list.size() == 0){
			System.out.println("아이디가 존재하지 않습니다.");
			return null;
		}
		for(int i=0; i< list.size(); ++i){
			MemDTO d = list.get(i);
			if(d.getId().equals(dto.getId())){
				if(d.getPw().equals(dto.getPw())){
					isExist = true;
					d.toString();
					return d;
				}else{
					System.out.println("비밀번호가 틀렸습니다.");
				}
			}
		}
		if(!isExist) System.out.println("아이디가 존재하지 않습니다.");
		return null;
	}
	
	public void allPrint() {
		for (int i = 0; i < list.size(); i++) {
			MemDTO d = list.get(i);
			System.out.println(d.toString());
		}
	}
	
	public void fileLoad(){
		String[] text = new String[list.size()];
		for(int i =0; i<list.size(); ++i){
			text[i] = list.get(i).toString();
		}
		fc.fileWrite("coffeeDB", text);
		
	}
}







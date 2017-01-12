package memberFrameDAO;

import java.util.ArrayList;
import java.util.List;

import FileClass.FileClass;
import memberFrameDTO.memberDTO;

public class memberDAO {
	
	public List<memberDTO> list = new ArrayList<memberDTO>();
	int seqNum = 0;
	FileClass fc = null;
	
	public memberDAO() {
		fc = new FileClass();
		String[] copy;
		String[] temp;
		memberDTO dto;
		boolean b = fc.checkBeforeReadFile("memberDB");
		if(!b) fc.fileCreate("memberDB");
		
		copy = fc.fileRead("memberDB");
		
		list.removeAll(list);
		for(int i=0; i<copy.length; ++i){
			temp = copy[i].split("-");
			dto = new memberDTO(temp[1], temp[2], temp[3], temp[4]);
			dto.setSeqNum(Integer.parseInt(temp[0]));
			dto.setAuth(Integer.parseInt(temp[5]));
			list.add(dto);
		}
		if(copy.length != 0){
			seqNum = list.get(list.size()-1).getSeqNum();
		}
	}
	public boolean checkId(String id){
		
		for (int i = 0; i < list.size(); i++) {
			memberDTO d = list.get(i);
			if(d.getId().equals(id)){
				System.out.println("같은 아이디가 존재합니다.");
				return false;
			}
		}
		return true;
	}
	public boolean updateMember(memberDTO dto){
		boolean b = false;
		for(int i = 0; i< list.size(); ++i){
			memberDTO d = list.get(i);
			if(d.getId().equals(dto.getId())){
				list.set(i, dto);
				b = true;
				
			}
		}
		return b;
	}
	
	
	public boolean addMember(memberDTO dto) {
		seqNum++;
		
		dto.setSeqNum(seqNum);
		dto.setAuth(1);
		
		boolean b = list.add(dto);
		
		allPrint();
		
		return b;
	}
	
	public memberDTO login(memberDTO dto) {
		//frame1
		if(list.size() == 0){
			System.out.println("아이디가 존재하지 않습니다.");
			return null;
		}
		for(int i=0; i< list.size(); ++i){
			memberDTO d = list.get(i);
			if(d.getId().equals(dto.getId())){
				if(d.getPw().equals(dto.getPw())){
					d.toString();
					return d;
				}else{
					System.out.println("비밀번호가 틀렸습니다.");
				}
			}else{
				System.out.println("아이디가 존재하지 않습니다.");
			}
		}
		return null;
	}
	
	public void allPrint() {
		for (int i = 0; i < list.size(); i++) {
			memberDTO d = list.get(i);
			System.out.println(d.toString());
		}
	}
	
	public void fileLoad(){
		String[] text = new String[list.size()];
		for(int i =0; i<list.size(); ++i){
			text[i] = list.get(i).toString();
		}
		fc.fileWrite("memberDB", text);
		
	}
}

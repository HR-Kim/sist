package memberClass;

import java.util.ArrayList;
import java.util.List;

public class memberDAO {
	
	List<memberDTO> list = new ArrayList<memberDTO>();
	
	public boolean addMember(memberDTO dto) {
		
		for (int i = 0; i < list.size(); i++) {
			memberDTO d = list.get(i);
			if(d.getId().equals(dto.getId())){
				System.out.println("같은 아이디가 존재합니다.");
				return false;
			}
		}
		
		boolean b = list.add(dto);
		
		allPrint();
		
		return b;
	}
	
	public void allPrint() {
		for (int i = 0; i < list.size(); i++) {
			memberDTO d = list.get(i);
			System.out.println(d.toString());
		}
	}
}

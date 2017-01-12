import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<DramaDTO> list = new LinkedList<DramaDTO>();
		
		DramaDTO dto = new DramaDTO();
		dto.setTitle("그겨울");
		dto.setBroadcast("브로드캐스트");
		dto.setDiretor("신상철");
		dto.setActor("장동건");
		dto.setActress("전지현");
		
		list.add(dto);
		
		DramaDTO dto1 = new DramaDTO();
		dto1.setTitle("그여름");
		dto1.setBroadcast("SIST");
		dto1.setDiretor("조윤행");
		dto1.setActor("배한주");
		dto1.setActress("나연");
		
		list.add(dto1);
		
		for(int i=0; i<list.size(); ++i){
			DramaDTO d = list.get(i);
			System.out.println(d.toString());
		}
		
		for(DramaDTO dramaDTO : list){
			System.out.println(dramaDTO.toString());
		}
		
		ArrayList<DramaDTO> arrlist = new ArrayList<DramaDTO>();
		
		LinkedList<String> linklist = new LinkedList<String>();
		
		// [0] [1] [2] [3] [4]
		//arrlist.addF;검색 용이
		// [0] [1] [2] [4] [3]
		///linklist.addFirst(e);추가삭제 용이
		//ArrayList보다 LinkedList가 더 메소드가 많다.
		
		linklist.add("AAA");
		linklist.add("BBB");
		linklist.add("CCC");
		linklist.addFirst("eee");
		linklist.addLast("EEE"); //큰의미는 읎다.
		
		for(String str : linklist){
			System.out.println(str);
		}
		
		String s = linklist.poll(); //뽑으면서 지울수있다. 잘쓰지않는다.
		System.out.println(s);
		
		for(String str : linklist){
			System.out.println(str);
		}
		
		linklist.remove(3);
		
		for(String str : linklist){
			System.out.println(str);
		}
		
	}

}










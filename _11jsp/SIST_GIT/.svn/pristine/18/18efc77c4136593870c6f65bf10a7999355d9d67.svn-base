import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.khy.mini.MiniBean;
import com.khy.mini.MiniDao;

public class MiniDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("===============");
	 	MiniDao miniDao = new MiniDao();
		//빈즈에서 가지고 올 게시물 데이터를 보관하고 있는 ArrayList 를 처리하기 위한 변수
	 	String search_div  ="NAME";
	 	String search_word ="홍길동101";
	 	
		ArrayList<HashMap> datas = miniDao.selectPageList(1, 5,search_div,search_word);
		// ArrayList 를 좀더 쉽게처리하기 위한 iterator 생성.
		Iterator iter = datas.iterator();
		
		while(iter.hasNext()) {
			// ArrayList 에서 HashMap 을 가져옴. Object 로 저장되어 있기 때문에 형변환 필요
			HashMap data = (HashMap)iter.next();
			System.out.println(data.get("mi_id")+"\t"+data.get("mi_name"));
				
		}	
		System.out.println("===============");
	}

}

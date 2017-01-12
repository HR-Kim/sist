package hashmapClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * HashMap<KEY, VALUE>	== map, multimap(중복키 값을 허용하는데 자바에는 없다.)
		 * Arr[0~n-1] = ? / index : key , value : 값
		 * : 사전		사과 : apple
		 * tree 구조, 검색이 효율적이다.(선형구조보다 훨씬 효율적)
		 * 중복키 값을 허용하지 않는다.
		 * 
		 * TreeMap = HashMap + sort
		 * 
		 */
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		// 추가 == put
		map.put(111, "illinaire");
		map.put(222, "multi-illinaire");
		
		// 취득 == get
		String value = map.get(111);
		System.out.println("value = " + value);
		
		// 검색 == containsKey
		boolean b = map.containsKey(22);
		System.out.println("b = " + b);
		
		if(map.containsKey(222)){
			value = map.get(222);
			System.out.println("value = " + value);
		}
		
		// 삭제 
		String s = map.remove(111);
		System.out.println("s = " + s);
		
		// 모두 삭제
		map.clear();
		
		HashMap<String, String> map1 = new HashMap<String, String>();
		
		map1.put("사과", "apple");
		map1.put("포도", "grape");
		map1.put("파인애플", "pineapple");
		map1.put("키위", "kiwi");
		
		String str = map1.get("사과");
		System.out.println("str = " + str);
		
		//map1.put("포도", "그레이프");
		map1.replace("포도", "포동");
		str = map1.get("포도");
		System.out.println("str = " + str);
		
		// 모든 데이터 출력
		Iterator<String> keys = map1.keySet().iterator();
		while(keys.hasNext()){
			String key = keys.next();
			System.out.println("key : " + key + " value : " + map1.get(key));
			
		}
		
		for(String key : map1.keySet()){
			System.out.println("key : " + key + " value : " + map1.get(key));
		}
		
		//정렬
		TreeMap<String, String> treeMap 
			= new TreeMap<String, String>(map1);
										// 오름차순 정렬
		//Iterator<String> itKey = treeMap.keySet().iterator();
										// 내림차순 정렬		
		Iterator<String> itKey = treeMap.descendingKeySet().iterator();
		
		while(itKey.hasNext()){
			String key = itKey.next();
			System.out.println("key : " + key + " value : " + treeMap.get(key));	
		}
		
		HashMap<String, Integer> map2;
		List list = new ArrayList();
		//ArrayList<HashMap> list = new ArrayList<HashMap>();
		
		map2 = new HashMap();
		
		map2.put("영어", 50);
		map2.put("국어", 100);
		map2.put("수학", 70);
		list.add(map2);
		
		map2 = new HashMap();
		
		map2.put("영어", 60);
		map2.put("국어", 80);
		map2.put("수학", 80);
		
		list.add(map2);
		
		System.out.println(list.toString());
		
		HashMap<String, DTO> mapData = new HashMap<String, DTO>();
		
		mapData.size();
		
		mapData.put("123-456", new DTO(1, "홍길동"));
		mapData.put("234-567", new DTO(2, "일지매"));
		mapData.put("345-678", new DTO(3, "임꺽정"));
		
		if(mapData.containsKey("234-567")){
			DTO dto = mapData.get("234-567");
			dto.output();
		}
		
		// 모두 출력
		Iterator<String> itDTOKey = mapData.keySet().iterator();
		
		while(itDTOKey.hasNext()){
			String str1 = itDTOKey.next();
			DTO dto = mapData.get(str1);
			dto.output();
		}
		System.out.println("-----------------------------------");
		
		// 정렬
		TreeMap<String, DTO> treeMap1 = new TreeMap<String, DTO>(mapData);
		//오름차순 정렬
		itDTOKey = treeMap1.keySet().iterator();
		for(String str2 : treeMap1.keySet()){
			DTO dto = treeMap1.get(str2);
			dto.output();
		}
		
	}

}
























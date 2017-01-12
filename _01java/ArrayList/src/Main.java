import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ArrayList : 배열처럼 사용할 수 있다.
		 * Vector : 선형 구조의 Collection 중에서 검색이 빠르다.
		 * 
		 * LinkedList : 추가/삭제의 속도가 빠르다.
		 * 
		 * Vector
		 * 
		 * 
		 */
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		//추가
		arrList.add(111);
		arrList.add(222);
		arrList.add(new Integer(333));
		
		Integer list1 = arrList.get(0); 	//배열 index
		//산출
		for (int i = 0; i < arrList.size(); i++) {
			list1 = arrList.get(i);
			System.out.println("list : " + list1);
		}
		
		/*
		 * add == 끝 부분에 추가
		 *  a - b - c - d
		 *  get(index number) 0 ~ size()-1
		 *  
		 *  size() : list의 크기
		 *  
		 *  
		 * 
		 * 
		 * 
		 */
		
		//수정
		arrList.set(1, 555);
		
		for (int i = 0; i < arrList.size(); i++) {
			list1 = arrList.get(i);
			System.out.println("list : " + list1);
		}
		
		//검색
		int findNum;
		
		findNum = arrList.indexOf(111);
		
		System.out.println("findNum : " + findNum);
		
		//삭제
		arrList.remove(1);
		for (int i = 0; i < arrList.size(); i++) {
			list1 = arrList.get(i);
			System.out.println("list : " + list1);
		}
		
		// 원하는 곳에 추가
		arrList.add(1, 555);
		for (int i = 0; i < arrList.size(); i++) {
			list1 = arrList.get(i);
			System.out.println("list : " + list1);
		}
		
		List<String> list = new ArrayList<String>();
		String str = "Lions";
		list.add(str);
		str = "Twins";
		list.add(str);
		str = "Chikens";
		list.add(str);
		
		for(int i=0; i<list.size(); ++i){
			System.out.println("list[" + i + "] = " + list.get(i));
		}
		
		// 추가
		str = "Bears";
		list.add(str);
		System.out.println("---------------추가---------------");
		// 출력
		for(int i=0; i<list.size(); ++i){
			System.out.println("list[" + i + "] = " + list.get(i));
		}
		// 수정
		list.set(2, "Eagles");
		System.out.println("---------------수정---------------");
		// 출력
		for(int i=0; i<list.size(); ++i){
			System.out.println("list[" + i + "] = " + list.get(i));
		}
		//원하는 곳에 추가
		list.add(2, "Giants");
		System.out.println("---------------수정---------------");
		// 출력
		for(int i=0; i<list.size(); ++i){
			System.out.println("list[" + i + "] = " + list.get(i));
		}
		
		//삭제
		list.remove(3);
		System.out.println("---------------삭제---------------");
		// 출력
		for(int i=0; i<list.size(); ++i){
			System.out.println("list[" + i + "] = " + list.get(i));
		}
		
		boolean b = list.contains("Lions");
		System.out.println("b = " + b);
		
		// Iterator == 반복자
		
		Iterator<String> it;	//it++;
		int i;
		

		it = list.iterator();
		System.out.println("it = " + it.toString());
		
		while(it.hasNext()){
			System.out.println("it = " + it.next());
		}
		
		it = list.iterator();
		while(it.hasNext()){
			String msg = it.next();
			if(msg.equals("Giants")){
				it.remove();
			}
		}
		for(String s : list){
			System.out.println("s = " + s);
		}
		
		
		//for each
		int array[] = {1, 2, 3};
		
		for(int h: array){
			System.out.println("h = " +h);
		}
	}

}















package listAllClass;

import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		ArrayList<Integer> kyo = new ArrayList<Integer>();	//교집합
		ArrayList<Integer> hap = new ArrayList<Integer>();	//합집합
		ArrayList<Integer> cha = new ArrayList<Integer>();	//차집합
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		kyo.addAll(list1);
		System.out.println("kyo = " + kyo);
		
		kyo.retainAll(list2);
		System.out.println("kyo = " + kyo); // join
		
		cha.addAll(list1);
		cha.removeAll(list2);
		
		System.out.println("cha = " + cha); 
		
		hap.addAll(list1);
		hap.removeAll(list2);
		hap.addAll(list2);
		
		System.out.println("hap = " + hap);
		
	}

}











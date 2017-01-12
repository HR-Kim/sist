package studentClass.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import studentClass.dto.StudentDTO;
import studentClass.dto.StudentGradeDTO;

public class ClassDAO {
	
	Calendar cal;
	//LinkedList<StudentDTO> list;
	HashMap<Integer, StudentDTO> map;
	
	public ClassDAO() {
		
		cal = Calendar.getInstance();
		//list = new LinkedList<StudentDTO>();
		map = new HashMap<Integer, StudentDTO>();
	}
	
	
	// 학생 데이터 추가
	public void insert(){
		Scanner sc = new Scanner(System.in);
		int no;
		String name;
		String tempDate;
		String birth[];
		Date date;
		int date_cnt;
		double height;
		
		no = map.size()+1;
		
		System.out.print("추가할 선수의 이름을 입력하시오 : ");
		name = sc.next();
		name = name.replace(" ", "");
		while(true){
			date_cnt=0;
			System.out.print("추가할 선수의 생일을 입력하시오 (년-월-일 구분!!: ");
			tempDate = sc.next();
			tempDate = tempDate.replace(" ", "");
			for(int i=0; i<tempDate.length(); ++i){
				if(tempDate.charAt(i) == '-') date_cnt++;
			}
			if(!(date_cnt == 2)){
				System.out.println("-를 제대로 기입하시오!!");
				continue;
			}
			
			birth = tempDate.split("-");
			cal.set(Integer.parseInt(birth[0]), Integer.parseInt(birth[1])-1, Integer.parseInt(birth[2]));
			
			date = new Date(cal.getTimeInMillis());
			break;
		}
		
		System.out.print("추가할 선수의 키를 입력하시오 : ");
		height = sc.nextDouble();
		
		StudentDTO dto = new StudentGradeDTO(no, name, date, height,0 ,0 ,0);
		map.put(no, dto);
		if(map.containsKey(no)){
			System.out.println("정상적으로 추가되었습니다.");
		}else{
			System.out.println("오류로 인해 추가되지 못했습니다.");			
		}
	}
	// 학생 데이터 검색
	public int select(){
		Scanner sc = new Scanner(System.in);
		String name;
		int seqNum = -1;
		boolean exist = false;
		
		System.out.print("검색하고 싶은 학생의 이름을 입력하시오 : ");
		name = sc.next();
		name = name.replace(" ", "");
		/*
		for(int i=0; i<list.size(); ++i){
			StudentDTO stu = list.get(i);
			if(stu.getName().equals(name)){
				seqNum = i;
				System.out.println(stu.toString());
			}
		}*/

		Iterator<Integer> itKey = map.keySet().iterator();
		while(itKey.hasNext()){
			
			int no = itKey.next();
			StudentDTO stu = map.get(no);
			if(stu.getName().equals(name)){
				seqNum = no;
				System.out.println(stu.toString());
			}
		}
		
		if(seqNum == -1){
			System.out.println("검색한 학생은 존재하지 않습니다.");
			return seqNum;
		}else{
			return seqNum;
		}
	}
	// 학생 데이터 수정
	
	public void update(){
		Scanner sc = new Scanner(System.in);
		String name;
		String tempDate;
		String birth[];
		Date date;
		int date_cnt;
		int sel;
		double height;
		int no;
		int seqNum = -1;
		boolean conti = true;
		
		
		System.out.print("수정을 위해 ");
		
		seqNum = this.select();
		if(seqNum !=-1){
			StudentDTO stu = map.get(seqNum);
			System.out.print("1 : 전체수정!, 2 : 부분수정!");
			sel = sc.nextInt();
			
			switch(sel){
				case 1 :{
					System.out.print("바꿀 이름을 입력하시오 : ");
					name = sc.next();
					name = name.replace(" ", "");
					
					while(true){
						date_cnt=0;
						System.out.print("바꿀 선수의 생일을 입력하시오 (년-월-일 구분!!: ");
						tempDate = sc.next();
						tempDate = tempDate.replace(" ", "");
						for(int j=0; j<tempDate.length(); ++j){
							if(tempDate.charAt(j) == '-') date_cnt++;
						}
						if(!(date_cnt == 2)){
							System.out.println("-를 제대로 기입하시오!!");
							continue;
						}
						
						birth = tempDate.split("-");
						cal.set(Integer.parseInt(birth[0]), Integer.parseInt(birth[1])-1, Integer.parseInt(birth[2]));
						
						date = new Date(cal.getTimeInMillis());
						break;
					}
					System.out.print("바꿀 선수의 키를 입력하시오 : ");
					height = sc.nextDouble();
					
					StudentDTO dto = new StudentDTO(seqNum, name, date, height);
					map.put(seqNum, dto);
					
					break;
				}
				case 2:{
					int w;
					while(conti){
						System.out.print("1:이름, 2:생일, 3:키 , 4: 수정그만");
						w = sc.nextInt();
						
						switch(w){
							case 1:{						
								System.out.print("바꿀 이름을 입력하시오 : ");
								name = sc.next();
								name = name.replace(" ", "");
								stu.setName(name);
								
								break;
							}
							case 2:{						
								while(true){
									date_cnt=0;
									System.out.print("바꿀 선수의 생일을 입력하시오 (년-월-일 구분!!: ");
									tempDate = sc.next();
									tempDate = tempDate.replace(" ", "");
									for(int j=0; j<tempDate.length(); ++j){
										if(tempDate.charAt(j) == '-') date_cnt++;
									}
									if(!(date_cnt == 2)){
										System.out.println("-를 제대로 기입하시오!!");
										continue;
									}
									
									birth = tempDate.split("-");
									cal.set(Integer.parseInt(birth[0]), Integer.parseInt(birth[1])-1, Integer.parseInt(birth[2]));
									
									date = new Date(cal.getTimeInMillis());
									stu.setDate(date);
									break;
								}
								break;
							}
							case 3:{
								System.out.print("바꿀 선수의 키를 입력하시오 : ");
								height = sc.nextDouble();
								stu.setHeight(height);
								break;
							}
							case 4:{
								System.out.println("수정끄읕!! ");
								conti = false;
								break;
							}
							default :{
								System.out.print("범위내에서 고르시오!!");
							}
						}
					}
					
					map.put(seqNum, stu);
					
					break;
				}default :{
					System.out.print("1과 2번 중에서 고르시오!!");
				}
			}
		}

	}
	// 학생 데이터 삭제
	public void delete(){
		int seqNum = -1;
		
		System.out.print("삭제를 위해 ");
		seqNum = this.select();
		if(seqNum != -1){
			StudentDTO stu = map.remove(seqNum);
			
			System.out.println(stu.getName() + "의 학생정보를 삭제하였습니다.");
			
			for(int i=seqNum+1; i<=map.size(); ++i){
				StudentDTO stu1 = map.get(i);
				stu1.setNo(i-1);
				map.put(i-1, stu);
			}
			map.remove(map.size());
		}
	}
	// 학생 데이터 출력	n
	public void print(){
		Iterator<Integer> itKey = map.keySet().iterator();
		
		while(itKey.hasNext()){
			int no = itKey.next();
			StudentDTO stu = map.get(no);
			System.out.println(stu.toString());
		}

	}
	
	public void gradeManage(){
		Scanner sc = new Scanner(System.in);
		int seqNum = this.select();

		
		if(seqNum != -1){
			StudentDTO sgd = new StudentGradeDTO();
			StudentGradeDTO temp;
			sgd = map.get(seqNum);
			temp = (StudentGradeDTO)sgd;
			
			System.out.print("국어 점수를 입력하시오 : ");
			temp.setKor(sc.nextInt());
			
			System.out.print("수학 점수를 입력하시오 : ");
			temp.setMath(sc.nextInt());
			
			System.out.print("영어 점수를 입력하시오 : ");
			temp.setEng(sc.nextInt());
			
			map.put(seqNum, temp);
			System.out.println("기입완료!!");
		}
	}
	
	public void sum(){ //개인
		int seqNum = this.select();
		int sum = 0;
		
		if(seqNum != -1){
			StudentDTO sgd = new StudentGradeDTO();
			StudentGradeDTO temp;
			sgd = map.get(seqNum);
			temp = (StudentGradeDTO)sgd;
			
			sum = temp.getKor() + temp.getMath() + temp.getEng();
			System.out.println(temp.getName() + "학생의 총점은 " + sum + "입니다");
			
		}
		
	}
	
	public void avg(){	// 개인
		int seqNum = this.select();
		int sum;
		double avg;
		sum = 0;
		avg = 0.0;
		
		if(seqNum != -1){
			StudentDTO sgd = new StudentGradeDTO();
			StudentGradeDTO temp;
			sgd = map.get(seqNum);
			temp = (StudentGradeDTO)sgd;
			
			sum = temp.getKor() + temp.getMath() + temp.getEng();
			avg = sum / 3.0;
			System.out.println(temp.getName() + "학생의 평균은 " + avg + "입니다");
			
		}
	}
	
	public void korAvg() {
		int sum;
		double avg;
		sum = 0;
		avg = 0.0;
		
		Iterator<Integer> itKey = map.keySet().iterator();
		while(itKey.hasNext()){
			int no = itKey.next();
			StudentGradeDTO temp = (StudentGradeDTO)map.get(no);
			sum = sum+ temp.getKor();
		}
		
		avg = (double)sum / map.size();
		
		System.out.println("총 학생의 국어 평균은 " + avg + "입니다");
	}
	
	public void engAvg() {
		int sum;
		double avg;
		sum = 0;
		avg = 0.0;
		
		Iterator<Integer> itKey = map.keySet().iterator();
		while(itKey.hasNext()){
			int no = itKey.next();
			StudentGradeDTO temp = (StudentGradeDTO)map.get(no);
			sum = sum+ temp.getEng();
		}
		
		avg = (double)sum / map.size();
		
		System.out.println("총 학생의 영어 평균은 " + avg + "입니다");
	}
	
	public void mathTop() {
		int top;
		int top_seq = 0;
		StudentGradeDTO temp = (StudentGradeDTO)map.get(0);
		top = temp.getMath();
		
		Iterator<Integer> itKey = map.keySet().iterator();
		while(itKey.hasNext()){
			int no = itKey.next();
			temp = (StudentGradeDTO)map.get(no);
			if(top < temp.getMath()){
				top = temp.getMath();
				top_seq = no;
			}
		}
		
		temp = (StudentGradeDTO)map.get(top_seq);
		System.out.println("수학 점수가 가장 높은 학생은" + temp.getMath() + "점으로 " + temp.getName() + " 입니다.");
	}
	
	public void bestOfTheBase(){
		int top;
		int sum;
		int top_seq = 0;
		StudentGradeDTO temp = (StudentGradeDTO)map.get(0);
		top = temp.getEng() + temp.getKor() + temp.getMath();
		
		Iterator<Integer> itKey = map.keySet().iterator();
		while(itKey.hasNext()){
			int no = itKey.next();
			temp = (StudentGradeDTO)map.get(no);
			sum = (temp.getEng() + temp.getKor() + temp.getMath());
			if(top < sum){
				top = sum;
				top_seq = no;
			}
		}
		
		temp = (StudentGradeDTO)map.get(top_seq);
		System.out.println("총점수가 가장 높은 학생은" + top + "점으로 " + temp.getName() + " 입니다.");
		
	}
	
}











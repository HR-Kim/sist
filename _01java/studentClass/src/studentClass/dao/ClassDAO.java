package studentClass.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import studentClass.dto.StudentDTO;
import studentClass.dto.StudentGradeDTO;

public class ClassDAO {
	
	Calendar cal;
	LinkedList<StudentDTO> list;
	
	public ClassDAO() {
		
		cal = Calendar.getInstance();
		list = new LinkedList<StudentDTO>();
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
		
		no = list.size()+1;
		
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
		if(list.add(dto)){
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
		
		for(int i=0; i<list.size(); ++i){
			StudentDTO stu = list.get(i);
			if(stu.getName().equals(name)){
				seqNum = i;
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
		int no_update = -1;
		boolean conti = true;
		
		
		System.out.print("수정하고 싶은 학생의 이름을 입력하시오 : ");
		name = sc.next();
		name = name.replace(" ", "");
		
		for(int i=0; i<list.size(); ++i){
			StudentDTO stu = list.get(i);
			if(stu.getName().equals(name)){
				no_update = i;
				System.out.print("1 : 전체수정!, 2 : 부분수정!");
				sel = sc.nextInt();
				switch(sel){
					case 1 :{
						no = no_update +1;
						System.out.print("바꿀 이름을 입력하시오 : ");
						name = sc.next();
						name = name.replace(" ", "");
						while(true){
							date_cnt=0;
							System.out.print("바꿀 선수의 생일을 입력하시오 (년-월-일 구분!!: ");
							tempDate = sc.next();
							tempDate = tempDate.replace(" ", "");
							for(int j=0; j<tempDate.length(); ++i){
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
						StudentDTO dto = new StudentDTO(no, name, date, height);
						list.set(no_update, dto);
						/*
						for(int k=no_update+1; i<list.size(); ++i){
							StudentDTO temp = list.get(i);
							temp.setNo(i+1);
							list.set(i, temp);
						}*/
						
						break;
					}case 2 : {
						int w;
						no = no_update +1;
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
										for(int j=0; j<tempDate.length(); ++i){
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
		
						list.set(no_update, stu);
						/*
						for(int k=no_update+1; k<list.size(); ++k){
							StudentDTO temp = list.get(k);
							temp.setNo(k+1);
							list.set(k, temp);
						}*/
						break;
					}default :{
						System.out.print("1과 2번 중에서 고르시오!!");
					}
				}
				//name = sc.next();
			}
		}
		if(no_update == -1){
			System.out.println("해당학생의 이름은 존재하지 않습니다.");
		}
	}
	// 학생 데이터 삭제
	public void delete(){
		Scanner sc = new Scanner(System.in);
		Iterator<StudentDTO> it;
		String name;
		int no_update = -1;
		boolean exist = false;
		
		System.out.print("삭제하고 싶은 학생의 이름을 입력하시오 : ");
		name = sc.next();
		name = name.replace(" ", "");
		
		it = list.iterator();
		int w=-1;
		while(it.hasNext()){
			w++;
			StudentDTO stu = it.next();
			if(stu.getName().equals(name)){
				exist = true;
				it.remove();
				no_update = w;
				System.out.println(name + "의 학생정보를 삭제하였습니다.");
				break;
			}
		}
		
		if(no_update == -1){
			System.out.println(name + "이라는 학생의 이름은 존재하지 않습니다.");
		}else{
			for(int i = no_update; i<list.size(); ++i){
				StudentDTO stu2 = list.get(i);
				stu2.setNo(i+1);
				list.set(i, stu2);
			}
		}
	}
	// 학생 데이터 출력	n
	public void print(){
		for(int i=0; i<list.size(); ++i){
			StudentDTO stu = list.get(i);
			System.out.println(stu.toString());
		}
	}
	
	public void gradeManage(){
		Scanner sc = new Scanner(System.in);
		int seqNum = this.select();

		
		if(seqNum != -1){
			StudentDTO sgd = new StudentGradeDTO();
			StudentGradeDTO temp;
			sgd = list.get(seqNum);
			temp = (StudentGradeDTO)sgd;
			
			System.out.print("국어 점수를 입력하시오 : ");
			temp.setKor(sc.nextInt());
			
			System.out.print("수학 점수를 입력하시오 : ");
			temp.setMath(sc.nextInt());
			
			System.out.print("영어 점수를 입력하시오 : ");
			temp.setEng(sc.nextInt());
			
			list.set(seqNum, temp);
			System.out.println("기입완료!!");
		}
	}
	
	public void sum(){ //개인
		Scanner sc = new Scanner(System.in);
		int seqNum = this.select();
		int sum = 0;
		
		if(seqNum != -1){
			StudentDTO sgd = new StudentGradeDTO();
			StudentGradeDTO temp;
			sgd = list.get(seqNum);
			temp = (StudentGradeDTO)sgd;
			
			sum = temp.getKor() + temp.getMath() + temp.getEng();
			System.out.println(temp.getName() + "학생의 총점은 " + sum + "입니다");
			
		}
		
	}
	
	public void avg(){	// 개인
		Scanner sc = new Scanner(System.in);
		int seqNum = this.select();
		int sum;
		double avg;
		sum = 0;
		avg = 0.0;
		
		if(seqNum != -1){
			StudentDTO sgd = new StudentGradeDTO();
			StudentGradeDTO temp;
			sgd = list.get(seqNum);
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
		
		for(int i=0; i<list.size(); ++i){
			StudentGradeDTO temp = (StudentGradeDTO)list.get(i);
			sum = sum+ temp.getKor();
		}
		
		avg = (double)sum / list.size();
		
		System.out.println("총 학생의 국어 평균은 " + avg + "입니다");
	}
	
	public void engAvg() {
		int sum;
		double avg;
		sum = 0;
		avg = 0.0;
		
		for(int i=0; i<list.size(); ++i){
			StudentGradeDTO temp = (StudentGradeDTO)list.get(i);
			sum = sum+ temp.getEng();
		}
		
		avg = (double)sum / list.size();
		
		System.out.println("총 학생의 영어 평균은 " + avg + "입니다");
	}
	
	public void mathTop() {
		int top;
		int top_seq = 0;
		StudentGradeDTO temp = (StudentGradeDTO)list.get(0);
		top = temp.getMath();
		for(int i=0; i<list.size(); ++i){
			temp = (StudentGradeDTO)list.get(i);
			if(top < temp.getMath()){
				top = temp.getMath();
				top_seq = i;
			}
		}
		temp = (StudentGradeDTO)list.get(top_seq);
		System.out.println("수학 점수가 가장 높은 학생은" + temp.getMath() + "점으로 " + temp.getName() + " 입니다.");
	}
	
	public void bestOfTheBase(){
		int top;
		int sum;
		int top_seq = 0;
		StudentGradeDTO temp = (StudentGradeDTO)list.get(0);
		top = temp.getEng() + temp.getKor() + temp.getMath();
		
		for(int i=0; i<list.size(); ++i){
			temp = (StudentGradeDTO)list.get(i);
			sum = (temp.getEng() + temp.getKor() + temp.getMath());
			if(top < sum){
				top = sum;
				top_seq = i;
			}
		}
		temp = (StudentGradeDTO)list.get(top_seq);
		System.out.println("총점수가 가장 높은 학생은" + top + "점으로 " + temp.getName() + " 입니다.");
		
	}
	
}











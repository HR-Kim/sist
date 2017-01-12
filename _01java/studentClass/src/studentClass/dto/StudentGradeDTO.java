package studentClass.dto;

import java.util.Date;

public class StudentGradeDTO extends StudentDTO {
	
	private int kor;
	private int math;
	private int eng;
	
	public StudentGradeDTO() {
		// TODO Auto-generated constructor stub
	}

	public StudentGradeDTO(int no, String name, Date date, double height, int kor, int math, int eng) {
		super(no, name, date, height);
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}

	@Override
	public String toString() {
		return super.toString() + "StudentGradeDTO [kor=" + kor + ", math=" + math + ", eng=" + eng + "]";
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
	
	
}

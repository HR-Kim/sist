package baseball.dto;

public class Pitcher extends Human {
	private int win;
	private int lose;
	private double era;
	
	public Pitcher() {
		// TODO Auto-generated constructor stub
	}

	public Pitcher(int win, int lose, double era) {
		super();
		this.win = win;
		this.lose = lose;
		this.era = era;
	}
	
	public Pitcher(int no, String pos, String name, String birth, int age, double height, int win, int lose, double era) {
		super(no, pos, name, birth, age, height);
		this.win = win;
		this.lose = lose;
		this.era = era;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public double getEra() {
		return era;
	}

	public void setEra(double era) {
		this.era = era;
	}

	@Override
	public String toString() {
		return super.toString() + "-" + win + "-" + lose + "-" + era;
	}
	
	public void pitcherInfo(){
		System.out.println("Pitcher [win=" + win + ", lose=" + lose + ", era=" + era + "]");
	}
	
}

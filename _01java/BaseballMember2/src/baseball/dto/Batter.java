package baseball.dto;

public class Batter extends Human {
	private int batCount;
	private int hit;
	private double hitAvg;
	
	public Batter() {
		// TODO Auto-generated constructor stub
	}

	public Batter(int batCount, int hit, double hitAvg) {
		super();
		this.batCount = batCount;
		this.hit = hit;
		this.hitAvg = hitAvg;
	}
	
	public Batter(int no, String pos, String name, String birth, int age, double height, int batCount, int hit, double hitAvg) {
		super(no, pos, name, birth, age, height);
		this.batCount = batCount;
		this.hit = hit;
		this.hitAvg = hitAvg;
	}

	public int getBatCount() {
		return batCount;
	}

	public void setBatCount(int batCount) {
		this.batCount = batCount;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public double getHitAvg() {
		return hitAvg;
	}

	public void setHitAvg(double hitAvg) {
		this.hitAvg = hitAvg;
	}

	@Override
	public String toString() {
		return super.toString() + "-" + batCount + "-" + hit + "-" + hitAvg;
	}
	
	public void batterInfo(){
		System.out.println("Batter [batCount=" + batCount + ", hit=" + hit + ", hitAvg=" + hitAvg + "]");
	}
}

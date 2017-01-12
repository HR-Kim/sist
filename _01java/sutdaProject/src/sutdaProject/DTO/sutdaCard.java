package sutdaProject.DTO;

public class sutdaCard {
	private int num;
	private boolean isKwang;
	
	public sutdaCard() {
		
	}

	public sutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public boolean isKwang() {
		return isKwang;
	}

	public void setKwang(boolean isKwang) {
		this.isKwang = isKwang;
	}

	@Override
	public String toString() {
		return num + (isKwang ? "K" : "");
	
	}
}

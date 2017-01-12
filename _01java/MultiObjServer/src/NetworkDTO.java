import java.io.Serializable;

public class NetworkDTO implements Serializable {
	
	private int number;
	private String name;
	private int play;
	
	public NetworkDTO() {
		
	}

	public NetworkDTO(int number, String name, int play) {
		super();
		this.number = number;
		this.name = name;
		this.play = play;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlay() {
		return play;
	}

	public void setPlay(int play) {
		this.play = play;
	}

	@Override
	public String toString() {
		return "NetworkDTO [number=" + number + ", name=" + name + ", play=" + play + "]";
	}
	
	
}

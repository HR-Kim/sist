package baseball.dto;

public class InstanceofClass {
	
	public InstanceofClass(Human human) {
		this.PlayerInfo(human);
	}
	
	public void PlayerInfo(Human h){
		if(h instanceof Batter){
			Batter b = (Batter)h;
			b.batterInfo();
		}else if(h instanceof Pitcher){
			Pitcher p = (Pitcher)h;
			p.pitcherInfo();
		}
	}
}

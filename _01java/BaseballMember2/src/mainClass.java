import java.util.Scanner;

import baseball.dao.BaseBallDAO;
import baseball.dto.Batter;
import baseball.dto.Human;
import baseball.dto.InstanceofClass;
import baseball.dto.Pitcher;

public class mainClass {

	public static void main(String[] args) {
		BaseBallDAO dao = new BaseBallDAO();
		
		dao.loop();
		
	}

}

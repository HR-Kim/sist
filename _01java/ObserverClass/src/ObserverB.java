import java.util.Observable;
import java.util.Observer;

public class ObserverB implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		
		// TODO Auto-generated method stub
		String str = (String)arg;
		
		System.out.println("B입니다. 통지 받았음 : " + str);
		
	}

}

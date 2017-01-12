import java.util.Observable;

public class ObserverClass extends Observable{
	private String preArg = null;

	@Override
	public void notifyObservers(Object arg) {
		
		String str = (String)arg;
		// 변화가 없다  (통지 안해준다.)
		if(str.equals(preArg)) return;
		
		preArg = str;
		
		setChanged();
		
		super.notifyObservers(arg);
		clearChanged();
	}
	
	
}

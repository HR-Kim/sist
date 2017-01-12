
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObserverClass obMan = new ObserverClass();
		
		obMan.addObserver(new ObserverA());
		obMan.addObserver(new ObserverB());
		
		obMan.notifyObservers("변화");
		obMan.notifyObservers("살아있음");
	}

}

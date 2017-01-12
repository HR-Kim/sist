import factoryClass.Animal;
import factoryClass.AnimalFactory;
import factoryClass.Cat;
import factoryClass.Cow;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal ani1 = AnimalFactory.create("고양이");
		
		ani1.printDescription();
		Cat cat = (Cat)ani1;
		cat.CatMethod();
		
		Animal ani2 = AnimalFactory.create("소");
		ani2.printDescription();
		Cow cow = (Cow)ani2;
		cow.CowMethod();
		
	}

}

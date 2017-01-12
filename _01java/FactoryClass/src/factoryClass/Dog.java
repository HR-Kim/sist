package factoryClass;

public class Dog implements Animal {

	@Override
	public void printDescription() {
		// TODO Auto-generated method stub
		System.out.println("바둑이");
	}
	
	public void DogMethod() {
		System.out.println("멍멍");
	}
}

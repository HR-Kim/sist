package factoryClass;

public class AnimalFactory {
	
	public static Animal create(String animalName) {
		if(animalName.equals("")){
			System.out.println("생성할 클래스가 없습니다.");
		}
		if(animalName.endsWith("고양이")){
			return new Cat();
		}else if(animalName.endsWith("개")){
			return new Dog();
		}else if(animalName.endsWith("소")){
			return new Cow();
		}
		return null;
	}
}

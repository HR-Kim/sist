package factoryClass2;

public class AtypeClass implements AbstractWeapon {

	@Override
	public Weapon CreateWeapon() {
		// TODO Auto-generated method stub
		return new Gun();
	}

	@Override
	public Bomb CreateBomb() {
		// TODO Auto-generated method stub
		return new C4();
	}

}

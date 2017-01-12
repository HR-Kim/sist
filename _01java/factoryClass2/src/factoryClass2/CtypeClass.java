package factoryClass2;

public class CtypeClass implements AbstractWeapon {

	@Override
	public Weapon CreateWeapon() {
		// TODO Auto-generated method stub
		return new Sword();
	}

	@Override
	public Bomb CreateBomb() {
		// TODO Auto-generated method stub
		return new C4();
	}

}

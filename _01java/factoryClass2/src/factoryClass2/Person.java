package factoryClass2;

public class Person {
	
	Weapon m_weapon;
	Bomb m_Bomb;
	
	public void create(AbstractWeapon aw){
		this.m_weapon = aw.CreateWeapon();
		this.m_Bomb = aw.CreateBomb();
	}
}

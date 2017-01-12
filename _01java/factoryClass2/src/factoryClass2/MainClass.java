package factoryClass2;

import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		Person ps1;
		AbstractWeapon abWeapon;
		
		abWeapon = new AtypeClass();
		ps1 = new Person();
		ps1.create(abWeapon);
		//ps1.m_weapon.drawWeapon();
		//ps1.m_Bomb.DrawBomb();
		
		Person ps2;
		
		abWeapon = new BtypeClass();
		ps2 = new Person();
		ps2.create(abWeapon);
		//ps2.m_weapon.drawWeapon();
		//ps2.m_Bomb.DrawBomb();
		
		Person ps3;
		abWeapon = new CtypeClass();
		ps3 = new Person();
		ps3.create(abWeapon);
		
		
		// list 담는다.
		ArrayList<Person> list = new ArrayList<Person>();
		
		list.add(ps1);
		list.add(ps2);
		list.add(ps3);
		
		for(int i=0; i<list.size(); ++i){
			Person temp = list.get(i);
			System.out.println("ps" + i + " : \t" );
			temp.m_weapon.drawWeapon();
			temp.m_Bomb.DrawBomb();
		}
	}

}







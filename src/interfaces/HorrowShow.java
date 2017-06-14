package interfaces;


/**
 * 通过继承来扩展接口
 * 		1.在vampire中使用的语法仅适用于接口继承.  一般情况下,只可以将extends用于单一类,
 * 但是可以引用多个基类接口.
 * @author admin
 *
 */
interface Monster {
	void manace();
}

interface DangerousMonster extends Monster {
	void destroy();
}

interface Lethal {
	void kill();
}

class DragonZilla implements DangerousMonster {

	@Override
	public void manace() {}

	@Override
	public void destroy() {	}
	
}

interface Vampire extends DangerousMonster, Lethal {
	void drinkBlood();
}

class VeryBadVampire implements Vampire{

	@Override
	public void destroy() {}

	@Override
	public void manace() {}

	@Override
	public void kill() {}

	@Override
	public void drinkBlood() {}
	
}

public class HorrowShow {
	static void u(Monster b) { b.manace(); }
	static void v(DangerousMonster d) {
		d.manace();
		d.destroy();
	}
	static void w(Lethal l) { l.kill();}
	public static void main(String[] args) {
		DangerousMonster barney = new DragonZilla();
		u(barney);
		v(barney);
		Vampire vlad = new VeryBadVampire();
		u(vlad);
		v(vlad);
		w(vlad);
	}
}

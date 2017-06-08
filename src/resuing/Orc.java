package resuing;

/**
 *  1.在实际项目中,经常会想要将某些事物尽可能地对这个世界隐藏起来,但仍然允许导出类的成员访问它们.
 *  	关键字protected就是起这个作用的.
 *  2.protected 表示,"就类用户而言,这是private的,但对于任何继承与此类的导出类    或   
 *  任何位于同一包内的类来说,它却是可以访问的"(protected同时也提供了包内访问权限)
 *  	
 * @author admin
 *
 */
class Villain {
	private String name;
	protected void set(String nm) { this.name = nm;}
	public Villain(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "I'm a Villain and my name is " + name;
	}
}

public class Orc extends Villain{
	private int orcNumber;
	public Orc(String name, int orcNumber) {
		super(name);
		this.orcNumber = orcNumber;
	}
	public void change(String name, int orcNumber) {
		set(name);
		this.orcNumber = orcNumber;
	}
	@Override
	public String toString() {
		return "orc " + orcNumber + ": " + super.toString();
	}
	
	public static void main(String[] args) {
		Orc orc = new Orc("Lim", 12);
		System.out.println(orc);
		orc.change("Bob", 19);
		System.out.println(orc);
		
		/**
		 * orc 12: I'm a Villain and my name is Lim
			orc 19: I'm a Villain and my name is Bob
		 */
	}
}

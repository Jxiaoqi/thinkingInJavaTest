package resuing;

/**
 * 继承的语法
 * @author admin
 *
 */
class Cleanser{
	private String s = "Cleanserss";
	public void append(String a){ s += a; }
	public void dilute(){	append("dilute()");  }
	public void apply(){ append("apply()");}
	public void scrub(){  append("scrub()");}
	@Override
	public String toString() {	return s;}
	
	public static void main(String[] args) {
		Cleanser x = new Cleanser();
		x.dilute(); x.apply(); x.scrub();
		System.out.println(x);
	}
}

public class DeterGent extends Cleanser{
	@Override
	public void scrub() {		//change a method
		append(" DeterGent.scrub()");
		super.scrub();
	}
	//Add a method to the interface
	public void foam(){
		append(" foam()");
	}
	
	public static void main(String[] args) {
		DeterGent x = new DeterGent();
		x.dilute();
		x.apply();
		x.scrub();
		x.foam();
		System.out.println(x);
		System.out.println("Testing base class");
		Cleanser.main(args);		//调用基类的main方法
		
		/**
		 * Cleanserssdilute()apply() DeterGent.scrub()scrub() foam()
			Testing base class
			Cleanserssdilute()apply()scrub()

		 */
	}
}

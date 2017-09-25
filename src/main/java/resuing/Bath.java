package resuing;

class Soap {
	private String s;
	public Soap() {
		System.out.println("Sopa();");
		s = "Constructed";
	}
	@Override
	public String toString() {
		return s;
	}
}

/**
 * 初始化
 *  编译器并不是简单地为每一个引用都创建默认对象.
 *  如果初始化域,可以在代码的下列位置:
 *    1.在定义对象的地方;
 *    2.在类的构造器中;
 *    3.就在正要使用这些对象之前,成为   懒惰初始化.
 *    4.使用实例初始化;
 * @author admin
 *
 */
public class Bath {
	private String 
		s1 = "Happy",		//Initializing at point of definition
		s2 = "Happy",
		s3,s4;
	private Soap castille;
	private int i;
	private float toy;
	
	public Bath() {
		System.out.println("Inside Bath()");
		s3 = "Jou";			//Initializing at point of Constructor
		toy = 3.14f;
		castille = new Soap();
	}
	
	{ i = 47;}	//Instance initialization

	@Override
	public String toString() {
		if (s4 == null) {
			s4 = "joy";
		}
		return "Bath [s1=" + s1 + ", s2=" + s2 + ", s3=" + s3 + ", s4=" + s4
				+ ", castille=" + castille + ", i=" + i + ", toy=" + toy + "]";
	}
	
	public static void main(String[] args) {
		Bath b = new Bath();
		System.out.println(b);
		
		/**
		 * Inside Bath()
			Sopa();
			Bath [s1=Happy, s2=Happy, s3=Jou, s4=joy, castille=Constructed, i=47, toy=3.14]

		 */
	}
}

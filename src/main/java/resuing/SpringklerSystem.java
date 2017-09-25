package resuing;

/**
 * 组合的使用
 * 1, WaterSource对象调用toString()方法:
 * 		当编译器需要一个String 而你只有一个对象时,该方法就会被调用.  本例中,只有String类型可以和String 相加,
 * 	所有,就会调用waterSource的toString 方法,返回Constructor
 * 2. 初始化:
 * 		类中的域为基本类型时能够自动被初始化为零, 为对象的引用时会被初始化为null(默认)
 * @author admin
 *
 */
class WaterSource{
	private String s;
	public WaterSource() {
		System.out.println("WaterSource();");
		s = "Constructed";
	}
	@Override
	public String toString() {
		return s;
	}
}

public class SpringklerSystem {
	private String value1, value2, value3, value4;
	private WaterSource waterSource = new WaterSource();
	private int i;
	private float f;
	@Override
	public String toString() {
		return "SpringklerSystem [value1=" + value1 + ", value2=" + value2
				+ ", value3=" + value3 + ", value4=" + value4
				+ ", waterSource=" + waterSource + ", i=" + i + ", f=" + f
				+ "]";
	}
	
	public static void main(String[] args) {
		SpringklerSystem springklerSystem = new SpringklerSystem();
		System.out.println(springklerSystem);
		
		/**
		 * WaterSource();
			SpringklerSystem [value1=null, value2=null, value3=null, value4=null, waterSource=Constructed, i=0, f=0.0]
		 */
	}
	
}

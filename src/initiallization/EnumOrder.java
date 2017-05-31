package initiallization;

/**
 *  在你创建Enum时,编译器会自动添加一些有用的特性:
 *  	创建toString()方法
 *  	创建ordinal()方法
 * @author admin
 *
 */
public class EnumOrder {
	public static void main(String[] args) {
		for (Spiciness s : Spiciness.values()) {
			System.out.println(s + ", ordinal " + s.ordinal());
		}
	}

}

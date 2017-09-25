package chapter_11;

import java.util.ArrayList;

/**
 * 1.演示了容器类(集合)不加泛型情况下的添加,取出元素
 * 2.演示了JD5.0特有的注解,@SuppressWarnings("unchecked"),可以标注在类、字段、方法、参数、构造方法，以及局部变量上。
 *
 * @author admin
 *
 */
public class ApplesAndOrangesWithoutGenerics {
	
	public static void main(String[] args) {
		@SuppressWarnings("unchecked")
		ArrayList apples = new ArrayList();
		for (int i = 0; i < 3; i++) {
			apples.add(new Apple());
		}
		apples.add(new Orange());
		
		System.out.println(apples.size());
		
		for (int i = 0; i < apples.size(); i++) {
			long id = ((Apple)(apples.get(i))).id();
			System.out.println(id);
		}
	}

}


class Apple{
	private static long count;
	private final long id = count++;
	public long id(){
		return id;
	}
}

class Orange{
	
}
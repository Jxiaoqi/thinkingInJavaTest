package inerclasses;

/**
 * 链接到外部类  ---迭代器设计模式
 * 		1.用途2: 当生成一个内部类的对象时,此对象与制造它的外围对象(enclosing object)
 * 之间就有了一种联系,所以它能访问其外部对象的所有成员,而不需要任何特殊条件.此外,内部类还拥有其
 * 外围类的所有元素的访问权.
 * 		2.内部类可以访问其外围类的方法和字段,就想自己拥有它们一样,例如: SequenceSelector中的items
 * 		3. 内部类自动拥有对其外围类所有成员的访问权.这是如何做到的呢?
 * 			当某个外围类对象创建了一个内部类时对象时,此内部类对象必定会秘密地捕获一个指向那个外围类对象的引用.
 * 		然后在你访问此外围类时,就是用那个引用来选择外围类的成员.
 * 			编译器会帮你处理所有的细节,但你可以看到: 内部类的对象只能在与其外围类的对象相关联的情况下才能
 * 		被创建(在内部类时非static类时).构建内部对象时,需要一个指向其外围类对象的引用,如果编译器访问不到这个引用就会报错.
 * @author admin
 *
 */
interface Selector {
	boolean end();
	Object current();
	void next();
}

public class Sequence {
	private Object[] items;    //数组元素
	private int next = 0;		//当前指针指向位置
	
	public Sequence(int size) {
		items = new Object[size];
	}
	
	public void add(Object x) {
		if(next < items.length){
			items[next++] = x;
		}
	}
	
	class SequenceSelector implements Selector {
		private int i = 0;
		@Override
		public boolean end() {
			return i == items.length;
		}

		@Override
		public Object current() {
			return items[i];
		}

		@Override
		public void next() {
			if (i < items.length) 
				i++;
		}
		
	}
	
	public Selector selector() {
		return new SequenceSelector();
	}
	
	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for (int i = 0; i < 10; i++) {
			sequence.add(Integer.toString(i));
		}
		Selector selector = sequence.selector();
		while (!selector.end()) {
			System.out.println(selector.current());
			selector.next();
		}
	}
}

package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * 适配器方法惯用法
 * 		问题: 如果现有一个Iterable类,你想要添加一种或多种在foreach语句中使用这个类的方法,
 * 	应该怎么做呢?例如, 假设你希望可以选择向前或者向后的方向迭代一个单词列表.如果直接继承这个类,并
 *  覆盖Iterable()方法,你只能替换现有的方法,而不能实现选择.(添加方法,重构)
 *  	解决方案: 一种解决方案是所谓<适配器方法的惯用法>."适配器"部分来自于设计模式,因为你必须提供
 *  特定接口来满足foreach语句.当你有一个接口并需要另一个接口时,编写适配器就可以解决问题.
 *  			如果直接将ral对象置于foreach语句中,将得到(默认的)向前迭代器.但是如果在该对象
 *  上调用reversed()方法,就会产生不同的行为.
 *  			
 * @author admin
 *
 * @param <T>
 */
class ReversibleArrayList<T> extends ArrayList<T> {
	
	private static final long serialVersionUID = 1L;

	public ReversibleArrayList(Collection<T> c) {
		super(c);
	}
	
	public Iterable<T> reversed() {
		return new Iterable<T>() {

			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					int current = size() - 1;
					@Override
					public boolean hasNext() {
						return current > -1;
					}

					@Override
					public T next() {
						return get(current--);
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
}

public class ApdapterMethodIdim {
	public static void main(String[] args) {
		ReversibleArrayList<String> ral = 
				new ReversibleArrayList<String>(
						Arrays.asList(("You can you up, no do no bibi").split(" ")));
		for (String s : ral) {
			System.out.print(s + " ");
		}
		System.out.println();
		for (String s : ral.reversed()) {
			System.out.print(s + " ");
		}
	}
	
}

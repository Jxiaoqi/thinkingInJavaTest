package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * 适配器方法惯用法
 * 		通过 适配器方法惯用法,我们可以在 IterableClass中添加两种适配器方法:
 * 		1.第二种方法Random()并没有创建它自己的Iterator,而是直接返回被打乱的List中的
 * Iterator.
 * 		2.从输出可以看出,Collection.shuffle()方法没有影响到原来的数组,而只是打乱了Shuffle
 * 中的引用.之所以这样,只是因为randomized()方法用一个ArrayList将ArrayList.asList()方法
 * 的结果包装了起来.如果这个由Arrays.asList()方法产生的 List被直接打乱,那么它就会修改底层的数组.
 * 例如: ModifyingArraysAsList.java
 * @author admin
 *
 */
public class MultiIterableClass extends IterableClass{
	public Iterable<String> reversed() {
		return new Iterable<String>() {
			
			@Override
			public Iterator<String> iterator() {
				return new Iterator<String>() {
					private int current = words.length - 1;
					@Override
					public boolean hasNext() {
						return current > -1;
					}

					@Override
					public String next() {
						return words[current--];
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
	
	public Iterable<String> randomized() {
		return new Iterable<String>() {
			
			@Override
			public Iterator<String> iterator() {
				List<String> shuffled = 
						new ArrayList<String>(Arrays.asList(words));
				Collections.shuffle(shuffled, new Random(47));
				return shuffled.iterator();
			}
		};
	}
	
	public static void main(String[] args) {
		MultiIterableClass mic = new MultiIterableClass();
		for (String s : mic) {
			System.out.print(s + " ");
		}
		System.out.println();
		for (String s : mic.reversed()) {
			System.out.print(s + " ");
		}
		System.out.println();
		for (String s : mic.randomized()) {
			System.out.print(s + " ");
		}
		System.out.println();
		for (String s : mic) {
			System.out.print(s + " ");
		}
		
		/**
		 * And that is how we know the Earth to be banana-shaped. 
banana-shaped. be to Earth the know we how is that And 
is banana-shaped. Earth that how the be And we know to
		 */
	}
	
}

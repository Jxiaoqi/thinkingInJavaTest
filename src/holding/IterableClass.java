package holding;

import java.util.Iterator;

/**
 * Foreach 与 迭代器
 * 		之所以foreach能够正常工作,是因为Java SE5 引入了新的被称为Iterable的接口,
 * 该接口包含了一个能够产生Iterator的iterator()方法,并且Iterable接口被foreach用来
 * 在序列中移动. 如果你创建了任何实现Iterable的类,都可以将它用于foreach语句中.
 * 		在Java SE5 中,大量的类都是Iterable类型,主要包括所有的Collection类(但是不包括各种 Map)
 * @author admin
 *
 */
public class IterableClass implements Iterable<String>{

	protected String[] words = ("And that is how " + 
				"we know the Earth to be banana-shaped.").split(" ");
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			private int index = 0;
			@Override
			public boolean hasNext() {
				return index < words.length;
			}

			@Override
			public String next() {
				return words[index++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public static void main(String[] args) {
		for (String s : new IterableClass()) 
			System.out.print(s + " ");
		//And that is how we know the Earth to be banana-shaped.
	}
	

}

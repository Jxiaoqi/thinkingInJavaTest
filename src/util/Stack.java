package util;

import java.util.LinkedList;
/**
* Stack
* 		1."栈"通常是指"后进先出(LIFO)"的容器.也成为"叠加栈".
* 		2.LinkedList具有能够直接实现栈的所有功能的方法,因此可以直接将LinkedList作为栈使用.
* 不过,有时一个真正的栈更能把事情讲清楚:
* 		3.这里通过使用泛型,引入了在栈的类定义中最简单的可行示例.类名之后的<T>告诉编译器这将是一个
* 参数化类型,而其中的类型参数,即在类被使用时将会被实际类型替换的参数,就是T. 大体上,这个类是在声明
* "我们在定义一个可以持有T类型对象的Stack".
* 		4.为什么要使用组合: 如果你只需要栈的行为,这里使用继承就不合适了,因为这样会产生具有LinkedList
* 的其他所有方法的类.(java 1.0的设计者在创建java.util.Stack时,就犯了这个错误.)
* @author admin
*
*/
public class Stack<T> {
	private LinkedList<T> storage = new LinkedList<T>();
	public void push(T t) { storage.addFirst(t);}
	public T peek() { return storage.getFirst();}
	public T pop() { return storage.removeFirst();}
	public boolean empty() { return storage.isEmpty(); }
	@Override
	public String toString() {
		return storage.toString();
	}
}

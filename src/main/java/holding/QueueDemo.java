package holding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Queue p423
 * 		1.队列是一个典型的  先进先出(FIFO)的容器.即从容器的一端放入事物,从另一端取出,
 * 并且事物放入容器的顺序与取出的顺序是相同的. 队列  常被当作一个可靠的将对象从程序的某个区域
 * 传输到另一个区域的途径. 队列在并发编程中特别重要, 因为他们可以安全地讲对象从一个任务传输
 * 到另一个任务.
 * 		2.LinkedList提供了方法以支持队列的行为,并且它实现了Queue接口,因此 LinkedList
 * 可以用作Queue的一种实现.
 * 		3.offer() 方法在允许的情况下,将一个元素插入到队尾,或者返回false;
 * 		  peek() 和 element() 
 * 				他们都在不移除的情况下返回队头, 但是peek()方法在队列为空时返回null.
 * 	     而element()会排除NoSuchElementException异常.
 * 		  poll() 和 remove()
 * 				他们被用来, 移除并返回对头, 但是poll()在队列为空时返回null,而remove()
 *    会抛出NoSuchElementException异常.
 *    	4.Queue 接口窄化了对LinkedList的方法的访问权限,以使得只有恰当的方法才可以使用,因此,
 *    你能够访问的LinkedList的方法会变少.()
 * @author admin
 *
 */
public class QueueDemo {
	public static void printQ(Queue queue) {
		while (queue.peek() != null) 
			System.out.print(queue.remove() + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Random rand = new Random(47);
		for (int i = 0; i < 10; i++) 
			queue.offer(rand.nextInt(i + 10));
		printQ(queue);
		
		Queue<Character> qc = new LinkedList<Character>();
		for (char c  : "Brontosaurus".toCharArray()) 
			qc.offer(c);
		printQ(qc);
		
		/**
		 * 8 1 1 1 5 14 3 1 0 1 
			B r o n t o s a u r u s 
		 */
	}
}

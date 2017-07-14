package concurrency;

/**
 * 		这个任务的run()不是由单独的线程驱动的,它是在main()中直接调用的(
 * 	实际上,这里仍旧使用了线程,即总是分配给main()的那个线程.)
 * 		当从Runnable()导出一个类时,它必须具有一个run()方法,但是这个方法
 * 	并无特殊之处---它不会产生任何内在的线程能力.要实现线程行为,必须显式地将一个任务
 * 	附着到线程上.
 * @author admin
 *
 */
public class MainThread {
	public static void main(String[] args) {
		LiftOff lauch = new LiftOff();
		lauch.run();
		
		/**
		 * #0(9)
#0(8)
#0(7)
#0(6)
#0(5)
#0(4)
#0(3)
#0(2)
#0(1)
#0(LiftOff)
		 */
	}
}

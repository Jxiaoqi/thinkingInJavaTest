package concurrency;

/**
 * 在main线程中启动了另外一个线程t.所以,Waiting for LiftOff先输出了.
 * @author admin
 *
 */
public class BasicThreads {
	public static void main(String[] args) {
		Thread t = new Thread(new LiftOff());
		t.start();
		System.out.println("Waiting for LiftOff");
		
		/**
		 * Waiting for LiftOff
#0(9)
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

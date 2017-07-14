package concurrency;

/**
 * 在main线程中去启动多个线程.
 * 垃圾回收相关.
 * @author admin
 *
 */
public class MoreBasicThreads {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new LiftOff()).start();
			
			/**
			 * #0(9)
#4(9)
#2(9)
#1(9)
#3(9)
#3(8)
#3(7)
#2(8)
#4(8)
#0(8)
#4(7)
#2(7)
#3(6)
#1(8)
#3(5)
#2(6)
#4(6)
#0(7)
#4(5)
#2(5)
#3(4)
#1(7)
#3(3)
#2(4)
#4(4)
#0(6)
#4(3)
#2(3)
#3(2)
#1(6)
#3(1)
#2(2)
#4(2)
#0(5)
#4(1)
#2(1)
#3(LiftOff)
#1(5)
#1(4)
#1(3)
#1(2)
#2(LiftOff)
#4(LiftOff)
#0(4)
#1(1)
#0(3)
#1(LiftOff)
#0(2)
#0(1)
#0(LiftOff)
			 */
		}
	}
}

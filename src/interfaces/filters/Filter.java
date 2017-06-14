package interfaces.filters;

/**
 * 滤波器类
 * 		1.Filter 和 Processor 具有相同的接口元素,但是因为它并非继承自Processor----
 * 因为Filter类的创建者压根你想要将它用作Processor-----因此你不能将Filter用于Apply.process()方法,
 * 这是因为Apply.process() 和 Process之间的耦合过紧,已经超出了所需要的程度,这就使得应该复用Apply.process()
 * 方法时,复用却被禁止了.
 * 		2.如果Processor是一个接口,那么这些限制就会变得松动,使得你可以复用结构该接口的Apply.process().
 * 		interfaceprocessor就为该限制的修改版本
 * @author admin
 *
 */
public class Filter {
	public String name() {
		return getClass().getSimpleName();
	}
	
	public Waveform process(Waveform input) { return input;}
}

package interfaces.interfaceprocessor;

import interfaces.filters.BandPass;
import interfaces.filters.Filter;
import interfaces.filters.HighPass;
import interfaces.filters.LowPass;
import interfaces.filters.Waveform;


/**
 * 适配器设计模式
 * 		1.你经常碰到的情况是你无法修改想要使用的类.例如: 在滤波器的例子中,类库是被发现而非创建.
 * 在这些情况下,可以使用"适配器设计模式".在适配器的代码中,将接受你所拥有的接口,并产生你所需要的接口.
 * 		2.在这种使用适配器的模式中,FilterAdapter的构造器接口你所拥有的接口Filter,然后生成
 * 具有你所有的Processor接口的对象.
 * 		3.将接口从具体实现中解耦使得接口可以应用于多种不同的具体实现,因此代码也就具有可复用性.
 * @author admin
 *
 */
class FilterAdapter implements Processor {
	Filter filter;
	public FilterAdapter(Filter filter) {
		this.filter = filter;
	}
	
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return filter.name();
	}

	@Override
	public Waveform process(Object input) {
		// TODO Auto-generated method stub
		return filter.process((Waveform)input);
	}
	
}

public class FilterProcessor {
	public static void main(String[] args) {
		Waveform m = new Waveform();
		Apply.process(new FilterAdapter(new LowPass(1.0)), m);
		Apply.process(new FilterAdapter(new HighPass(2.0)), m);
		Apply.process(new FilterAdapter(new BandPass(3.0)), m);
		
		/**
		 * Using processor Waveform 0
			Waveform 0
			Using processor Waveform 0
			Waveform 0
			Using processor Waveform 0
			Waveform 0
		 */
	}
}

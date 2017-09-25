package interfaces.filters;

//滤波器类
public class Waveform {
	private static long counter;
	private final long id =  counter++;
	@Override
	public String toString() {
		return "Waveform " + id;
	}
}



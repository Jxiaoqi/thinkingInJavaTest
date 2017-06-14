package interfaces.filters;

public class BandPass extends Filter {
	double cutoff;
	public BandPass(double cutoff) {
		this.cutoff = cutoff;
	}
	
	@Override
	public Waveform process(Waveform input) {
		return input;
	}
}

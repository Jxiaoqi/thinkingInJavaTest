package access;

public class CholocateChip extends Cookie{
	public CholocateChip() {
		System.out.println("CholocateChip Constructor");
	}
	public void chomp(){
		bite();
	}
	public static void main(String[] args) {
		CholocateChip x = new CholocateChip();
		x.chomp();
	}
	
	/**
	 * Cookie Constructor
		CholocateChip Constructor
		bite
	 */
}

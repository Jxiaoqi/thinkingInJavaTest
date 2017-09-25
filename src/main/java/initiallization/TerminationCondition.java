package initiallization;

public class TerminationCondition {
	
	public static void main(String[] args) {
		Book novel = new Book(true);
		// proper cleanup
		novel.checkIn();
		//Drop the reference ,foget to clean up
		new Book(true);
		//Force garbage collection & finalization
		System.gc();
		
		
	}

}

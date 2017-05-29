package initiallization;

public class Book {
	boolean checkedOut = false;
	Book(boolean checkout){
		checkedOut = checkout;
	}
	void checkIn(){
		checkedOut = false;
	}
	@Override
	protected void finalize() throws Throwable {
		if (checkedOut) {
			System.out.println("Error : checked out");
		}
	}

}

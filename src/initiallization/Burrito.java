package initiallization;

/**
 * 枚举类型和  switch 配合使用  JDK5.0
 * @author admin
 *
 */
public class Burrito {
	Spiciness degree;
	public Burrito(Spiciness degree) {
		this.degree = degree;
	}
	
	public void describe(){
		System.out.print("this Burrito is ");
		switch (degree) {
		case NOT:		System.out.println("not spicy at all");
						break;
		case MILD:		
		case MEDIUM:   	System.out.println("a little hot.");
						break;
		case HOT:		
		case FLAMING:
		default: 		System.out.println("maybe too hot");
		}
	}
	
	public static void main(String[] args) {
		Burrito plaBurrito = new Burrito(Spiciness.NOT);
		Burrito	greenChile = new Burrito(Spiciness.MEDIUM);
		Burrito jalapeno = new Burrito(Spiciness.HOT);
		
		plaBurrito.describe();
		greenChile.describe();
		jalapeno.describe();
		
		/**
		 * this Burrito is not spicy at all
			this Burrito is a little hot.
			this Burrito is maybe too hot

		 */
	}
}

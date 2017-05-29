package chapter_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 联系泛型的使用
 * @author admin
 *
 */
public class Gerbil {
	private int gerbilNumber;

	public Gerbil(int gerbilNumber) {
		// TODO Auto-generated constructor stub
		this.gerbilNumber = gerbilNumber;
	}
	
	public void hop(){
		if (gerbilNumber%2==0) {
			System.out.println("这个袋鼠跳起来了..........");
		}else {
			System.out.println("这个袋鼠没跳起来..........");
			
		}
		
	}
	
	public static void main(String[] args) {
		List<Gerbil> gerbils = new ArrayList<Gerbil>();
		for (int i = 0; i < 3; i++) {
			gerbils.add(new Gerbil(i));
		}
		
		for (Gerbil gerbil : gerbils) {
			gerbil.hop();
		}
	}
}

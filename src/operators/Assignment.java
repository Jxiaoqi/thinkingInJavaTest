package operators;

import static util.Print.*;

/**
 * 为对象复制时,我们真正操作的是对对象的引用,所有倘若"将一个对象复制给另一个对象",实际是将
 * "引用" 从一个地方复制到了另一个地方,这意味着假若对对象使用 c=d, 那么c和d 都指向了只有d指向的那个对象
 * @author admin
 *
 */
public class Assignment {
	public static void main(String[] args) {
		Tank t1 = new Tank();
		Tank t2 = new Tank();
		t1.level = 9;
		t2.level = 47;
		print("1: t1.level:" + t1.level + 
				", t2.level:" + t2.level);
		
		t1 = t2;
		print("1: t1.level:" + t1.level + 
				", t2.level:" + t2.level);
		
		t1.level = 27;
		print("1: t1.level:" + t1.level + 
				", t2.level:" + t2.level);
		
		/**
		 * 1: t1.level:9, t2.level:47
			1: t1.level:47, t2.level:47
			1: t1.level:27, t2.level:27

		 */
	}
	
}

class Tank{
	int level;
}
	

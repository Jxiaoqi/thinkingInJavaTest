package control;
import static util.Print.*;

/**
 * 标签的用法.
 *  
 * @author admin
 *
 */
public class LabeledFor {
	
	public static void main(String[] args) {
		int i = 0;
		outer: 
		for (; true;) {
			inner:
			for (; i < 10; i++) {
				print("i = " + i);
				if (i == 2) {
					print("continue");
					continue;
				}
				if (i == 3) {
					print("break");
					i++;
					break;
				}
				if (i == 7) {
					print("continue outer"); //i == 7时, continue outer 语句会跳到循环顶部,而且也会跳过递增
					i++;
					continue outer;
				}
				if (i == 8) {
					print("break outer");
					break outer;
				}
				for (int k = 0; k < 5; k++) {
					if (k == 3) {
						print("k = " + k);
						print("continue inner");
						continue inner;
					}
				}
			}
		}
		
		/**
		 * i = 0
k = 3
continue inner
i = 1
k = 3
continue inner
i = 2
continue
i = 3
break
i = 4
k = 3
continue inner
i = 5
k = 3
continue inner
i = 6
k = 3
continue inner
i = 7
continue outer
i = 8
break outer
		 */
		
		
	}

}

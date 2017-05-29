package control;
/**
 * all the lowercase ASCII letters
 * 列出了所有的小写字母
 * @author admin
 *
 */
public class ListCharacters {
	
	public static void main(String[] args) {
		for (char c = 0; c < 128; c++) {
			if (Character.isLowerCase(c)) {		//输出小写字母
				System.out.println("value :" + (int)c + "  character: " + c);
			}
		}
	}

}

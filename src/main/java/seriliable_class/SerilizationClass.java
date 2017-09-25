package seriliable_class;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @author jyh
 * 之所以打印出10的原因在于序列化时,并不保存静态变量.
 * 这其实比较容易理解,序列化时保存的是对象的状态,而静态变量属于类状态,因此并不会被保存
 *
 */
public class SerilizationClass implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int staticVar = 5;
	
	public static void main(String[] args) {
		
		try {
			//初始化时 staticVar 的值为5
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.class"));
			out.writeObject(new SerilizationClass());
			out.close();
			
			//序列化之后改为10
			SerilizationClass.staticVar = 10;
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.class"));
			SerilizationClass test = (SerilizationClass)in.readObject();
			in.close();
			
			//再次读取后打印staticVar的值
			System.out.println(test.staticVar);
			
			
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

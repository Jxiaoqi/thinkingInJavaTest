package initiallization;

import static util.Print.*;
/**
 * 基本数据类型作为成员变量的默认值
 * @author admin
 *
 */
public class InitialValues {
	boolean t;
	char c;
	byte b;
	short s;
	int i;
	long l;
	float f;
	double d;
	InitialValues reference;
	
	void printInitialValues(){
		print("Data type         Initial value");
		print("boolean           " + t);
		print("char              " + c);
		print("byte              " + b);
		print("short             " + s);
		print("int               " + i);
		print("long              " + l);
		print("float             " + f);
		print("double            " + d);
		print("InitialVlaues     " + reference );
	}
	
	public static void main(String[] args) {
		InitialValues values = new InitialValues();
		values.printInitialValues();
		
		//new InitialValues().printInitialValues();
		/**
		 * Data type         Initial value
			boolean           false
			char              
			byte              0
			short             0
			int               0
			long              0
			float             0.0
			double            0.0
			InitialVlaues     null
		 */
	}
	   
}

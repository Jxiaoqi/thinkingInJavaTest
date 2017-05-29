package initiallization;
/**
 * 指定初始化的正确性取决于初始化的顺序,而与其编译无关. 编译器恰当地对"向前引用"发出了警告.
 * @author admin
 *
 */
public class MethodInit3 {
	
	//int j = g(i); Illegal forward reference	向前引用
	int i = f();
	int f(){
		return 11;
	}
	
	int g(int n){
		return n * 10;
	}

}

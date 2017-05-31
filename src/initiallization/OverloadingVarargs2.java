package initiallization;
// {CompileTimeError}
public class OverloadingVarargs2 {
	
	static void f(float i, Character... args){
		System.out.println("frist");
	}
	
	static void f(Character... args){
		System.out.println("second");
	}
	
	public static void main(String[] args) {
		f(1, 'a');
		//f('a', 'b');编译错误		//The method f(float, Character[]) is ambiguous for the type OverloadingVarargs2
	}

}

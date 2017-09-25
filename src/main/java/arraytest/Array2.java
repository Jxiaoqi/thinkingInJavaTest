package arraytest;

/**
 * 	数组元素不为基本数据类型时
 * 	数组元素不为基本原生数据类型时，存放的是引用类型，而不是对象本身。当生成对象之后，引用才指向对象，否则引用为null。
 * @author admin
 *
 */
public class Array2 {
	
	public static void main(String[] args) {
		
		Person[] persons = new Person[3];
		System.out.println(persons[0]);
		
		persons[0] = new Person(20);
		persons[1] = new Person(30);
		persons[2] = new Person(40);
		
		for (int i = 0; i < persons.length; i++) {
			System.out.println(persons[i].age);
		}
		
	}
	
	
	
	
	
}


class Person{
	
	int age;
	public Person(int age) {
		// TODO Auto-generated constructor stub
		this.age = age;
	}
}
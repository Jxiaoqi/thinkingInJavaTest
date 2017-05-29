package seriliable_class;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StorageTest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String name = "jia";
	
	public static void main(String[] args) {
		/*System.out.println(new File("result.obj").length());*/
		
		//methodA();
		
		methodB();
	}
	
	public static void methodA(){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result.obj"));
			StorageTest test1 = new StorageTest();
			StorageTest test2 = new StorageTest();
			
			oos.writeObject(test1);
			oos.flush();
			System.out.println(new File("result.obj").length());
			
			oos.writeObject(test1);
			oos.flush();
			System.out.println(new File("result.obj").length());
			
			oos.writeObject(test2);
			oos.flush();
			System.out.println(new File("result.obj").length());
			
			ObjectInputStream ois = new ObjectInputStream(
										new FileInputStream("result.obj"));
			StorageTest storageTest = (StorageTest)ois.readObject();
			StorageTest stoageTest1 = (StorageTest)ois.readObject();
			StorageTest storageTest2 = (StorageTest)ois.readObject();
			
			System.out.println(storageTest == stoageTest1);
			System.out.println(stoageTest1 == storageTest2);
			
		}  catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void methodB(){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result.obj"));
			StorageTest test1 = new StorageTest();
			StorageTest test2 = new StorageTest();
			test1.name = "li";
			test2.name = "liu";
			
			oos.writeObject(test1);
			oos.flush();
			System.out.println(new File("result.obj").length());
			
			oos.writeObject(test2);
			oos.flush();
			System.out.println(new File("result.obj").length());
			
			
			ObjectInputStream ois = new ObjectInputStream(
										new FileInputStream("result.obj"));
			StorageTest storageTest = (StorageTest)ois.readObject();
			StorageTest stoageTest1 = (StorageTest)ois.readObject();
			
			
			System.out.println(storageTest.name);
			System.out.println(stoageTest1.name);
			
		}  catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
		
	}
	
	


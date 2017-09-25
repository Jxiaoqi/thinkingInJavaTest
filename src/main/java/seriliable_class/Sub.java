package seriliable_class;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Sub extends Super implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String dec;

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public static void main(String[] args) {
		
		Sub sub = new Sub();
		sub.setAge(10);
		sub.setUserName("xiaoqi");
		sub.setDec("beautiful");
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("sub.txt"));
			out.writeObject(sub);
			out.close();
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("sub.t"));
			Sub s = (Sub)in.readObject();
			in.close();
			
			System.out.println(s.getAge());
			System.out.println(s.getUserName());
			System.out.println(s.getDec());
			
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

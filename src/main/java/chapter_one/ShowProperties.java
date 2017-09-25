package chapter_one;

import java.util.Properties;


public class ShowProperties {
	
	public static void main(String[] args) {
		
		Properties properties = System.getProperties();			
		properties.list(System.out);
		
		System.out.println(
				System.getProperty("user.name"));	
		
		System.out.println(
				System.getProperty("java.library.path")); 
		
		
	}

}

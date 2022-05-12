package pratice.tutorial.durgasir.collection.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties p = new Properties();
		FileInputStream fi = new FileInputStream("src/durga/collection/properties/abc.properties");
		p.load(fi);
		System.out.println(p);
		
		String s = p.getProperty("x");
		System.out.println(s);
		
		p.setProperty("x","123");
		
		FileOutputStream fo = new FileOutputStream("src/durga/collection/properties/abc.properties");
		p.store(fo, "Done by Aryan");
	}

}

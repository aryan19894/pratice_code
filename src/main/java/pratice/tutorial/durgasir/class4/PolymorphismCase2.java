package pratice.tutorial.durgasir.class4;

public class PolymorphismCase2 {

	public void m1(String s) {
		System.out.println("String version");
	}
	public void m1(Object o) {
		System.out.println("Object version");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PolymorphismCase2 p = new PolymorphismCase2();
		p.m1(new Object());
		p.m1(new String()); 
		p.m1("abc");
		p.m1(null);
		
	}

}

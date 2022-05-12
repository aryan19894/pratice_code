package pratice.tutorial.durgasir.class4;

public class PolymorphismCase3 {
	public void m1(String s) {
		System.out.println("String version");
	}
	public void m1(StringBuffer sb) {
		System.out.println("StringBuffer version");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PolymorphismCase3 p = new PolymorphismCase3();
		p.m1("durga");
		p.m1(new StringBuffer("durga")); 
		//p.m1(null);
	}

}

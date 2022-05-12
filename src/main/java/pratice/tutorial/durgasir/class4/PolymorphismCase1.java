package pratice.tutorial.durgasir.class4;

public class PolymorphismCase1 {
	
	public void m1(int i) {
		System.out.println("int");
	}
	public void m1(float f) {
		System.out.println("float");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PolymorphismCase1 p = new PolymorphismCase1();
		p.m1(10);
		p.m1(10.5f);
		p.m1('c');
		p.m1(10l);
		//p.m1(10.5);
	}

}

package pratice.tutorial.durgasir.class4;

public class PolymorphismCase5 {
	public void m1(int x) {
		System.out.println("int version");
	}
	public void m1(int... i) {
		System.out.println("int array version");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PolymorphismCase5 p = new PolymorphismCase5();
		p.m1(10, 20);
		p.m1();
		p.m1(10);
	}
}

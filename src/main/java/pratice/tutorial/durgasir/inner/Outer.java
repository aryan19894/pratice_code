package pratice.tutorial.durgasir.inner;

public class Outer {
	int x = 10;
	static int y = 20;
	class Inner {
		public void m1() {
			System.out.println(x);
			System.out.println(y);
			
		}
	}
	public void m1() {
		System.out.println(y);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Outer().new Inner().m1();
	}
}


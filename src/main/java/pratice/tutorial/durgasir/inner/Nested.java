package pratice.tutorial.durgasir.inner;

public class Nested {
	static class Inner {
		public void m1() {
			System.out.println("Nested");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Inner i = new Inner();
//		i.m1();
//		new Inner().m1();
		Nested n = new Nested();
		
//		
//		Nested.Inner i2 = n.new Inner();
	}

}

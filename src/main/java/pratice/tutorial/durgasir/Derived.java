package pratice.tutorial.durgasir;

class Base {
	static int i = 10;
	static {
		m1();
		System.out.println("Base Static Block");
	}
	public static void main(String[] args) {
		m1();
		System.out.println("Base Main");
	}
	public static void m1() {
		System.out.println(j);
	}
	static int j = 20;
}
public class Derived extends Base {
	static int x = 100;
	static {
		m2();
		System.out.println("Derived 1st Static Block");
	}
	public static void main(String[] args) {
		m2();
		System.out.println("Derived Main");
	}
	public static void m2() {
		System.out.println(y);
	}
	static {
		System.out.println("Derived 2nd Static Block");
	}
	static int y = 200;
}

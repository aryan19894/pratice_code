package pratice.tutorial.durgasir;

public class Test {
	int i = 10;
	{
		m1();
		System.out.println("1st Instance block");
	}
	Test() {
		System.out.println("Constructor");
	}
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println("Main");
	}
	public void m1() {
		System.out.println(j);
	}
	{
		System.out.println("2nd Instance block");
	}
	int j = 20;
}

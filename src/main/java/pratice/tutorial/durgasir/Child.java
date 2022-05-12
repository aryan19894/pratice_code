package pratice.tutorial.durgasir;

class Parent {
	int i = 10;
	{
		m1();
		System.out.println("Parent Instance block");
	}
	Parent() {
		System.out.println("Parent Constructor");
	}
	public static void main(String[] args) {
		Child p = new Child();
		System.out.println("Parent Main");
	}
	public void m1() {
		System.out.println(j);
	}
	int j = 20;
}
public class Child extends Parent {
	int x = 100;
	{
		m2();
		System.out.println("Child 1st Instance Block");
	}
	Child() {
		System.out.println("Child Constructor");
	}
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Child c = new Child();
		System.out.println("Child Main");
	}
	public void m2() {
		System.out.println(y);
	}
	{
		System.out.println("Child 2nd Instance Block");
	}
	int y = 200;
}

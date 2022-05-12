package pratice.tutorial.durgasir.generic;

class Gen<T> {
	T obj;
	Gen(T t) {
		this.obj = t;
	}
	public void show() {
		System.out.println(obj.getClass().getName());
	}
	T get() {
		return obj;
	}
}
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gen<String> a1 = new Gen<String>("abc");
		a1.show();
		System.out.println(a1.get());
		Gen<Integer> a2 = new Gen<Integer>(10);
		a2.show();
		System.out.println(a2.get());
		Gen<Double> a3 = new Gen<Double>(10.5);
		a3.show();
		System.out.println(a3.get());
		
	}

}

package pratice.tutorial.durgasir;

import static other.common.Print.println;

class P {
	static int i = 20;
}
class C extends P {
	int j;
	C() {
		j = super.i;
	}
	@SuppressWarnings("static-access")
	public int m1() {
		System.out.println(j);
		return super.i;
	}
}
public class Super {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C c = new C();
		println(c.m1());
	}

}

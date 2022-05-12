package pratice.tutorial.durgasir.class4;

public class PolymorphismCase4 {

	public void m1(int i, float f) {
		System.out.println("int-float version");
	}
	public void m1(float f, int i) {
		System.out.println("float-int version");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PolymorphismCase4 p = new PolymorphismCase4();
		p.m1(10, 10.5f);
		p.m1(10.5f, 10);
		//p.m1(10,  10);
		//p.m1(10.5f,  10.5f);
	}

}

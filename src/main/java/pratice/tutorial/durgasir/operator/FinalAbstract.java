package pratice.tutorial.durgasir.operator;

abstract class a {
	public final int x;
//	a() {
//		super();
//	}
	public a(int i) {
		this.x = i;
	}
}
class b extends a {
	b() {
		super(2);
	}
}
public class FinalAbstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		b b = new b();
		
		System.out.println(b.x);
	}

}

package pratice.tutorial.durgasir.class4;

class Animal {
	
}
class Monkey extends Animal {
	
}
public class PolymorphismCase6 {
	
	public void m1(Animal a) {
		System.out.println("Animal version");
	}
	public void m1(Monkey m) {
		System.out.println("Monkey version");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PolymorphismCase6 p = new PolymorphismCase6();
		Animal a = new Animal();
		p.m1(a);
		Monkey m = new Monkey();
		p.m1(m);
		Animal a1 = new Monkey();
		p.m1(a1);

		
	}
}

package companyOA.Interview.pegaSystem;

class A {
    public void m() {
        System.out.println("A.m");
    }
}

class B extends A {
    public void m() {
        System.out.println("B.m");
    }
}

class C extends B {
//	public void m() {
//		System.out.println("C.m");
//	}
}

public class Inherit {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        A a = new A();
        A b = new B();
        A c = new C();

        a.m();
        b.m();
        c.m();
    }

}

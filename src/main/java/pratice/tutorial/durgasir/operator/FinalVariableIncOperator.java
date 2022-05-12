package pratice.tutorial.durgasir.operator;

public class FinalVariableIncOperator {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		// char a = 'b';
		// char b = 'c';
		//
		// char c = (char) (a+b);

		// byte a = 10;
		// byte b = 20;
		// byte c = a+b;
		// System.out.println(c);
		//
		// short a = 2;
		// short b =3;
		// short c = a+b;
		// System.out.println(c);

		// double a = 12.2;
		// double b = 30;
		// double c = a+b;
		//
		// System.out.println(c);
		//
		// System.out.println(10+"abc");

		// System.out.println(4.5 & 6.5);

//		int x = 10, y = 15;
//		if(++x < 10 && x/0 > 10)
//			System.out.println("hello");
//		else 
//			System.out.println("hi");
//		System.out.println(x+"  "+y);
//		
//		int a = -130;
//		byte b = (byte)a;
//		System.out.println((int)b);
		
//		int x= 4*4/2;
//		System.out.println(x);
		
		//System.out.println(m1(1)+m1(2)*m1(3)/m1(4)+m1(5)*m1(6));
		
		String str = "String";
		Object o = Class.forName(str).newInstance();
		System.out.println(o.getClass().getName());
		Class c = o.getClass();
		//c Obj = (c)o;
		
	}
	
	public static int m1(int x) {
		System.out.println(x);
		return 10*x;
	}
}

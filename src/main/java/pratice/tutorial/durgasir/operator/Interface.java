package pratice.tutorial.durgasir.operator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

interface I {
	void m1();
	void m2();
	void m3();
	void m4();
	void m5();
	void m6();
	
}

abstract class AdapterI implements I {

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m5() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m6() {
		// TODO Auto-generated method stub
		
	}
	
}
class Test extends AdapterI {
	@Override
	public void m6() {
		// TODO Auto-generated method stub
		System.out.println("Hello babe");
	}
}
public class Interface implements InvocationHandler  {
	
	@Override
    public Object invoke (Object proxy, Method method, Object[] args) throws Throwable {
        
         Arrays.stream(Thread.currentThread()
                            .getStackTrace())
              .forEach(System.out::println);
        System.out.println(method);
        

        System.out.println("the invoked method: " + method);
        return null;
    }

    public static void main (String[] args) {
//    	Interface handler = new Interface();
//
//        I o = (I) Proxy.newProxyInstance(
//        		Interface.class.getClassLoader(),
//                            new Class[]{I.class}, handler);
//        o.m1();
    	
    	I obj = new Test();
    	obj.m1();
    }
    
//	public static void main(String[] s) {
//		int x = 9;
//		System.out.println(x);
//	}
}

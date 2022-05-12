package pratice.tutorial.durgasir.inner;

class MyThread extends Thread {
	public void run() {
		for(int i=0;i<100;i++)
			System.out.println("MyThread");
	}
}
public class ThreadDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread t = new MyThread();
		t.start();
		for(int i=0;i<100;i++)
			System.out.println("Main");
	}

}

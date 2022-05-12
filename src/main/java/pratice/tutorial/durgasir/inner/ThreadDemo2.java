package pratice.tutorial.durgasir.inner;

public class ThreadDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread() {
			public void run() {
				for(int i=0;i<100;i++)
					System.out.println("MyThread");
			}
		};
		t.start();
		for(int i=0;i<100;i++)
			System.out.println("Main");
	}

}

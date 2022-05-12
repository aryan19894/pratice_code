package pratice.tutorial.durgasir.inner;

//class CustomThread implements Runnable {
//	public void run() {
//		for(int i=0;i<100;i++)
//			System.out.println("MyThread");
//	}
//}
public class ThreadDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CustomThread r = new CustomThread();
//		Thread t = new Thread(new Runnable() {
//			public void run() {
//				for(int i=0;i<100;i++)
//					System.out.println("Child");
//			}
//		});
//		t.start();
		
		new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<100;i++)
					System.out.println("Child");
			}
		}).start();
		
//		Thread t = new Thread() {
//			public void run() {
//				for(int i=0;i<100;i++)
//					System.out.println("MyThread");
//			}
//		};
//		t.start();
		for(int i=0;i<100;i++)
			System.out.println("Main");
	}

}

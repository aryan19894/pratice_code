package pratice.tutorial.durgasir;

public class RuntimeException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		 
	    int r = 10/0;
	    System.out.println(r);
	    
	    long endTime = System.currentTimeMillis();
	 
	    long duration = (endTime - startTime);  //Total execution time in milli seconds
	     
	    System.out.println(duration);
	}

}

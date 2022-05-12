package companyOA.Interview.gartner.round1;
public class LCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a= 12, b = 16;
		
        int div = 2; int lcm = 1;
		while(a > 0 && b > 0 && (div < a || div < b)) {
            if(a %div == 0 && b%div == 0) {
                a /= div;
                b /=div;

                lcm *= div;
            } 
            div++;
        }

        lcm *= a * b;

        System.out.println(lcm);
	}

}




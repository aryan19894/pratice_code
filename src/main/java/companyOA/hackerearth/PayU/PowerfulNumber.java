package companyOA.hackerearth.PayU;

public class PowerfulNumber {
    static int digSum(int n1) {
        double n = Math.pow(2, n1);
        if (n == 0)
            return 0;
        return (n % 9 == 0) ? 9 : (int) (n % 9);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 99983;

        System.out.println(digSum(n));

    }

}

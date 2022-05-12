package pratice.striver.DSAExperience.T7RecursionBacktracking.theory;

public class SumOfFirstN {
    //recursive - parametric
    // [Recursive] O(N), O(N) - n iteration
    public static void sum(int n, int sum) {
        if (n < 1) {
            System.out.println(sum);
            return;
        }
        sum(n - 1, sum + n);
    }

    //recursive - functional
    public static int sum2(int n) {
        if (n == 0) return 0;
        return n + sum2(n - 1);
    }

    public static void main(String[] args) {
        sum(3, 0);
        System.out.println(sum2(3));
    }
}

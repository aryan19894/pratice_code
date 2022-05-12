package pratice.striver.DSAExperience.T7RecursionBacktracking.theory;

public class Print1toN {
    //recursive
    // [Recursive] O(N), O(N) - n iteration
    public static void print(int i, int n) {
        if (i > n) return;
        System.out.println(i);
        print(i + 1, n);
    }

    //recursive -backtracking
    public static void print2(int n) {
        if (n < 1) return;
        print2(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        print(1, 5);
    }
}

package pratice.striver.DSAExperience.T7RecursionBacktracking.theory;

public class PrintNto1 {
    //recursive
    // [Recursive] O(N), O(N) - n iteration
    public static void print(int i, int n) {
        if (i > n) return;
        print(i + 1, n);
        System.out.print(i + " ");
    }

    //recursive -backtracking
    public static void print2(int n) {
        if (n < 1) return;
        System.out.print(n + " ");
        print2(n - 1);
    }

    public static void main(String[] args) {
        print(1, 5);
        System.out.println();
        print2(5);
    }
}

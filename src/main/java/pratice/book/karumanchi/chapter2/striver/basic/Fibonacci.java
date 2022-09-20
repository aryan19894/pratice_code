package pratice.book.karumanchi.chapter2.striver.basic;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.print("0 1 ");
        fiboNth(0, 1, 15);
        System.out.println("\n"+fiboNth(15));
    }

    private static int fiboNth(int n) {
        if (n <= 1) return n;
        return fiboNth(n - 1) + fiboNth(n - 2);
    }

    private static void fiboNth(int a, int b, int n) {
        int c = a + b;
        if (n < 3) return;

        System.out.print(c + " ");
        fiboNth(b, c, n - 1);
    }
}

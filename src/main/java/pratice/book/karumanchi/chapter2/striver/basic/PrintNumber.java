package pratice.book.karumanchi.chapter2.striver.basic;

public class PrintNumber {
    public static void print1toN(int n) {
        if (n == 0) return;
        print1toN(n - 1);
        System.out.print(n + " ");
    }

    public static void printNto1(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printNto1(n - 1);
    }

    public static void main(String[] args) {
        print1toN(8);
        System.out.println();
        printNto1(8);
    }
}

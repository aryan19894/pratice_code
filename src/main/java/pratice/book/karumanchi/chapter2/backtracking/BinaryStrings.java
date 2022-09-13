package pratice.book.karumanchi.chapter2.backtracking;

public class BinaryStrings {
    int[] a;

    public BinaryStrings(int n) {
        this.a = new int[n];
    }

    public static void main(String[] args) {
        int n = 4;
        BinaryStrings binary = new BinaryStrings(n);
        binary.print(n);
    }

    private void print(int n) {
        if (n <= 0) {
            printString(a);
            return;
        }

        a[n - 1] = 0;
        print(n - 1);
        a[n - 1] = 1;
        print(n - 1);
    }

    private void printString(int[] a) {
        StringBuffer sb = new StringBuffer();
        for(int e: a)
            sb.append(e);
        System.out.println(sb);
    }
}

package pratice.book.karumanchi.chapter2.backtracking;

public class KaryStrings {
    int[] a;

    public KaryStrings(int n) {
        this.a = new int[n];
    }

    public static void main(String[] args) {
        int n = 3;
        KaryStrings binary = new KaryStrings(n);
        binary.print(n, 5);
    }

    private void print(int n, int k) {
        if (n <= 0) {
            printString(a);
            return;
        }

        for (int i = 0; i < k; i++) {
            a[n - 1] = i;
            print(n - 1, k);
        }
    }

    private void printString(int[] a) {
        StringBuffer sb = new StringBuffer();
        for (int e : a)
            sb.append(e);
        System.out.println(sb);
    }
}

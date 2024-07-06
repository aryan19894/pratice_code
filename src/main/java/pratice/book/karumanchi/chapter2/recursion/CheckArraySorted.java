package pratice.book.karumanchi.chapter2.recursion;

public class CheckArraySorted {
    public static void main(String[] args) {
        int[] a = {5, 8, 19, 11, 13};
        boolean res = isArraySorted(a, 1, a.length);
        System.out.println(res);
    }

    private static boolean isArraySorted(int[] a, int i, int n) {
        if (i == n) return true;

        return a[i - 1] <= a[i] && isArraySorted(a, i + 1, n);
    }
}

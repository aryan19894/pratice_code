package pratice.book.karumanchi.chapter2.striver.basic;

public class CountSubsequenceWithSumK {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 2, 0};
        System.out.println(subset(arr, 0, 5));
    }

    private static int subset(int[] arr, int i, int k) {
        if (i == arr.length) {
            if (k == 0) return 1;
            return 0;
        }

        int take = subset(arr, i + 1, k - arr[i]);
        int notTake = subset(arr, i + 1, k);
        return take + notTake;
    }
}

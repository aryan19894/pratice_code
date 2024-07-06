package pratice.book.karumanchi.chapter2.striver.basic;

import java.util.ArrayList;

public class PrintSubsequenceWithSumK {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 2, 0};
        subset(arr, 0, new ArrayList<>(), 5);
    }

    private static void subset(int[] arr, int i, ArrayList<Integer> sub, int k) {
        if (i == arr.length) {
            if (k == 0) {
                System.out.println(sub);
                return;
            }
            return;
        }

        //take
        sub.add(arr[i]);
        subset(arr, i + 1, sub, k - arr[i]);
        sub.remove(sub.size() - 1);
        //notTake
        subset(arr, i + 1, sub, k);
    }
}

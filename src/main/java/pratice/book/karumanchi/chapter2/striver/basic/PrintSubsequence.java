package pratice.book.karumanchi.chapter2.striver.basic;

import java.util.ArrayList;

public class PrintSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4};
        subset(arr, 0, new ArrayList<>());
    }

    private static void subset(int[] arr, int i, ArrayList<Integer> sub) {
        if (i == arr.length) {
            System.out.println(sub);
            return;
        }

        //take
        sub.add(arr[i]);
        subset(arr, i + 1, sub);
        sub.remove(sub.size()-1);
        //notTake
        subset(arr, i + 1, sub);
    }
}

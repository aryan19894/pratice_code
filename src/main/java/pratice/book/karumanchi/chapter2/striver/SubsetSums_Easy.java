package pratice.book.karumanchi.chapter2.striver;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSums_Easy {
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> res = new ArrayList<>();
        find(arr, 0, 0, N, res);
        return res;
    }

    private static void find(ArrayList<Integer> arr, int i, int sum, int n, ArrayList<Integer> res) {
        if (i == n) {
            res.add(sum);
            return;
        }

        //take
        find(arr, i + 1, sum + arr.get(i), n, res);
        //notTake
        find(arr, i + 1, sum, n, res);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{2, 3}));
        Out.print(subsetSums(list, list.size()));
    }
}

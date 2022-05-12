package pratice.striver.DSAExperience.T7RecursionBacktracking.theory;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequence {
    // [Recursive] O(2n) - each n element has 2 option - pick or not pick
    private static void subsequence(int i, int[] arr, int n, List<Integer> res) {
        if (i == n) {
            Out.print(res);
            return;
        }

        res.add(arr[i]);
        subsequence(i + 1, arr, n, res);
        res.remove(res.size() - 1);
        subsequence(i + 1, arr, n, res);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        List<Integer> list = new ArrayList<>();
        subsequence(0, arr, arr.length, list);
        Out.print(list);
    }
}

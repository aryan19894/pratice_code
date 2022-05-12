package pratice.gfg.companywise.facebook;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LargestFibonacciSubsequence {
    static public class Solution {
        public int[] findFibSubset(int arr[], int n) {
            int max = Integer.MIN_VALUE;
            for (int a : arr)
                max = Math.max(max, a);

            HashSet<Integer> fib = new HashSet<>();
            fib.add(0);
            fib.add(1);
            fibo(fib, 0, 1, max);

            List<Integer> res = new ArrayList<>();
            for (int a : arr) {
                if (fib.contains(a))
                    res.add(a);
            }

            int[] result = new int[res.size()];
            int i = 0;
            for (int r : res)
                result[i++] = r;
            return result;
        }

        private void fibo(HashSet<Integer> fib, int i, int j, int max) {
            fib.add(i + j);
            if (i + j > max) return;

            fibo(fib, j, i + j, max);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {0, 2, 8, 5, 2, 1, 4,
                13, 23};
        int n = 0;
        Out.print(sol.findFibSubset(arr, arr.length));
    }
}

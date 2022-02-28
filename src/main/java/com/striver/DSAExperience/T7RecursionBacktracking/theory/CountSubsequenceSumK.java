package com.striver.DSAExperience.T7RecursionBacktracking.theory;

public class CountSubsequenceSumK {
    // [Recursive] O(2n) - each n element has 2 option - pick or not pick
    private static int subsequence(int i, int[] arr, int n, int sum, int K) {
        if (sum > K) return 0;
        if (i == n) {
            if (sum == K)
                return 1;
            return 0;
        }

        return subsequence(i + 1, arr, n, sum + arr[i], K) + subsequence(i + 1, arr, n, sum, K);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1, 2, 3, 2, 1, 1, 1, 2, 2};
        int n = subsequence(0, arr, arr.length, 0, 2);
        System.out.println(n);
    }
}

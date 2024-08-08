package revise._2024.striver.DP._1D;

import java.util.Arrays;

public class FrogJumpWithKDistance_MinimalCost {
    static public int minimizeCost(int arr[], int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return countCost(arr, k, n - 1, dp);
    }

    private static int countCost(int[] arr, int k, int idx, int[] dp) {
        if (idx == 0) return 0;

        if (dp[idx] != -1) return dp[idx];

        int minJump = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (idx - i >= 0) {
                int jump = countCost(arr, k, idx - i, dp) + Math.abs((arr[idx] - arr[idx - i]));
                minJump = Math.min(minJump, jump);
            }
        }
        return dp[idx] = minJump;
    }

    static public int minimizeCost2(int arr[], int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int idx = 1; idx < n; idx++) {
            int minJump = Integer.MAX_VALUE;
            for (int i = 1; i <= k; i++) {
                if (idx - i >= 0) {
                    int jump = dp[idx - i] + Math.abs((arr[idx] - arr[idx - i]));
                    minJump = Math.min(minJump, jump);
                }
            }
            dp[idx] = minJump;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int k = 3;
        int[] height = {10, 30, 40, 50, 20};

        System.out.println(minimizeCost(height, k));
        System.out.println(minimizeCost2(height, k));
    }
}

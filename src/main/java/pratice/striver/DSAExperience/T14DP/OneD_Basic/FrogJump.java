package pratice.striver.DSAExperience.T14DP.OneD_Basic;

import pratice.common.Out;

import java.util.Arrays;

public class FrogJump {

    // [Better DP: Memo] TC: O(N). The overlapping subproblems will return the answer in constant time O(1).
    // Therefore, the total number of new subproblems we solve is ‘n’.
    // SC: O(N): Using a recursion stack space(O(N)) and an array (again O(N)).
    // Therefore total space complexity will be O(N) + O(N) ≈ O(N)
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[heights.length + 1];
        Arrays.fill(dp, -1);
        return minJump(n - 1, heights, dp);
    }

    private static int minJump(int n, int[] heights, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];

        int left = minJump(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1)
            right = minJump(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);

        return dp[n] = Math.min(left, right);
    }

    // [Better DP: Tab] TC: O(N), O(N): running a simple iterative loop
    // using an external array of size ‘n+1’.
    public static int frogJump2(int n, int heights[]) {
        int[] dp = new int[heights.length];
        for (int i = 1; i < n; i++) {
            int left = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1)
                right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);

            dp[i] = Math.min(left, right);
        }
        return dp[n - 1];
    }

    // [Better DP: Tab] TC: O(N), O(1): running a simple iterative loop
    public static int frogJump3(int n, int heights[]) {
        int prev1 = 0;
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int left = prev1 + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1)
                right = prev2 + Math.abs(heights[i] - heights[i - 2]);

            prev2 = prev1;
            prev1 = Math.min(left, right);
        }
        return prev1;
    }

    public static void main(String[] args) {
        int heights[] = {10, 50, 10};
        //Out.print(frogJump(heights.length, heights));
        //Out.print(frogJump2(heights.length, heights));
        Out.print(frogJump3(heights.length, heights));
    }
}

package pratice.striver.DSAExperience.T14DP.OneD_Basic;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.Arrays;

public class FrogJumpWithKDistance {
    // [Better DP: Memo] TC: O(N*K). The overlapping subproblems will return the answer in constant time.
    // Therefore, the total number of new subproblems we solve is ‘n’. At every new subproblem, we are running another
    // loop for K times.
    // SC: O(N). using a recursion stack space(O(N)) and an array (again O(N)).
    // Therefore, total space complexity will be O(N) + O(N) ≈ O(N)
    public static int frogJump(int n, int heights[], int k) {
        int[] dp = new int[heights.length + 1];
        Arrays.fill(dp, -1);
        return minJump(n - 1, heights, dp, k);
    }

    private static int minJump(int n, int[] heights, int[] dp, int k) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        int jump = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if ((n - i) >= 0)
                jump = Math.min(jump, minJump(n - i, heights, dp, k) + Math.abs(heights[n] - heights[n - i]));
        }
        return dp[n] = jump;
    }

    // [Better DP: Tab] TC: O(N*K): running two nested loops, where outer loops run from 1 to n-1 and
    // the inner loop runs from 1 to K
    // SC: O(N). using an external array of size ‘n’’.
    public static int frogJump2(int n, int heights[], int k) {
        int[] dp = new int[heights.length + 1];
        for (int i = 1; i < n; i++) {
            int jump = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if ((i - j) >= 0)
                    jump = Math.min(jump, dp[i - j] + Math.abs(heights[i] - heights[i - j]));
            }
            dp[i] = jump;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int heights[] = {40, 10, 20, 70, 80, 10, 20, 70, 80, 60};
        Out.print(frogJump(heights.length, heights, 4));
        Out.print(frogJump2(heights.length, heights, 4));
    }
}

package revise._2024.striver.DP._1D;

import java.util.Arrays;

public class FrogJump {
    //1.19
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return countJump(n - 1, heights, dp);
    }

    private static int countJump(int idx, int[] heights, int[] dp) {
        if (idx == 0) return 0;

        if (dp[idx] != -1) return dp[idx];

        int jump1 = countJump(idx - 1, heights, dp) +
                Math.abs(heights[idx] - heights[idx - 1]);

        int jump2 = Integer.MAX_VALUE;
        if (idx > 1)
            jump2 = countJump(idx - 2, heights, dp) +
                    Math.abs(heights[idx] - heights[idx - 2]);
        return dp[idx] = Math.min(jump1, jump2);
    }

    //1.21
    public static int frogJump1(int n, int heights[]) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int jump1 = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int jump2 = Integer.MAX_VALUE;
            if (i > 1)
                jump2 = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            dp[i] = Math.min(jump1, jump2);
        }
        return dp[n - 1];
    }

    //1.14
    public static int frogJump2(int n, int heights[]) {
        int prev1 = 0, prev2 = 0;

        for (int i = 1; i < n; i++) {
            int jump1 = prev1 + Math.abs(heights[i] - heights[i - 1]);
            int jump2 = Integer.MAX_VALUE;
            if (i > 1)
                jump2 = prev2 + Math.abs(heights[i] - heights[i - 2]);

            prev2 = prev1;
            prev1 = Math.min(jump1, jump2);
        }
        return prev1;
    }

    public static void main(String[] args) {
        int n = 0;
        int[] height = {30, 10, 60, 10, 60, 50};

        System.out.println(frogJump(height.length, height));
        System.out.println(frogJump1(height.length, height));
        System.out.println(frogJump2(height.length, height));
    }
}

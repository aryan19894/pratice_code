package pratice.striver.DSAExperience.T14DP.TwoD_OnString.LIS;

import pratice.common.Out;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence_medium_673 {
    static class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n + 1];
            int[] count = new int[n + 1];
            Arrays.fill(dp, 1);
            Arrays.fill(count, 1);

            int max = 1;
            for (int i = 1; i < n; i++) {
                for (int prev = 0; prev < i; prev++) {
                    if (nums[i] > nums[prev]) {
                        if (dp[i] < 1 + dp[prev]) {
                            dp[i] = 1 + dp[prev];
                            count[i] = count[prev];
                        } else if (dp[i] == 1 + dp[prev])
                            count[i] += count[prev];
                    }
                }
                max = Math.max(dp[i], max);
            }
            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (dp[i] == max)
                    res += count[i];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 2, 2, 2, 2};
        //int[] nums = {1, 3, 5, 4, 7}; // 2
        //int[] nums = {1, 2};  //1
        Out.print(sol.findNumberOfLIS(nums));
    }
}

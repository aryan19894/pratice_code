package pratice.striver.DSAExperience.T14DP.TwoD_OnString.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintLongestIncreasingSubsequence_medium_300 {
    static class Solution {
        public void printLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int[] prevId = new int[n];
            Arrays.fill(dp, 1);
            int max = 0, maxId = 0;
            for (int i = 1; i < n; i++) {
                prevId[i] = i;
                for (int prev = 0; prev < i; prev++) {
                    if (nums[prev] < nums[i] && dp[i] < 1 + dp[prev]) {
                        dp[i] = 1 + dp[prev];
                        prevId[i] = prev;
                    }
                }
                if (max < dp[i]) {
                    max = dp[i];
                    maxId = i;
                }
            }

            List<Integer> res = new ArrayList<>();
            res.add(nums[maxId]);
            while (prevId[maxId] != maxId) {
                maxId = prevId[maxId];
                res.add(nums[maxId]);
            }
            Collections.sort(res);
            for (int r : res)
                System.out.print(r + " ");
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {17, 3};
        sol.printLIS(nums);
    }
}

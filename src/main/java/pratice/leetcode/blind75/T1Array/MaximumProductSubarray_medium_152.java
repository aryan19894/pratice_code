package pratice.leetcode.blind75.T1Array;

import pratice.common.Out;

public class MaximumProductSubarray_medium_152 {
    static class Solution {
        public int maxProduct(int[] nums) {
            int maxSoFar = nums[0], minSoFar = nums[0];
            int ans = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < 0) {
                    int temp = maxSoFar;
                    maxSoFar = minSoFar;
                    minSoFar = temp;
                }
                maxSoFar = Math.max(nums[i], maxSoFar * nums[i]);
                minSoFar = Math.min(nums[i], minSoFar * nums[i]);

                ans = max(ans, maxSoFar, minSoFar);
            }
            return ans;
        }

        private static int max(int... ele) {
            int max = Integer.MIN_VALUE;
            for (int e : ele)
                max = Math.max(max, e);
            return max;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {6, -3, -10, 0, 2};
        Out.print(sol.maxProduct(nums));
    }
}

package pratice.leetcode.blind75.T1Array;

import pratice.common.Out;

public class ProductOfArrayExceptSelf_medium_238 {
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];

            int product = 1;
            for (int i = 0; i < n; i++) {
                ans[i] = product;
                product *= nums[i];
            }
            product = 1;
            for (int i = n - 1; i >= 0; i--) {
                ans[i] *= product;
                product *= nums[i];
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-1,1,0,-3,3};
        Out.print(sol.productExceptSelf(nums));
    }
}

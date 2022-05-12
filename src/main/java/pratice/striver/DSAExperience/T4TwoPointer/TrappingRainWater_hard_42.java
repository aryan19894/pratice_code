package pratice.striver.DSAExperience.T4TwoPointer;/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
public class TrappingRainWater_hard_42 {
    static class Solution {
        // [Basic] O(n2), O(1) - we will find indivisible box tapped water and take sum
        // [Better] O(n)+O(n)+O(n), O(2n) - will find prefix sum and suffix sum and calculate the tapped water
        public int trap1(int[] height) {
            int n = height.length;
            int[] prefix = new int[n];

            prefix[0] = height[0];
            for (int i = 1; i < n; i++) {
                prefix[i] = Math.max(prefix[i - 1], height[i]);
            }
            int[] suffix = new int[n];
            suffix[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                suffix[i] = Math.max(suffix[i + 1], height[i]);
            }

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.min(prefix[i], suffix[i]) - height[i];
            }
            return sum;
        }

        // [Optimal] O(n), O(1) - will use 2pointer rule and find leftmax and rightmax with 2pointers.
        public int trap2(int[] height) {
            int n = height.length;

            int left = 0;
            int right = n - 1;
            int leftmax = 0, rightmax = 0, res = 0;

            while (left <= right) {
                if (height[left] <= height[right]) {
                    if (height[left] >= leftmax) leftmax = height[left];
                    else res += (leftmax - height[left]);
                    left++;
                } else {
                    if (height[right] >= rightmax) rightmax = height[right];
                    else res += (rightmax - height[right]);
                    right--;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(sol.trap1(nums));
        System.out.println(sol.trap2(nums));
    }
}

// @lc code=end


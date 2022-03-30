package com.leetcode.blind75.T1Array;

import com.common.Out;

import java.util.Stack;

public class ContainerWithMostWater_medium_11 {
    static class Solution {
        public int maxArea(int[] height) {
            int n = height.length;
            int max = Integer.MIN_VALUE;
            int i = 0, j = n - 1;
            while (i < j) {
                int min = Math.min(height[i], height[j]);
                max = Math.max(max, min * (j - i));

                if (height[i] < height[j]) i++;
                else j--;
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Out.print(sol.maxArea(height));
    }
}

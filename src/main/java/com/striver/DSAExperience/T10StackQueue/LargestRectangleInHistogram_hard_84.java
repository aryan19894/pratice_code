package com.striver.DSAExperience.T10StackQueue;

import java.util.Stack;

public class LargestRectangleInHistogram_hard_84 {
    static class Solution {
        // [Better] TC: O(5n) = O(n): O(n) + O(n) - left smaller array loop and throughout stack processing,
        // O(n) + O(n) - right smaller array loop and throughout stack processing
        // O(n) - finding the max value to iterate through left and right array
        // SC: O(3n): left, right array & stack
        public int largestRectangleArea1(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];
            Stack<Integer> stack = new Stack();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                    stack.pop();

                //O is initial index and +1 to index because boundary for left small is from next index
                left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
                stack.push(i);
            }
            stack = new Stack();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                    stack.pop();

                //n-1 is last index if stack is empty and -1 to index because boundary for right small is from previous index
                right[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
                stack.push(i);
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, (right[i] - left[i] + 1) * heights[i]);
            }
            return max;
        }

        // [Optimal] TC: O(2n) = O(n): O(n) + O(n) - iteration of original array and throughout stack processing,
        // SC: O(n): stack
        public int largestRectangleArea2(int[] heights) {
            int n = heights.length;
            int max = Integer.MIN_VALUE;

            Stack<Integer> stack = new Stack();
            for (int i = 0; i <= n; i++) {
                while (!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])) {
                    int height = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    max = Math.max(max, height * width);
                }
                stack.push(i);
            }

            return max;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3, 1, 2, 3, 4};
        System.out.println(sol.largestRectangleArea1(heights));
        heights = new int[]{3, 1, 5, 6, 2, 3};
        System.out.println(sol.largestRectangleArea2(heights));
    }
}

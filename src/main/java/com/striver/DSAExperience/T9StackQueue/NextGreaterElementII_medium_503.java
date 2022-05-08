package com.striver.DSAExperience.T9StackQueue;

import com.common.Out;

import java.util.Stack;

public class NextGreaterElementII_medium_503 {
    static class Solution {
        // array work as circular linkedlist
        // [Optimal] TC: O(2n*K) or O(n), SC: O(n) - 2n is for looping the twice of n and
        // K is deletion from stack until greater element found
        public int[] nextGreaterElements(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            int n = nums.length;
            int[] nge = new int[n];
            for (int i = 2 * n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() <= nums[i % n]) stack.pop();
                if (i < n) // storing nge is only for [0 to n-1] index array
                    nge[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums[i % n]);
            }
            return nge;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6};
        int[] res = sol.nextGreaterElements(nums);
        Out.print(res);
    }
}

package com.striver.DSAExperience.T10StackQueue;

import com.common.Out;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum_hard_239 {
    static class Solution {
        // [Optimal] TC: O(2n) = O(n): O(n) + O(n) - iteration of original array and
        // perform deletion of out of bound index which is greater than K
        // SC: O(k): result array
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> dq = new ArrayDeque<>();
            int n = nums.length;
            int[] res = new int[n - k + 1];
            int rid = 0;
            for (int i = 0; i < n; i++) {
                while (!dq.isEmpty() && dq.peek() <= i - k) dq.poll();
                while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
                dq.offer(i);
                if (i >= k - 1)
                    res[rid++] = nums[dq.peek()];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = sol.maxSlidingWindow(nums, k);
        Out.print(res);
    }
}

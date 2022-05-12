package pratice.leetcode.prev.facebook.hard;

import pratice.common.Out;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK_862 {
    static class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length, res = n + 1;
            long[] prefixSum = new long[n + 1];

            for (int i = 0; i < n; i++) prefixSum[i + 1] = nums[i] + prefixSum[i];
            Deque<Integer> d = new ArrayDeque<>();

            for (int i = 0; i < n + 1; i++) {
                while (!d.isEmpty() && prefixSum[i] - prefixSum[d.getFirst()] >= k)
                    res = Math.min(res, i - d.pollFirst());
                while (!d.isEmpty() && prefixSum[i] <= prefixSum[d.getLast()])
                    d.pollLast();
                d.addLast(i);
            }
            return res <= n ? res : -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {10, 2, -2, -20, -10};
        int k = 1;
        Out.print(sol.shortestSubarray(nums, k));
    }
}

package com.striver.DSAExperience.T14DP.OneD_OnSubsequence;

import com.common.Out;

public class HouseRobber2 {
    // [Better DP: Tab] TC: O(N), O(1): Running a simple iterative loop, two times.
    // Therefore, total time complexity will be O(N) + O(N) ≈ O(N)
    public static long houseRobber(int[] valueInHouse) {
        int n = valueInHouse.length;
        if (n == 0) return 0;
        if (n == 1) return valueInHouse[0];

        return Math.max(maxNonAdjSum(valueInHouse, 0, n - 1),
                maxNonAdjSum(valueInHouse, 1, n));
    }

    private static long maxNonAdjSum(int[] nums, int start, int end) {
        long prev1 = nums[start];
        long prev2 = 0;

        for (int i = start + 1; i < end; i++) {
            long curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    // [Better DP: Tab] TC: O(N): Running a simple iterative loop, two times.
    // Therefore, total time complexity will be O(N) + O(N) ≈ O(N)
    // SC: O(N): create two array first without first element and second without last element
    public static long houseRobber2(int[] valueInHouse) {
        int n = valueInHouse.length;
        if (n == 0) return 0;
        if (n == 1) return valueInHouse[0];

        int id1 = 0, id2 = 0;
        int[] post = new int[n - 1];
        int[] pre = new int[n - 1];
        for (int i = 0; i < n; i++) {
            if (i != 0)
                post[id1++] = valueInHouse[i];
            if (i != n - 1)
                pre[id2++] = valueInHouse[i];
        }
        return Math.max(maxNonAdjSum(post),
                maxNonAdjSum(pre));
    }

    private static long maxNonAdjSum(int[] nums) {
        long prev1 = nums[0];
        long prev2 = 0;

        for (int i = 1; i < nums.length; i++) {
            long curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] valueInHouse = {1, 3, 8};
        Out.print(houseRobber(valueInHouse));
    }
}

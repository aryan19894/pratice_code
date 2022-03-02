package com.striver.DSAExperience.T14DP;

import com.common.Out;

public class HouseRobber {
    public static long houseRobber(int[] valueInHouse) {
        int n = valueInHouse.length;
        if (n == 0) return 0;
        if (n == 1) return valueInHouse[0];

        return Math.max(maxNonAdjSum(valueInHouse, 0, n - 1),
                maxNonAdjSum(valueInHouse, 1, n));
    }

    private static int maxNonAdjSum(int[] nums, int start, int end) {
        int prev1 = nums[start];
        int prev2 = 0;

        for (int i = start + 1; i < end; i++) {
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] valueInHouse = {1,3,2,};
        Out.print(houseRobber(valueInHouse));
    }
}

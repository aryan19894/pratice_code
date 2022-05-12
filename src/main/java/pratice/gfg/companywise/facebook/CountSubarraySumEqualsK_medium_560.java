package pratice.gfg.companywise.facebook;

import pratice.common.Out;

import java.util.HashMap;

public class CountSubarraySumEqualsK_medium_560 {
    static class Solution {
        // [Optimal] O(n) - we storing the target-sum as key to map with its frequency - how many times it is calculated
        public int subarraySum(int[] arr, int k) {
            int result = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);

            int currSum = 0;
            for (int i = 0; i < arr.length; i++) {
                currSum += arr[i];

                result += map.getOrDefault(currSum - k, 0);

                map.put(currSum, map.getOrDefault(currSum, 0) + 1);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        int k = 8;
        Out.print(sol.subarraySum(nums, k));
    }
}

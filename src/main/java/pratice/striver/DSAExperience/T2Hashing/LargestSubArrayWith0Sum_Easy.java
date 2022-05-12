package pratice.striver.DSAExperience.T2Hashing;

import java.util.HashMap;

public class LargestSubArrayWith0Sum_Easy {
    static class Solution {
        // [Brute] O(n3) - find each subarray and verify its sum
        // [Optimal] TC: O(nlogn), SC: O(n) - work with hashmap
        int maxLen1(int arr[], int n) {
            int max = 0, sum = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum == 0)
                    max = i + 1;
                else if (map.containsKey(sum))
                    max = Math.max(max, (i - map.get(sum)));
                else
                    map.put(sum, i);
            }
            return max;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, -1, 3, 2, -2, -8, 1, 7, 10, 23};
        System.out.println(sol.maxLen1(nums, nums.length));
    }
}

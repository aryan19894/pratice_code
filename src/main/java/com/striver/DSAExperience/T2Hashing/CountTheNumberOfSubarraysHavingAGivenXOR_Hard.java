package com.striver.DSAExperience.T2Hashing;

import java.util.HashMap;

public class CountTheNumberOfSubarraysHavingAGivenXOR_Hard {
    static class Solution {
        // [Brute] O(n3) - find each subarray and verify its xor value
        // [Optimal] TC: O(nlogn), SC: O(n) - work with hashmap freq
        static long subarrayXor1(int arr[], int n, int m) {
            int count = 0, xor = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                xor ^= arr[i];
                int y = xor ^ m;
                if (map.containsKey(y))
                    count += map.get(y);
                if (xor == m)
                    count++;
                map.putIfAbsent(xor, 0);
                map.put(xor, map.get(xor) + 1);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 2, 2, 6, 4};
        System.out.println(sol.subarrayXor1(nums, nums.length, 6));
    }
}

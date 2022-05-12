package pratice.striver.DSAExperience.T2Hashing;/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start

import pratice.common.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_medium_18 {
    static class Solution {
        // [Brute] O(n3logn) - sort the array use 3pointer technique and perform binary search
        public List<List<Integer>> fourSum1(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            int n = nums.length;
            if (nums == null || nums.length == 0)
                return res;
            Arrays.sort(nums);

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        int[] right = Arrays.copyOfRange(nums, k + 1, n);
                        int l = Arrays.binarySearch(right, target - (nums[i] + nums[j] + nums[k]));
                        if (l >= 0 && l < right.length) {
                            List<Integer> ref = new ArrayList<>();
                            ref.add(nums[i]);
                            ref.add(nums[j]);
                            ref.add(nums[k]);
                            ref.add(right[l]);
                            res.add(ref);
                        }
                        while (k + 1 < n && nums[k] == nums[k + 1])
                            k++;
                    }
                    while (j + 1 < n && nums[j] == nums[j + 1])
                        j++;
                }
                while (i + 1 < n && nums[i] == nums[i + 1])
                    i++;
            }
            return res;
        }

        // [Better] O(n3) - sort the array use 2pointer technique and left adn right search rule
        public List<List<Integer>> fourSum2(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (nums == null || nums.length == 0)
                return res;

            int n = nums.length;

            Arrays.sort(nums);

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int left = j + 1;
                    int right = n - 1;
                    int remain = target - (nums[i] + nums[j]);

                    while (left < right) {
                        int sum = nums[left] + nums[right];
                        if (sum < remain) left++;
                        else if (sum > remain) right--;
                        else {
                            List<Integer> ref = new ArrayList<>();
                            ref.add(nums[i]);
                            ref.add(nums[j]);
                            ref.add(nums[left]);
                            ref.add(nums[right]);
                            res.add(ref);

                            //Processing the duplicates of number2
                            while (left < right && nums[left] == ref.get(2)) left++;
                            //Processing the duplicates of number4
                            while (left < right && nums[right] == ref.get(3)) right--;
                        }
                    }
                    while (j + 1 < n && nums[j] == nums[j + 1])
                        j++;
                }
                while (i + 1 < n && nums[i] == nums[i + 1])
                    i++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        Out.print(sol.fourSum1(nums, 9));
        System.out.println("----");
        Out.print(sol.fourSum2(nums, 9));
    }
}

// @lc code=end


package pratice.striver.DSAExperience.T1Array;/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 */

import pratice.common.Obj;

import java.util.ArrayList;
import java.util.Arrays;

// @lc code=start
public class ReversePairs_hard_493 {
    static class Solution {
        // [Brute] O(n2) - check each and every pairs which is following the reverse pair rule
        public int reversePairs1(int[] nums) {
            int count = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] > 2 * (long) nums[j])
                        count++;
                }
            }
            return count;
        }

        // [Better] O(nlogn) - merge sort inversion rule - count inversions using merge sort
        public int reversePairs2(int[] nums) {
            return mergeSort(nums, 0, nums.length - 1);
        }

        private int mergeSort(int[] nums, int low, int high) {
            if (low >= high) return 0;
            int mid = (low + high) / 2;
            int inv = mergeSort(nums, low, mid);
            inv += mergeSort(nums, mid + 1, high);

            inv += merge(nums, low, mid, high);
            return inv;
        }

        private int merge(int[] nums, int low, int mid, int high) {
            int count = 0;
            int j = mid + 1;
            for (int i = low; i <= mid; i++) {
                while (j <= high && (nums[i] > 2 * (long) nums[j]))
                    j++;
                count += (j - (mid + 1));
            }

            ArrayList<Integer> temp = new ArrayList<>();
            int left = low;
            int right = mid + 1;
            while (left <= mid && right <= high) {
                if (nums[left] <= nums[right])
                    temp.add(nums[left++]);
                else
                    temp.add(nums[right++]);
            }

            while (left <= mid)
                temp.add(nums[left++]);

            while (right <= high)
                temp.add(nums[right++]);

            for (int i = low; i <= high; i++)
                nums[i] = temp.get(i - low);

            return count;
        }

        // [Better] O(nlogn) - merge sort inversion rule - count inversions using merge sort
        public int reversePairs3(int[] nums) {
            return mergeSort3(nums, 0, nums.length - 1);
        }

        private int mergeSort3(int[] nums, int low, int high) {
            if (low >= high) return 0;
            int mid = low + (high - low) / 2;
            int inv = mergeSort(nums, low, mid) + mergeSort(nums, mid + 1, high);

            for (int i = low, j = mid + 1; i <= mid; i++) {
                while (j <= high && (nums[i] > 2 * (long) nums[j]))
                    j++;
                inv += (j - (mid + 1));
            }
            Arrays.sort(nums, low, high + 1);
            return inv;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        System.out.println(sol.reversePairs1(nums));
        System.out.println(sol.reversePairs2(nums));
        System.out.println(sol.reversePairs3(nums));
    }
}

// @lc code=end


package com.striver.DSAExperience.Day11BinarySearch;

public class SearchInRotatedSortedArray_medium_33 {
    static class Solution {
        // [Basic] TC: O(n), SC: O(1) - perform linear search and check

        // [Optimal] TC: O(logn), SC: O(1) - using binary search
        // we check whether which side is sorted w.r.t mid-element
        public int search(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;

            while (low <= high) {
                int mid = (low + high) >> 1;
                if (nums[mid] == target) return mid;

                //check left half sorted
                if (nums[low] <= nums[mid]) {
                    if (target >= nums[low] && target <= nums[mid])
                        high = mid - 1;
                    else
                        low = mid + 1;
                } else {
                    if (target >= nums[mid] && target <= nums[high])
                        low = mid + 1;
                    else
                        high = mid - 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 5;
        System.out.println(sol.search(nums, target));
    }
}


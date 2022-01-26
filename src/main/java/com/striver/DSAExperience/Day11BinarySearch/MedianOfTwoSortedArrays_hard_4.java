package com.striver.DSAExperience.Day11BinarySearch;

public class MedianOfTwoSortedArrays_hard_4 {
    static class Solution {
        // [Basic] TC: O(n1+n2), SC: O(n1+n2) - merge two sorted array then find median of element

        // [Optimal] TC: O(log(min(n1, n2))), SC: O(1) - using binary search
        // we are finding the left half of both array and check at what point it following the rule
        // left1 <= right2 && left2 <= right1
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);

            int n1 = nums1.length, n2 = nums2.length;
            int low = 0, high = n1;

            while (low <= high) {
                int cut1 = (low + high) >> 1;
                int cut2 = (n1 + n2 + 1) / 2 - cut1;

                int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
                int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

                int r1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
                int r2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

                if (l1 <= r2 && l2 <= r1) {
                    if ((n1 + n2) % 2 == 0)
                        return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                    else
                        return Math.max(l1, l2);
                } else if (l1 > r2)
                    high = cut1 - 1;
                else
                    low = cut1 + 1;
            }
            return 0.0;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }
}

package com.striver.DSAExperience.T5BinarySearch;

public class KthElementOfTwoSortedArrays_Easy {
    // [Basic] TC: O(k), SC: O(1) - following the rule of merge two sorted array then find kth of element
    public static long kthElement1(int arr1[], int arr2[], int n, int m, int k) {
        int l1 = 0, l2 = l1;
        int cnt = 0;
        long ele = arr1[l1];
        while (l1 < n && l2 < m) {
            if (arr1[l1] <= arr2[l2]) {
                ele = arr1[l1];
                l1++;
            } else {
                ele = arr2[l2];
                l2++;
            }
            if (cnt == k)
                return ele;
            cnt++;
        }

        return (l1 < n) ? arr1[l1 + k - cnt - 1] : arr2[l2 + k - cnt - 1];
    }

    // [Optimal] TC: O(log(min(m, n))), SC: O(1) - using binary search
    // we are finding the left half of both array and check at what point it following the rule
    // left1 <= right2 && left2 <= right1
    public static long kthElement2(int nums1[], int nums2[], int n1, int n2, int k) {
        if (n2 < n1) return kthElement2(nums2, nums1, n2, n1, k);

        int low = Math.max(0, k - n2), high = Math.min(k, n1);

        while (low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = k - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int r1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2)
                high = cut1 - 1;
            else
                low = cut1 + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums2 = {1, 3, 5};
        int[] nums1 = {2, 2, 4, 32, 33, 39, 48, 68, 82, 88, 90};
        System.out.println(kthElement1(nums1, nums2, nums1.length, nums2.length, 8));
        System.out.println(kthElement2(nums1, nums2, nums1.length, nums2.length, 8));
    }
}

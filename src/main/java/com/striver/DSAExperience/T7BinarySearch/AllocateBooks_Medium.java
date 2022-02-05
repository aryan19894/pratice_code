package com.striver.DSAExperience.T7BinarySearch;

import com.common.Array;

import java.util.ArrayList;

public class AllocateBooks_Medium {
    // [Optimal] TC: O(logn*N), SC: O(1) - using binary search
    // logN - while loop filtering the mid index
    // N is for checking possibility of allocations
    public static int books(ArrayList<Integer> A, int B) {
        if (B > A.size()) return -1;
        int low = A.get(0);
        int high = 0;
        for (int a : A) {
            low = Math.min(low, a);
            high += a;
        }
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (allocationPossible(A, mid, B))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    private static boolean allocationPossible(ArrayList<Integer> a, int pages, int students) {
        int count = 0, sumAllocated = 0;
        for (int i = 0; i < a.size(); i++) {
            int ele = a.get(i);

            if (ele > pages) return false;
            if (sumAllocated + ele > pages) {
                count++;
                sumAllocated = ele;
                if (sumAllocated > pages) return false;
            } else
                sumAllocated += ele;
        }
        if (count >= students) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {12, 34, 67, 90};
        System.out.println(books(Array.toList(nums), 2));
    }
}

package com.striver.DSAExperience.T7BinarySearch;

import com.common.Array;

import java.util.ArrayList;

public class MatrixMedian_Medium {
    // [Optimal] TC: O(log2pow32*N*logM) = O(32*N*logM)
    // log2pow32 - the largest integer number - consider as 32
    // N is row - find all smaller element of each mid from row
    // logM - perform binary on each column of each row.
    // SC: O(1)
    public static int findMedian(ArrayList<ArrayList<Integer>> A) {
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;
        int n = A.size();
        int m = A.get(0).size();

        while (low <= high) {
            int mid = (high + low) >> 1;
            int count = 0;
            for (int i = 0; i < n; i++)
                count += countSmallerEle(A.get(i), mid);

            if (count <= (n * m) / 2) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    private static int countSmallerEle(ArrayList<Integer> row, int mid) {
        int l = 0, h = row.size() - 1;
        while (l <= h) {
            int md = (l + h) >> 1;
            if (row.get(md) <= mid)
                l = md + 1;
            else
                h = md - 1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}};
        System.out.println(findMedian(Array.toList(nums)));
    }
}

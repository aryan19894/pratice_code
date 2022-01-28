package com.striver.DSAExperience.T7BinarySearch;

import java.util.Arrays;

public class AggressiveCows_Medium {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 9};
        int cows = 3;
        System.out.println(largestMinDistance(arr, cows));
    }

    // [Optimal] TC: O(logn*N), SC: O(1) - using binary search
    // logN - while loop filtering the mid index
    // N is for checking possibility of cow allocations
    private static int largestMinDistance(int[] arr, int cows) {
        int n = arr.length;
        if (cows > n) return -1;

        Arrays.sort(arr);
        int low = 1;
        int high = arr[n-1] - arr[0];

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (isPossible(arr, mid, cows)) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return high;
    }

    private static boolean isPossible(int[] arr, int mid, int cows) {
        int cnt = 1;
        int c1 = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - c1 >= mid) {
                cnt++;
                c1 = arr[i];
            }

            if(cnt == cows) return true;
        }
        return false;
    }
}

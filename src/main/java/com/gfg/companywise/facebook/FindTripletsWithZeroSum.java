package com.gfg.companywise.facebook;

import com.common.Out;

import java.util.Arrays;

public class FindTripletsWithZeroSum {
    static public class Solution {
        public boolean findTriplets(int arr[], int n) {
            Arrays.sort(arr);
            for (int i = 0; i < n; i++) {
                int left = i + 1;
                int right = n - 1;
                int remain = -1 * arr[i];
                while (left < right) {
                    int sum = arr[left] + arr[right];
                    if (sum == remain) return true;
                    else if (sum < remain) left++;
                    else right--;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {1, 2, 3};
        int n = 5;
        Out.print(sol.findTriplets(arr, 3));
    }
}

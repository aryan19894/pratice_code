package com.striver.DSAExperience.Day8Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MinimumPlatforms_Medium {
    // [Optimal] O(2nlogn)+O(2n), O(1) - 2nlogn - for sorting both arrays and O(2n)- for 2pointer traversal
    // will check 1by1 traversal with depature value
    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platform = 1, max = 1;

        int i = 1, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platform++;
                i++;
            } else {
                platform--;
                j++;
            }
            max = Math.max(max, platform);
        }

        return max;
    }

    public static void main(String[] args) {
        int arr[] = {120, 50, 550, 200, 700, 850};
        int dep[] = {600, 550, 700, 500, 900, 1000};

        int ans = findPlatform(arr, dep, arr.length);
        System.out.println(ans);
    }
}

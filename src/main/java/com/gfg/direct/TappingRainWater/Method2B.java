package com.gfg.direct.TappingRainWater;

import java.util.Scanner;

public class Method2B {
    public Method2B() {
    }

    static int findWater(int[] arr, int n) {
        int result = 0;
        int left_max = 0;
        int right_max = 0;
        int lo = 0;
        int hi = n - 1;

        while(lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > left_max) {
                    left_max = arr[lo];
                } else {
                    result += left_max - arr[lo];
                }

                ++lo;
            } else {
                if (arr[hi] > right_max) {
                    right_max = arr[hi];
                } else {
                    result += right_max - arr[hi];
                }

                --hi;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int j = 0; j < t; ++j) {
            int n = in.nextInt();
            int[] a = new int[n];

            int ans;
            for(ans = 0; ans < n; ++ans) {
                a[ans] = in.nextInt();
            }

            ans = findWater(a, a.length);
            System.out.println(ans);
        }

    }
}

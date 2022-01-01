package com.gfg.direct.TappingRainWater;

import java.util.Scanner;

public class Method2A {
    public Method2A() {
    }

    static int findWater(int[] arr, int n) {
        int[] left = new int[n];
        int[] right = new int[n];
        int water = 0;
        left[0] = arr[0];

        int i;
        for(i = 1; i < n; ++i) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        right[n - 1] = arr[n - 1];

        for(i = n - 2; i >= 0; --i) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        for(i = 0; i < n; ++i) {
            water += Math.min(left[i], right[i]) - arr[i];
        }

        return water;
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

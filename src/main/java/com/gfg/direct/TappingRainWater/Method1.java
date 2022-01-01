package com.gfg.direct.TappingRainWater;

import java.util.Scanner;

public class Method1 {
    public Method1() {
    }

    static int findWater(int[] arr, int n) {
        int res = 0;

        for(int i = 1; i < n - 1; ++i) {
            int l = arr[i];

            int r;
            for(r = 0; r < i; ++r) {
                l = Math.max(l, arr[r]);
            }

            r = arr[i];

            for(int j = i; j < n; ++j) {
                r = Math.max(r, arr[j]);
            }

            res += Math.min(l, r) - arr[i];
        }

        return res;
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

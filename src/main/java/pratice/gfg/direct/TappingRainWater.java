package pratice.gfg.direct;

import java.util.Scanner;

public class TappingRainWater {
    static int findWater1(int[] arr, int n) {
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

    static int findWater2(int[] arr, int n) {
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

    static int findWater3(int[] arr, int n) {
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

            System.out.println(findWater1(a, a.length));
            System.out.println(findWater2(a, a.length));
            System.out.println(findWater3(a, a.length));
        }
    }
}

package com.gfg.companywise.amazon;

import com.common.Out;
import com.common.converter.Array;

import java.util.Arrays;

public class LargestNumberFormedFromAnArray {
    static public class Solution {
        String printLargest(String[] arr) {
            Arrays.sort(arr, (a, b) -> {
                String x = a + b, y = b + a;
                return y.compareTo(x);
            });
            StringBuilder sb = new StringBuilder();
            for (String a : arr)
                sb.append(a);
            return new String(sb);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] arr = Array.toString(new Integer[]{54, 546, 548, 60});
        Out.print(sol.printLargest(arr));
    }
}

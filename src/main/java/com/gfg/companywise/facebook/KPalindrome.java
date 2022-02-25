package com.gfg.companywise.facebook;

import com.common.Out;

public class KPalindrome {
    static public class Solution {
        boolean is_k_palin(String str, int k) {
            int n = str.length();
            if (n <= 1) return true;
            int start = 0, end = n - 1;
            while (start <= end) {
                if (str.charAt(start) != str.charAt(end)) {
                    if (k > 0) {
                        k--;
                        if (str.charAt(start) == str.charAt(end-1))
                            start--;
                        else end++;
                    } else return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String str = "acddc";
        int k = 1;
        Out.print(sol.is_k_palin(str, k));
    }
}

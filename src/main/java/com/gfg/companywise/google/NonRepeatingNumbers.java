package com.gfg.companywise.google;

import com.common.Out;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class NonRepeatingNumbers {
    static public class Solution {
        // [Better] O(NlogN), O(N) - use map, it will first insert and then will remove when it contains
        public int[] singleNumber(int[] nums) {
            Set<Integer> set = new LinkedHashSet<>();
            for (int n : nums) {
                if (set.contains(n))
                    set.remove(n);
                else set.add(n);
            }
            int[] res = new int[set.size()];
            int i = 0;
            for (int s : set)
                res[i++] = s;
            Arrays.sort(res);
            return res;
        }

        // [Better] O(N), O(1) - XOR technique
        public int[] singleNumber2(int[] nums) {
            int sum = 0;
            for (int n : nums)
                sum ^= n;

            sum &= -sum;

            int n1 = 0, n2 = 0;
            for (int n : nums) {
                if ((sum & n) > 0)
                    n1 ^= n;
                else
                    n2 ^= n;
            }
            int[] res = {n1, n2};
            Arrays.sort(res);
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {18, 24, 24, 21, 10, 29, 8, 10, 29, 18};
        //Out.print(sol.singleNumber(nums));
        Out.print(sol.singleNumber2(nums));
    }
}

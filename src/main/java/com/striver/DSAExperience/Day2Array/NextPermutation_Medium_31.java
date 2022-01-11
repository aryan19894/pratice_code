// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NextPermutation_Medium_31.java

package com.striver.DSAExperience.Day2Array;

import com.common.Obj;
import com.common.Printer;

public class NextPermutation_Medium_31
{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[]{1, 3, 5, 4, 2};
        sol.nextPermutation(nums);
        Printer.print(nums);
    }

    static class Solution {
        Solution() {
        }

        public void nextPermutation(int[] nums) {
            int n = nums.length;
            if (nums != null && n > 1) {
                int i;
                for(i = n - 2; i >= 0 && nums[i] >= nums[i + 1]; --i) {
                }

                if (i >= 0) {
                    int j;
                    for(j = n - 1; nums[j] <= nums[i]; --j) {
                    }

                    Obj.swap(nums, i, j);
                }

                reverse(nums, i + 1, n - 1);
            }
        }

        public static void reverse(int[] a, int i, int j) {
            while(i < j) {
                Obj.swap(a, i++, j--);
            }

        }
    }
}

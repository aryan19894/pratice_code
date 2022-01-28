// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MergeIntervals_Medium_56.java

package com.striver.DSAExperience.T1Array;

import com.common.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_Medium_56 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] nums = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ans = sol.merge2(nums);
        Printer.printWithIndex(ans, true);
    }

    static class Solution {
        Solution() {
        }

        public int[][] merge1(int[][] nums) {
            int n = nums.length;
            List<int[]> res = new ArrayList();
            if (nums != null && n != 0) {
                boolean[] merge = new boolean[n];

                int i;
                for (i = 0; i < n - 1; ++i) {
                    for (int j = i + 1; j < n; ++j) {
                        merge[i] = merge[i] || this.merge(nums[i], nums[j]);
                    }
                }

                for (i = 0; i < n; ++i) {
                    if (!merge[i]) {
                        res.add(nums[i]);
                    }
                }

                return (int[][]) res.toArray(new int[0][]);
            } else {
                return (int[][]) res.toArray(new int[0][]);
            }
        }

        private boolean merge(int[] A, int[] B) {
            if (A[1] >= B[0] && B[1] >= A[0]) {
                B[0] = Math.min(A[0], B[0]);
                B[1] = Math.max(A[1], B[1]);
                return true;
            } else {
                return false;
            }
        }

        public int[][] merge2(int[][] nums) {
            int n = nums.length;
            List<int[]> res = new ArrayList();
            if (nums != null && n != 0) {
                Arrays.sort(nums, (a, b) -> {
                    return a[0] - b[0];
                });
                int start = nums[0][0];
                int end = nums[0][1];
                int[][] var6 = nums;
                int var7 = nums.length;

                for (int var8 = 0; var8 < var7; ++var8) {
                    int[] i = var6[var8];
                    if (i[0] <= end) {
                        end = Math.max(end, i[1]);
                    } else {
                        res.add(new int[]{start, end});
                        start = i[0];
                        end = i[1];
                    }
                }

                res.add(new int[]{start, end});
                return (int[][]) res.toArray(new int[0][]);
            } else {
                return (int[][]) res.toArray(new int[0][]);
            }
        }
    }
}

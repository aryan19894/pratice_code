// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PascalsTriangle_118.java

package com.striver.DSAExperience.T1Array;

import com.common.Out;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_Easy_118 {
    static class Solution {

        public List generate(int numRows) {
            List res = new ArrayList();
            List pre = null;
            for (int i = 0; i < numRows; i++) {
                List row = new ArrayList();
                for (int j = 0; j <= i; j++)
                    if (j == 0 || j == i)
                        row.add(Integer.valueOf(1));
                    else
                        row.add(Integer.valueOf(((Integer) pre.get(j - 1)).intValue() + ((Integer) pre.get(j)).intValue()));

                pre = row;
                res.add(row);
            }

            return res;
        }

        Solution() {
        }
    }


    public static void main(String args[]) {
        Solution sol = new Solution();
        List ans = sol.generate(8);
        Out.print(ans);
    }
}

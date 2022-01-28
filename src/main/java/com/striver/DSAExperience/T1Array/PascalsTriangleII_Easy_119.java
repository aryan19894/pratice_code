// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PascalsTriangleIi_119.java

package com.striver.DSAExperience.T1Array;

import com.common.Printer;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII_Easy_119 {
    static class Solution {

        public List getRow(int rowIndex) {
            int val = 1;
            long factor = 1L;
            List row = new ArrayList();
            for (int i = 0; i <= rowIndex; i++) {
                row.add(Integer.valueOf(val));
                factor *= rowIndex - i;
                factor /= i + 1;
                val = (int) factor;
            }

            return row;
        }

        Solution() {
        }
    }


    public static void main(String args[]) {
        Solution sol = new Solution();
        List ans = sol.getRow(4);
        Printer.print(ans);
    }
}

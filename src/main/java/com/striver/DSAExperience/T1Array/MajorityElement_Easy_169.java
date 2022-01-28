// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MajorityElement_169.java

package com.striver.DSAExperience.T1Array;

import java.io.PrintStream;
import java.util.*;

public class MajorityElement_Easy_169 {
    static class Solution {

        public int majorityElement1(int nums[]) {
            Map map = new HashMap();
            int floor = nums.length / 2;
            for (int i = 0; i < nums.length; i++) {
                int ele = nums[i];
                map.putIfAbsent(Integer.valueOf(ele), Integer.valueOf(0));
                map.put(Integer.valueOf(ele), Integer.valueOf(((Integer) map.get(Integer.valueOf(ele))).intValue() + 1));
                if (((Integer) map.get(Integer.valueOf(ele))).intValue() > floor)
                    return ele;
            }

            for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
                java.util.Map.Entry e = (java.util.Map.Entry) iterator.next();
                if (((Integer) e.getValue()).intValue() > floor)
                    return ((Integer) e.getKey()).intValue();
            }

            return -1;
        }

        public int majorityElement2(int nums[]) {
            int count = 0;
            int ele = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (count == 0)
                    ele = nums[i];
                if (ele == nums[i])
                    count++;
                else
                    count--;
            }

            return ele;
        }

        public int majorityElement3(int nums[]) {
            int count = 1;
            int ele = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (ele == nums[i]) {
                    count++;
                    continue;
                }
                if (--count == 0) {
                    i++;
                    ele = nums[i];
                    count = 1;
                }
            }

            return ele;
        }

        Solution() {
        }
    }


    public static void main(String args[]) {
        Solution sol = new Solution();
        int nums[] = {
                2, 2, 1, 1, 1, 2, 2
        };
        System.out.println(sol.majorityElement3(nums));
    }
}

package com.common;

import java.util.ArrayList;

public class Converter {
    public static ArrayList<ArrayList<Integer>> toList(int[][] nums) {
        ArrayList<ArrayList<Integer>> ref = new ArrayList<ArrayList<Integer>>();
        for (int[] num : nums) {
            ArrayList<Integer> r = new ArrayList<Integer>();
            for (int n : num) {
                r = new ArrayList<Integer>();
                r.add(n);
            }
            ref.add(r);
        }
        return ref;
    }

//    public static int[] range(int n) {
//        int[] a = new int[n];
//        for()
//    }
}

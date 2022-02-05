package com.common;

import java.util.ArrayList;

public class Arrays {
    public static ArrayList<ArrayList<Integer>> toList(int[][] nums) {
        ArrayList<ArrayList<Integer>> ref = new ArrayList<ArrayList<Integer>>();
        for (int[] num : nums)
            ref.add(toList(num));

        return ref;
    }

    public static ArrayList<Integer> toList(int[] nums) {
        ArrayList<Integer> ref = new ArrayList<>();
        for (int num : nums) {
            ref.add(num);
        }
        return ref;
    }

    public static Integer[] toInteger(String[] input) {
        Integer[] ref = new Integer[input.length];
        int i = 0;
        for (String ip : input)
            ref[i++] = ip == null ? null : Integer.parseInt(ip);
        return ref;
    }
}

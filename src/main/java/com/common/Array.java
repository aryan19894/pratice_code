package com.common;

import java.util.ArrayList;

public class Array {
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
        for (String ip : input) {
            if (ip == null || ip.equals("null") ||
                    ip.toLowerCase().equals("n") ||
                    ip.equals("-1"))
                ref[i++] = null;
            else
                ref[i++] = Integer.parseInt(ip);
        }
        return ref;
    }

    public static String[] toString(Integer[] input) {
        String[] ref = new String[input.length];
        int i = 0;
        for (Integer ip : input)
            ref[i++] = String.valueOf(ip);
        return ref;
    }

}

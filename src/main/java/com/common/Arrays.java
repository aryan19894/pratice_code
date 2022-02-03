package com.common;

import com.striver.DSAExperience.T12Tree.Node;
import com.striver.DSAExperience.T12Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

}

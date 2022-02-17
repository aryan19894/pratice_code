package com.striver.DSAExperience.T13Graph;

import com.common.converter.Array;

import java.util.ArrayList;

public class ArticulationPoint_CutVertex_Medium {
    private static void articPoint(int i, ArrayList<ArrayList<Integer>> adj) {

    }

    public static void main(String[] args) {
        int[][] graph = {{},
                {2, 4},
                {1, 3},
                {2, 4},
                {1, 3, 5},
                {4, 6},
                {5, 7, 9},
                {6, 8},
                {7, 9, 10},
                {6, 8},
                {8, 11, 12},
                {10, 12},
                {10}
        };

        articPoint(13, Array.toList(graph));
    }
}

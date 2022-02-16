package com.common.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    public static HashMap<Integer, List<Integer>> toAdjMap(int[] parent) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < parent.length; i++) {
            if (parent[i] != i && parent[i] != 0) {
                map.putIfAbsent(parent[i], new ArrayList<>());
                map.get(parent[i]).add(i);
            }
        }
        return map;
    }

    public static ArrayList<ArrayList<ArrayList<Integer>>> toEdgeList(int V, int[][] weightedGraph) {
        ArrayList<ArrayList<ArrayList<Integer>>> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>>[] res = new ArrayList[V];

        for (int i = 0; i < V; i++)
            res[i] = new ArrayList<>();

        for (int[] g : weightedGraph) {
            ArrayList<Integer> a = new ArrayList<>();
            a.add(g[1]);
            a.add(g[2]);
            res[g[0]].add(a);

            a = new ArrayList<>();
            a.add(g[0]);
            a.add(g[2]);
            res[g[1]].add(a);
        }
        for (ArrayList<ArrayList<Integer>> r : res)
            result.add(r);

        return result;
    }


}

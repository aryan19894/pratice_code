package com.striver.DSAExperience.T13Graph;

import com.common.Out;
import com.common.converter.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort_DFS_Medium {
    // [Optimal] TC: O(N + E), N = Number of node , E = Number of Edges
    // SC: O(N) + O(N), Visited Array and Stack data structure. Both will be using O(N).
    // ASC: O(N) - Recursion call of DFS
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] res = new int[V];
        boolean[] visited = new boolean[V];
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfsTopo(i, adj, list, visited);
        }

        int i = 0;
        for (int e : list)
            res[i++] = e;

        return res;
    }

    private static void dfsTopo(int i, ArrayList<ArrayList<Integer>> adj,
                                LinkedList<Integer> list, boolean[] visited) {
        visited[i] = true;
        for (int child : adj.get(i)) {
            if (!visited[child])
                dfsTopo(child, adj, list, visited);
        }
        list.add(0, i);
    }

    public static void main(String[] args) {
        int[][] graph = {{}, {}, {3}, {1}, {0, 1}, {0, 2}};
        //int[][] graph = {{}};
        Out.print(topoSort(graph.length, Array.toList(graph)));
    }
}

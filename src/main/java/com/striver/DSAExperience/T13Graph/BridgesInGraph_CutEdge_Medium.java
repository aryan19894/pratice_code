package com.striver.DSAExperience.T13Graph;

import com.common.converter.Array;

import java.util.ArrayList;

public class BridgesInGraph_CutEdge_Medium {
    // [Optimal] TC: O(N+E) - Where N is the time taken for visiting N nodes and
    // E is for travelling through adjacent nodes.
    // SC: O(N) + O(N) - insertion time array, the lowest insertion time array
    // ASC: O(N) - Recursion call of DFS
    private static void findBridge(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] tin = new int[V]; //time of insertion of node
        int[] low = new int[V]; //lowest time of insertion among all its adjacent nodes
        boolean[] visited = new boolean[V];
        int timer = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(i, -1, visited, tin, low, adj, timer);
        }
    }

    private static void dfs(int node, int parent, boolean[] visited, int[] tin, int[] low,
                            ArrayList<ArrayList<Integer>> adj, int timer) {
        visited[node] = true;
        tin[node] = low[node] = timer++;

        for (int child : adj.get(node)) {
            if (child == parent) continue;
            if (!visited[child]) {
                dfs(child, node, visited, tin, low, adj, timer);
                low[node] = Math.min(low[node], low[child]);
                if (low[child] > tin[node])
                    System.out.println(node + "-" + child);
            } else
                low[node] = Math.min(low[node], tin[child]);
        }
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

        findBridge(13, Array.toList(graph));
    }
}

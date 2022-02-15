package com.striver.DSAExperience.T7RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

public class MColoringProblem_Medium {
    // [Optimal Recursive] TC: O(npowM) = M color on each node
    // SC: O(n) + O(n) - auxilliary space it is going to color each node by each color and verify
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m) {
        return solve(i, G, color, G.length, m) ? true : false;
    }

    private static boolean solve(int node, List<Integer>[] G, int[] color,
                                 int n, int m) {
        if (node == n) return true;

        for (int i = 0; i <= m; i++) {
            if (isSafe(G[node], color, i)) {
                color[node] = i;
                if (solve(node + 1, G, color, n, m)) return true;
                color[node] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(List<Integer> gNode, int[] color, int i) {
        for (int it : gNode)
            if (color[it] == i) return true;
        return false;
    }

    public static void main(String[] args) {
        int V = 4, C = 3, E = 5;
        ArrayList<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        int[][] edge = {{0, 1}, {1, 2}, {2, 3}, {3, 0}, {0, 2}};
        for (int i = 0; i < E; i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        boolean ans = graphColoring(graph, new int[V], 0, C);
        System.out.println(ans);
    }
}

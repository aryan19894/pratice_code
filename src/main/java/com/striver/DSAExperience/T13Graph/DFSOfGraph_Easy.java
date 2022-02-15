package com.striver.DSAExperience.T13Graph;

import com.common.Out;
import com.common.converter.Array;

import java.util.ArrayList;

public class DFSOfGraph_Easy {
    static class Solution {
        // 0-based indexing
        // [Optimal] TC: O(N+E) - Where N is the time taken for visiting N nodes and
        // E is for travelling through adjacent nodes.
        // SC: O(N+E) + O(N) + O(N) - Space for adjacency list, visited array, queue data structure
        // Function to return a list containing the DFS traversal of the graph.
        public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            ArrayList<Integer> res = new ArrayList<>();
            boolean[] visited = new boolean[V];
            dfs(0, visited, adj, res);

            return res;
        }

        private void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj,
                         ArrayList<Integer> res) {
            res.add(node);
            visited[node] = true;
            for (int child : adj.get(node))
                if (!visited[child])
                    dfs(child, visited, adj, res);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] nodes = {{1, 2, 4}, {0}, {0}, {4}, {0, 3}};
        //String edges = "0: 1,2,3 | 2: 4";
        Out.print(sol.dfsOfGraph(5, Array.toList(nodes)));
    }
}

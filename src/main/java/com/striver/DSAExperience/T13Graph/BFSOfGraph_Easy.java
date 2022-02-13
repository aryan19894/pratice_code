package com.striver.DSAExperience.T13Graph;

import com.common.Out;
import com.common.converter.Str;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSOfGraph_Easy {
    static class Solution {
        // Breadth-First Search(BFS) : Level Order Traversal
        // 0-based indexing
        // [Optimal] TC: O(N+E) - N = Nodes , E = travelling through adjacent nodes
        // SC: O(N+E) + O(N) + O(N) - Space for adjacency list, visited array, queue data structure
        public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            ArrayList<Integer> res = new ArrayList<>();
            boolean[] visited = new boolean[V];

            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            visited[0] = true;

            while (!q.isEmpty()) {
                int node = q.poll();
                res.add(node);

                for (int child : adj.get(node)) {
                    if (!visited[child]) {
                        visited[child] = true;
                        q.offer(child);
                    }
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String edges = "0: 1,2,3 | 2: 4";
        Out.print(sol.bfsOfGraph(5, Str.toAdjList(5, edges)));
    }
}

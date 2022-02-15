package com.striver.DSAExperience.T13Graph;

import com.common.Out;
import com.common.converter.Array;

import java.util.*;

public class CycleDetectionDirected_BFS {
    static class Solution {
        // Kahn's Algorithm - using reverse process cause cycle can't perform topological sort
        // [Optimal] TC: O(V + E), since in its whole, it is a DFS implementation, V – vertices; E – edges
        // SC: O(V), because, apart from the graph, we have 2 arrays of size V, to store the required information
        public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
            HashMap<Integer, List<Integer>> hash = new HashMap<>();
            int[] inDegree = new int[n + 1];

            for (ArrayList<Integer> e : edges) {
                hash.putIfAbsent(e.get(0), new ArrayList<>());
                hash.get(e.get(0)).add(e.get(1));
                inDegree[e.get(1)]++;
            }

            for (int i = 1; i <= n; i++)
                hash.putIfAbsent(i, new ArrayList<>());


            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0)
                    q.offer(i);
            }

            int cntZeros = 0;
            while (!q.isEmpty()) {
                int node = q.poll();
                cntZeros++;
                for (int child : hash.getOrDefault(node, new ArrayList<>())) {
                    inDegree[child]--;
                    if (inDegree[child] == 0)
                        q.offer(child);
                }
            }
            return cntZeros == n ? false : true;

//            boolean[] vis = new boolean[n + 1];
//            boolean[] dfsVis = new boolean[n + 1];
//            for (int i = 0; i <= n; i++) {
//                if (!vis[i])
//                    if (isCycle(hash, i, vis, dfsVis))
//                        return true;
//            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] graph = {{1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2}, {1, 3}};
        Out.print(sol.detectCycleInDirectedGraph(5, Array.toList(graph)));
    }
}

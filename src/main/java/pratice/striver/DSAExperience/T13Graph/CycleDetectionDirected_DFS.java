package pratice.striver.DSAExperience.T13Graph;

import pratice.common.Out;
import pratice.common.converter.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CycleDetectionDirected_DFS {
    static class Solution {
        // [Optimal] TC: O(V + E), since in its whole, it is a DFS implementation, V – vertices; E – edges
        // SC: O(V), because, apart from the graph, we have 2 arrays of size V, to store the required information
        public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
            HashMap<Integer, List<Integer>> hash = new HashMap<>();

            for (ArrayList<Integer> e : edges) {
                hash.putIfAbsent(e.get(0), new ArrayList<>());
                hash.get(e.get(0)).add(e.get(1));
            }

            boolean[] vis = new boolean[n + 1];
            boolean[] dfsVis = new boolean[n + 1];
            for (int i = 0; i <= n; i++) {
                if (!vis[i])
                    if (isCycle(hash, i, vis, dfsVis))
                        return true;
            }
            return false;
        }

        private static boolean isCycle(HashMap<Integer, List<Integer>> edges, int i,
                                       boolean[] vis, boolean[] dfsVis) {
            vis[i] = dfsVis[i] = true;

            for (int child : edges.getOrDefault(i, new ArrayList<>())) {
                if (!vis[child]) {
                    if (isCycle(edges, child, vis, dfsVis))
                        return true;
                } else if (dfsVis[child]) return true;
            }
            dfsVis[i] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] graph = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        Out.print(sol.detectCycleInDirectedGraph(5, Array.toList(graph)));
    }
}

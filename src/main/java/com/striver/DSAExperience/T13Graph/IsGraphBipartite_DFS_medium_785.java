package com.striver.DSAExperience.T13Graph;

import com.common.Out;

import java.util.Arrays;

public class IsGraphBipartite_DFS_medium_785 {
    static class Solution {
        // [Optimal] TC: O(V + E), since in its whole, it is a DFS implementation, V – vertices; E – edges
        // SC: O(V), because, apart from the graph, we maintain a color array.
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            int[] color = new int[n];
            Arrays.fill(color, -1);

            for (int i = 0; i < n; i++) {
                if (color[i] == -1)
                    if (!dfsCheck(graph, color, i))
                        return false;
            }
            return true;
        }

        private boolean dfsCheck(int[][] graph, int[] color, int i) {
            for (int child : graph[i]) {
				if (color[child] == -1) {
					color[child] = 1 - color[i];
					if (!dfsCheck(graph, color, child)) return false;
				}
				else if (color[i] == color[child]) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] graph = {{}, {2}, {1, 3, 7}, {2, 4}, {3, 5}, {4, 6, 8}, {5, 7}, {2, 6}, {5}};
        //int[][] graph = {{}};
        Out.print(sol.isBipartite(graph));
    }
}

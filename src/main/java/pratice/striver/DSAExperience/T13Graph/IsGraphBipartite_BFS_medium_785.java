package pratice.striver.DSAExperience.T13Graph;

import pratice.common.Out;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite_BFS_medium_785 {
    static class Solution {
        // [Optimal] TC: O(V + E), since in its whole, it is a DFS implementation, V – vertices; E – edges
        // SC: O(V), because, apart from the graph, we maintain a color array.
        public boolean isBipartite(int[][] graph) {
            int[] color = new int[graph.length];
            Arrays.fill(color, -1);

            for (int i = 0; i < graph.length; i++) {
                if (color[i] == -1)
                    if (!bfsCheck(graph, i, color))
                        return false;
            }
            return true;
        }

        private boolean bfsCheck(int[][] graph, int i, int[] color) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            color[i] = 0;

            while (!q.isEmpty()) {
                int node = q.poll();
                for (int child : graph[node]) {
                    if (color[node] == color[child]) return false;
                    if (color[child] == -1) {
                        q.offer(child);
                        color[child] = 1 - color[node];
                    }
                }
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

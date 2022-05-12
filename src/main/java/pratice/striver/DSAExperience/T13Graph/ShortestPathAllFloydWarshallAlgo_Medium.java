package pratice.striver.DSAExperience.T13Graph;

import pratice.common.BigInput;

public class ShortestPathAllFloydWarshallAlgo_Medium {
    private static final int INF = Integer.MAX_VALUE;

    static class Solution {
        // [Optimal] TC: O(V^3). Going through N-1 times for relaxation of distance array from each node
        // SC: O(1)
        public void shortestDistance(int[][] dist) {
            int V = dist.length;

            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][j] == -1)
                        dist[i][j] = INF;
                }
            }

            for (int k = 0; k < V; k++) {
                for (int i = 0; i < V; i++) {
                    if (i != k) {
                        for (int j = 0; j < V; j++) {
                            if (j != k && i != j && dist[i][k] != INF && dist[k][j] != INF)
                                dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }

            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][j] == INF)
                        dist[i][j] = -1;
                }
            }

            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++)
                    System.out.print((dist[i][j] == INF ? "INF" : dist[i][j]) + " ");
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] graph = BigInput.inputArray("ShortestPathAllFloydWarshallAlgo_Medium.txt");

        //int[][] graph = {{0, 3, INF, 7}, {8, 0, 2, INF}, {5, INF, 0, 1}, {2, INF, INF, 0}};
        sol.shortestDistance(graph);
    }
}

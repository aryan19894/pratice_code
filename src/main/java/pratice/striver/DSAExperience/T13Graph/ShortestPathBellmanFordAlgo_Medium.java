package pratice.striver.DSAExperience.T13Graph;

import pratice.common.Out;
import pratice.common.converter.Array;

import java.util.ArrayList;
import java.util.Arrays;

public class ShortestPathBellmanFordAlgo_Medium {
    // [Optimal] TC: O((N-1)*E). Going through N-1 times for relaxation of distance array
    // SC:  O(N). Distance array
    static int[] bellmanFord(int V, ArrayList<ArrayList<Integer>> adj, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        for (int i = 1; i <= V - 1; i++) {
            for (ArrayList<Integer> edge : adj) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if (dist[u] != Integer.MAX_VALUE)
                    dist[v] = Math.min(dist[v], dist[u] + wt);
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 1, 5},
                {1, 2, -2}, {1, 5, -3},
                {2, 4, 3},
                {3, 2, 6}, {3, 4, -2},
                {},
                {5, 3, 1}};
        Out.print(bellmanFord(6, Array.toList(graph), 0));
    }
}

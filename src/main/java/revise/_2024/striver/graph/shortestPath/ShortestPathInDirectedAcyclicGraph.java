package revise._2024.striver.graph.shortestPath;

import common.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraph {
    static class Pair {
        int node, weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private static final int INF = (int) (1e9);

    static int[] shortestPath(int N, int M, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges)
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));

        int startNode = 0;
        Stack<Integer> st = new Stack<>();

        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i])
                dfs(i, adj, visited, st);
        }

        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[startNode] = 0;

        while (!st.isEmpty()) {
            int curr = st.pop();
            for (Pair neigh : adj.get(curr))
                dist[neigh.node] = Integer.min(dist[neigh.node], dist[curr] + neigh.weight);
        }

        for (int i = 0; i < N; i++)
            if (dist[i] == INF) dist[i] = -1;

        return dist;
    }

    private static void dfs(int node, List<List<Pair>> adj,
                            boolean[] visited, Stack<Integer> st) {
        visited[node] = true;
        for (Pair neigh : adj.get(node)) {
            if (!visited[neigh.node])
                dfs(neigh.node, adj, visited, st);
        }
        st.push(node);
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 2, 6},
                {0, 3, 7},
                {0, 4, 9},
                {0, 6, 8},
                {0, 7, 6},
                {1, 2, 6},
                {1, 3, 7},
                {1, 5, 10},
                {1, 6, 1},
                {1, 7, 4},
                {2, 3, 3},
                {2, 6, 10},
                {2, 8, 8},
                {2, 9, 10},
                {3, 5, 3},
                {3, 6, 10},
                {3, 7, 5},
                {5, 6, 9},
                {5, 7, 7},
                {6, 7, 7},
                {6, 8, 8},
                {6, 9, 8},
                {7, 9, 1},
                {8, 9, 6}
        };
        int N = 10, M = 24;
        Out.print(shortestPath(N, M, edges));
    }
}

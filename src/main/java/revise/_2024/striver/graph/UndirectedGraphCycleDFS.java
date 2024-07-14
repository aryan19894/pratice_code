package revise._2024.striver.graph;

import common.Out;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UndirectedGraphCycleDFS {
    static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(adj, i, i, visited))
                return true;
        }
        return false;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, int parent, boolean[] visited) {
        visited[src] = true;

        for (int neigh : adj.get(src)) {
            if (!visited[neigh]) {
                if (dfs(adj, neigh, src, visited)) return true;
            } else if (parent != neigh) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{}, {2}, {1, 3}, {2}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int[] g : grid)
            adj.add(new ArrayList<>(IntStream.of(g).boxed().collect(Collectors.toList())));

        Out.print(isCycle(4, adj));
    }
}

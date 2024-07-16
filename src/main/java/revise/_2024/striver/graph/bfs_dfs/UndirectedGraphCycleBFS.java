package revise._2024.striver.graph.bfs_dfs;

import common.Out;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UndirectedGraphCycleBFS {
    static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        visited[0] = true;

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                if (checkForCycle(adj, i, visited))
                    return true;
        }

        return false;
    }

    private static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        visited[src] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int neigh : adj.get(curr[0])) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    q.add(new int[]{neigh, curr[0]});
                } else if (curr[1] != neigh) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int[] g : grid)
            adj.add(new ArrayList<>(IntStream.of(g).boxed().collect(Collectors.toList())));

        Out.print(isCycle(5, adj));
    }
}

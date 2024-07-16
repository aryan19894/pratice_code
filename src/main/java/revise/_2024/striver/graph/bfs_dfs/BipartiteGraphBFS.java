package revise._2024.striver.graph.bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBFS {
    static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!checkForBipartite(i, V, adj, color))
                    return false;
            }
        }

        return true;
    }

    private static boolean checkForBipartite(int start, int V,
                                             ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neigh : adj.get(node)) {
                if (color[neigh] == -1) {
                    color[neigh] = 1 - color[node];
                    q.add(neigh);
                } else if (color[node] == color[neigh]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1)),
                        new ArrayList<>(Arrays.asList(2)),
                        new ArrayList<>(Arrays.asList(1, 3, 6)),
                        new ArrayList<>(Arrays.asList(2, 4)),
                        new ArrayList<>(Arrays.asList(3, 5, 7)),
                        new ArrayList<>(Arrays.asList(4, 6)),
                        new ArrayList<>(Arrays.asList(2, 5)),
                        new ArrayList<>(Arrays.asList(4, 8)),
                        new ArrayList<>(Arrays.asList(7))
                )
        );

        System.out.println(isBipartite(9, adj));
    }
}

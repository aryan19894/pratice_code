package revise._2024.striver.graph.bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteGraphDFS {
    static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!checkForBipartiteByDFS(i, 0, adj, color))
                    return false;
            }
        }

        return true;
    }

    private static boolean checkForBipartiteByDFS(int node, int col,
                                                  ArrayList<ArrayList<Integer>> adj, int[] color) {
        color[node] = 1 - col;
        for (int neigh : adj.get(node)) {
            if (color[neigh] == -1) {
                if (!checkForBipartiteByDFS(neigh, 1 - col, adj, color)) return false;
            } else if (color[node] == color[neigh]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList()),
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

package revise._2024.striver.graph.OtherAlgo;

import common.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInANetwork_1192Hard_TarjanAlgo {
    private static int timer = 0;

    static public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] visited = new boolean[n];
        int[] insert = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, adj, visited, insert, low, bridges);
        return bridges;
    }

    private static void dfs(int node, int parent,
                            List<Integer>[] adj,
                            boolean[] visited, int[] insert, int[] low,
                            List<List<Integer>> bridges) {
        visited[node] = true;
        insert[node] = low[node] = timer++;
        for (int neigh : adj[node]) {
            if (neigh == parent) continue;
            if (!visited[neigh]) {
                dfs(neigh, node, adj, visited, insert, low, bridges);
                low[node] = Math.min(low[node], low[neigh]);
                if (low[neigh] > insert[node])
                    bridges.add(Arrays.asList(node, neigh));
            } else
                low[node] = Math.min(low[node], low[neigh]);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] nodes = {{0, 1}, {1, 2}, {2, 0}, {1, 3}};
        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            connections.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            connections.get(i).add(nodes[i][0]);
            connections.get(i).add(nodes[i][1]);
        }

        List<List<Integer>> result = criticalConnections(n, connections);
        Out.print(result);
    }
}

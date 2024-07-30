package revise._2024.striver.graph.OtherAlgo;

import common.Out;

import java.util.ArrayList;

public class ArticulationPoint1 {
    private static int timer = 0;

    static public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] mark = new boolean[V];
        int[] toi = new int[V]; //time of insertion
        int[] low = new int[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(0, -1, adj, visited, mark, toi, low);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (mark[i]) ans.add(i);
        }
        if (ans.isEmpty()) ans.add(-1);
        return ans;
    }

    private static void dfs(int node, int parent,
                            ArrayList<ArrayList<Integer>> adj,
                            boolean[] visited, boolean[] mark,
                            int[] toi, int[] low) {
        visited[node] = true;
        toi[node] = low[node] = timer++;
        int child = 0;
        for (int neigh : adj.get(node)) {
            if (neigh == parent) continue;
            if (!visited[neigh]) {
                dfs(neigh, node, adj, visited, mark, toi, low);
                low[node] = Math.min(low[node], low[neigh]);
                if (low[neigh] >= toi[node] && parent != -1)
                    mark[node] = true;
                child++;
            } else
                low[node] = Math.min(low[node], toi[neigh]);
        }
        if (child > 1 && parent == -1) mark[node] = true;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1}, {1, 4},
                {2, 4}, {2, 3}, {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            int u = edges[i][0], v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        ArrayList<Integer> result = articulationPoints(n, adj);
        Out.print(result);

    }
}

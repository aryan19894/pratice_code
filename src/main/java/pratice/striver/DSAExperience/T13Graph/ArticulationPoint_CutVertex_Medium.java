package pratice.striver.DSAExperience.T13Graph;

import pratice.common.converter.Array;

import java.util.ArrayList;

public class ArticulationPoint_CutVertex_Medium {
    // [Optimal] TC: O(N+E) - Where N is the time taken for visiting N nodes and
    // E is for travelling through adjacent nodes.
    // SC: O(N) + O(N) + O(N) - visited, insertion time , lowest insertion time and result array
    // ASC: O(N) - Recursion call of DFS
    private static void articPoint(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        int isArtic[] = new int[V];

        int timer = 0;
        for (int i = 0; i < V; i++)
            if (!visited[i])
                dfs(i, -1, adj, visited, tin, low, timer, isArtic);

        for (int i = 0; i < V; i++) {
            if (isArtic[i] == 1)
                System.out.print(i + " ");
        }
    }

    private static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj,
                            boolean[] visited, int[] tin, int[] low, int timer, int[] isArtic) {
        visited[node] = true;
        tin[node] = low[node] = timer++;

        int childCount = 0;
        for (int child : adj.get(node)) {
            if (child == parent) continue;
            if (!visited[child]) {
                dfs(child, node, adj, visited, tin, low, timer, isArtic);
                low[node] = Math.min(low[node], low[child]);

                if (low[child] >= tin[node] && parent != -1)
                    isArtic[node] = 1;
                childCount++;
            } else
                low[node] = Math.min(low[node], tin[child]);
        }
        if (parent != -1 && childCount > 1) isArtic[node] = 1;
    }

    public static void main(String[] args) {
        int[][] graph = {{},
                {2, 4},
                {1, 3},
                {2, 4},
                {1, 3, 5},
                {4, 6},
                {5, 7, 9},
                {6, 8},
                {7, 9, 10},
                {6, 8},
                {8, 11, 12},
                {10, 12},
                {10}
        };
        articPoint(13, Array.toList(graph));
    }
}

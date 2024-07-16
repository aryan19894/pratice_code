package revise._2024.striver.graph.topoSort;

import common.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSortDFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(adj, i, visited, st);
        }

        int ans[] = new int[V];
        int i = 0;
        while (!st.isEmpty())
            ans[i++] = st.pop();
        return ans;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int node,
                            boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neigh : adj.get(node)) {
            if (!visited[neigh])
                dfs(adj, neigh, visited, stack);
        }
        stack.add(node);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList()),
                        new ArrayList<>(Arrays.asList()),
                        new ArrayList<>(Arrays.asList(3)),
                        new ArrayList<>(Arrays.asList(1)),
                        new ArrayList<>(Arrays.asList(0, 1)),
                        new ArrayList<>(Arrays.asList(0, 2))
                )
        );

        Out.print(topoSort(6, adj));
    }
}

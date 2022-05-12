package pratice.striver.DSAExperience.T13Graph;

import pratice.common.converter.Array;

import java.util.ArrayList;
import java.util.Stack;

//SSC: StronglyConnectedComponents
public class SSCKosarajuAlgo {
    // [Optimal] TC: O(N+E), DFS+TopoSort
    // SC: O(N+E), Transposing the graph
    // ASC: O(N) - Recursion call of DFS
    private static void findSSC(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 1; i < V; i++) {
            if (!visited[i])
                dfs(i, visited, adj, st);
        }

        adj = transpose(V, adj);
        visited = new boolean[V];

        while (!st.isEmpty()) {
            int node = st.pop();
            if (!visited[node]) {
                System.out.print("SCC: ");
                reverseDfs(node, visited, adj);
                System.out.println();
            }
        }
    }


    private static ArrayList<ArrayList<Integer>> transpose(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++)
            transpose.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            for (int child : adj.get(i))
                transpose.get(child).add(i);
        }
        return transpose;
    }

    private static void reverseDfs(int node, boolean[] visited,
                                   ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int child : adj.get(node)) {
            if (!visited[child])
                reverseDfs(child, visited, adj);
        }
    }

    private static void dfs(int node, boolean[] visited,
                            ArrayList<ArrayList<Integer>> adj,
                            Stack<Integer> st) {
        visited[node] = true;
        for (int child : adj.get(node)) {
            if (!visited[child])
                dfs(child, visited, adj, st);
        }
        st.push(node);
    }

    public static void main(String[] args) {
        int[][] graph = {{}, {2}, {3, 4}, {1}, {5}, {}};
        findSSC(6, Array.toList(graph));
    }
}

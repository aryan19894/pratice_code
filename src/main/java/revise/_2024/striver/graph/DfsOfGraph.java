package revise._2024.striver.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DfsOfGraph {
    static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        result.add(0);
        visited[0] = true;
        dfsOfGraphUtil(V, 0, adj, visited, result);

        return result;
    }

    private static void dfsOfGraphUtil(int v, int node, ArrayList<ArrayList<Integer>> adj,
                                       boolean[] visited, ArrayList<Integer> result) {
        if (adj.get(node).size() == 0) return;

        for (int child : adj.get(node)) {
            if (!visited[child]) {
                result.add(child);
                visited[child] = true;
                dfsOfGraphUtil(v, child, adj, visited, result);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(2, 3, 1)),
                        new ArrayList<>(Arrays.asList(0)),
                        new ArrayList<>(Arrays.asList(0, 4)),
                        new ArrayList<>(Arrays.asList(0)),
                        new ArrayList<>(Arrays.asList(2))
                )
        );

        ArrayList<Integer> result = dfsOfGraph(5, adj);
        System.out.println(result);
    }
}

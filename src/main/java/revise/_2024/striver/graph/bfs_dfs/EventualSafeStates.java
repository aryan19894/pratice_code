package revise._2024.striver.graph.bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventualSafeStates {
    static List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        boolean[] safeNode = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                findSafeNodes(adj, i, safeNode, visited, pathVisited);

        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (safeNode[i])
                result.add(i);
        }
        return result;
    }

    private static boolean findSafeNodes(List<List<Integer>> adj, int node,
                                         boolean[] safeNode,
                                         boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;
        safeNode[node] = false;

        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                if (findSafeNodes(adj, neigh, safeNode, visited, pathVisited)) return true;
            } else if (pathVisited[neigh]) return true;
        }
        safeNode[node] = true;
        pathVisited[node] = false;
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 2)),
                        new ArrayList<>(Arrays.asList(2, 3)),
                        new ArrayList<>(Arrays.asList(5)),
                        new ArrayList<>(Arrays.asList(0)),
                        new ArrayList<>(Arrays.asList(5)),
                        new ArrayList<>(Arrays.asList()),
                        new ArrayList<>(Arrays.asList())
                )
        );

        System.out.println(eventualSafeNodes(7, adj));
    }
}

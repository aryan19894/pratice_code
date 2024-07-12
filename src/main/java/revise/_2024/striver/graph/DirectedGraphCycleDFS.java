package revise._2024.striver.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DirectedGraphCycleDFS {
    static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicByDFS(adj, i, visited, pathVisited))
                return true;
        }
        return false;
    }

    private static boolean isCyclicByDFS(ArrayList<ArrayList<Integer>> adj, int node,
                                         boolean[] visited, boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;
        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                if (isCyclicByDFS(adj, neigh, visited, pathVisited)) return true;
            } else if (pathVisited[neigh]) return true;
        }
        pathVisited[node] = false;
        return false;
    }

    public static void main(String[] args) {
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(
//                Arrays.asList(
//                        new ArrayList<>(Arrays.asList()),
//                        new ArrayList<>(Arrays.asList(2)),
//                        new ArrayList<>(Arrays.asList(3, 8)),
//                        new ArrayList<>(Arrays.asList(4, 7)),
//                        new ArrayList<>(Arrays.asList(5)),
//                        new ArrayList<>(Arrays.asList(6)),
//                        new ArrayList<>(Arrays.asList()),
//                        new ArrayList<>(Arrays.asList(5)),
//                        new ArrayList<>(Arrays.asList(2, 9)),
//                        new ArrayList<>(Arrays.asList(10)),
//                        new ArrayList<>(Arrays.asList(8))
//                )
//        );

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1)),
                        new ArrayList<>(Arrays.asList(2)),
                        new ArrayList<>(Arrays.asList(3)),
                        new ArrayList<>(Arrays.asList(3))
                )
        );

        System.out.println(isCyclic(4, adj));
    }
}

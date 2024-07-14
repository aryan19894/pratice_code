package revise._2024.striver.graph;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPaths {
    private static void printAllPaths(Graph graph, int src, int target) {
        boolean[] visited = new boolean[graph.size];
        List<Integer> path = new ArrayList<>();

        path.add(src);

        printAllPathsUtil(graph, src, target, visited, path);
    }

    private static void printAllPathsUtil(Graph graph, int src, int target, boolean[] visited, List<Integer> path) {
        if (src == target) {
            System.out.println(path);
            return;
        }

        visited[src] = true;

        for (Pair pair : graph.get(src)) {
            if (!visited[pair.node]) {
                path.add(pair.node);
                printAllPathsUtil(graph, pair.node, target, visited, path);

                path.remove((Object) pair.node);
//                path.remove(pair.node);
            }
        }

        visited[src] = false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4, true, false, false);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        // arbitrary source
        int s = 2;

        // arbitrary destination
        int d = 3;

        System.out.println(
                "Following are all different paths from "
                        + s + " to " + d);
        printAllPaths(g, s, d);
    }
}

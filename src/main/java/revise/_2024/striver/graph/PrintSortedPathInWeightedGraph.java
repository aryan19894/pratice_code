package revise._2024.striver.graph;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintSortedPathInWeightedGraph {
    /*
     * TODO: print all path from source to destination in sorted order
     * */
    static class Path implements Comparable<Path> {
        List<Integer> nodes = new ArrayList<>();
        int totalWeight;

        public Path(List<Pair> pairs) {
            for (Pair p : pairs) {
                nodes.add(p.node);
                totalWeight += p.weight;
            }
        }

        @Override
        public int compareTo(@NotNull PrintSortedPathInWeightedGraph.Path other) {
            return Integer.compare(this.totalWeight, other.totalWeight);
        }
    }

    private static void printSortedAllPaths(Graph g, int src, int target) {
        boolean[] visited = new boolean[g.size + 1];
        List<Path> result = new ArrayList<>();
        List<Pair> path = new ArrayList<>();
        path.add(new Pair(src, 0));

        printSortedAllPathsUtil(g, src, target, visited, path, result);

        Collections.sort(result);
        for (Path p : result) {
            System.out.println(p.nodes + ", Weight: " + p.totalWeight);
        }
    }

    private static void printSortedAllPathsUtil(Graph graph, int src, int target, boolean[] visited,
                                                List<Pair> path, List<Path> result) {
        if (src == target) {
            result.add(new Path(path));
            return;
        }

        visited[src] = true;

        for (Pair p : graph.get(src)) {
            if (!visited[p.node]) {
                path.add(p);
                printSortedAllPathsUtil(graph, p.node, target, visited, path, result);
                path.remove(p);
            }
        }
        visited[src] = false;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//
//        int[][] edges = new int[m][3];
//
//        for (int i = 0; i < m; i++) {
//            edges[i][0] = in.nextInt();
//            edges[i][1] = in.nextInt();
//            edges[i][2] = in.nextInt();
//        }
//        int src = in.nextInt();
//        int target = in.nextInt();

        Graph g = new Graph(6, false, true, true);
        int[][] edges = {
                {1, 2, 2},
                {1, 4, 3},
                {1, 5, 1},
                {2, 3, 3},
                {3, 4, 2},
                {3, 5, 5},
                {4, 5, 4},
                {5, 6, 5}
        };
        g.addEdges(edges);
        // arbitrary source
        int src = 1;

        // arbitrary destination
        int target = 6;

        printSortedAllPaths(g, src, target);
    }

}

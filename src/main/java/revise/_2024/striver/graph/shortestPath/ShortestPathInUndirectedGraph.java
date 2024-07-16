package revise._2024.striver.graph.shortestPath;

import common.Out;

import java.util.*;

/*
 * Question from GFG
 * https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
 * */
public class ShortestPathInUndirectedGraph {
    static class Pair {
        public int node;
        public int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "node=" + node +
                    ", distance=" + dist +
                    '}';
        }
    }

    private static int[] shortestPath(int[][] edges, int n, int m, int src) {
        List<Pair>[] graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph[u].add(new Pair(v, w));
            graph[v].add(new Pair(u, w));
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        distance[src] = 0;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (Pair e : graph[curr.node]) {
                int currDist = curr.dist + e.dist;
                if (distance[e.node] > currDist) {
                    distance[e.node] = currDist;
                    q.add(new Pair(e.node, currDist));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                distance[i] = -1;
        }
        return distance;
    }

    /*
     * @[INPUT]
     * n = 9 (noOfNodes)
     * m = 12 (noOfEdges)
     * 0 1 5
     * 0 3 8
     * 3 4 4
     * 4 5 3
     * 5 6 4
     * 1 2 1
     * 2 6 5
     * 6 7 8
     * 7 8 2
     * 6 8 3
     * 3 6 2
     * 1 4 2
     * 0 (Source Node)
     *
     * @[OUTPUT] : [0 5 6 8 7 10 10 15 13]
     *
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] edges = new int[m][3];

        for (int i = 0; i < m; i++) {
            edges[i][0] = in.nextInt();
            edges[i][1] = in.nextInt();
            edges[i][2] = in.nextInt();
        }

        int src = in.nextInt();

        Out.print(shortestPath(edges, n, m, src));
    }
}

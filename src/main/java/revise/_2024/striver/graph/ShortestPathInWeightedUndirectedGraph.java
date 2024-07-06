package revise._2024.striver.graph;

import org.jetbrains.annotations.NotNull;
import pratice.common.Out;

import java.util.*;

/*
 * Question from GFG
 * https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-weighted-undirected-graph
 * */
public class ShortestPathInWeightedUndirectedGraph {
    public static class Pair implements Comparable<Pair>{
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

        @Override
        public int compareTo(@NotNull ShortestPathInWeightedUndirectedGraph.Pair other) {
            return Integer.compare(this.dist, other.dist);
        }
    }

    private static List<Integer> shortestPath(int n, int m, int[][] edges) {
        //Adjacency List of graph
        List<Pair>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph[u].add(new Pair(v, w));
            graph[v].add(new Pair(u, w));
        }

        int[] dist = new int[n + 1];
        int[] path = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 0));
        dist[1] = 0;
        path[1] = 1;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (Pair p : graph[curr.node]) {
                int newDistance = curr.dist + p.dist;
                if (dist[p.node] > newDistance) {
                    dist[p.node] = newDistance;
                    q.add(new Pair(p.node, newDistance));
                    path[p.node] = curr.node;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        if (dist[n] == Integer.MAX_VALUE) {
            result.add(-1);
        } else {
            int weight = dist[n];
            while (n != path[n]) {
                result.add(n);
                n = path[n];
            }
            result.add(n);
            Collections.reverse(result);
            result.add(0, weight);
        }
        return result;
    }

    private static List<Integer> shortestPath2(int n, int m, int[][] edges) {
        //Adjacency List of graph
        List<Pair>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph[u].add(new Pair(v, w));
            graph[v].add(new Pair(u, w));
        }

        int[] dist = new int[n + 1];
        int[] path = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(1, 0));
        dist[1] = 0;
        path[1] = 1;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            for (Pair p : graph[curr.node]) {
                int newDistance = curr.dist + p.dist;
                if (dist[p.node] > newDistance) {
                    dist[p.node] = newDistance;
                    pq.add(new Pair(p.node, newDistance));
                    path[p.node] = curr.node;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        if (dist[n] == Integer.MAX_VALUE) {
            result.add(-1);
        } else {
            int weight = dist[n];
            while (n != path[n]) {
                result.add(n);
                n = path[n];
            }
            result.add(n);
            Collections.reverse(result);
            result.add(0, weight);
        }
        return result;
    }

    /*
     * @[INPUT]
     * n = 5 (noOfNodes)
     * m = 6 (noOfEdges)
     * 1 2 2
     * 2 5 5
     * 2 3 4
     * 1 4 1
     * 4 3 3
     * 3 5 1
     *
     * @[OUTPUT] : [5 1 4 3 5]
     * Weight: 5
     * Path: 1 -> 4 -> 3 -> 5
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

        /* Normal Queue: Time Taken: 1.73 */
        Out.print(shortestPath(n, m, edges));
        /* Priority Queue: Time Taken: 1.42 */
        Out.print(shortestPath2(n, m, edges));
    }


}

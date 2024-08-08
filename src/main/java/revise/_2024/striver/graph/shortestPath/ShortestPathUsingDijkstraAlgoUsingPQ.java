package revise._2024.striver.graph.shortestPath;

import common.Out;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShortestPathUsingDijkstraAlgoUsingPQ {
    @ToString
    static class Pair implements Comparable<Pair> {
        int node, dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(@NotNull Pair other) {
            return Integer.compare(this.dist, other.dist);
        }
    }

    private static final int INF = (int) (1e9);

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[S] = 0;

        int[] path = new int[V];
        path[S] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(S, 0));

        while (!pq.isEmpty()) {
            int curr = pq.peek().node;
            int dis = pq.peek().dist;
            pq.remove();

            for (int i = 0; i < adj.get(curr).size(); i++) {
                int neigh = adj.get(curr).get(i).get(0);
                int neighWeight = adj.get(curr).get(i).get(1);

                if (dis + neighWeight < dist[neigh]) {
                    dist[neigh] = dis + neighWeight;
                    pq.add(new Pair(neigh, dist[neigh]));
                }
            }
        }

        for (int i = 0; i < V; i++)
            if (dist[i] == INF) dist[i] = -1;

        return dist;
    }

    public static void main(String[] args) {
        int[][][] arr = {
                {{1, 4}, {2, 4}},
                {{0, 4}, {2, 2}},
                {{0, 4}, {1, 2}, {3, 3}, {4, 1}, {5, 6}},
                {{2, 3}, {5, 2}},
                {{2, 1}, {5, 3}},
                {{2, 6}, {3, 2}, {4, 3}},
        };
        int V = 6, S = 0;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int[][] ar : arr) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
            for (int[] a : ar) {
                temp.add(new ArrayList<>(IntStream.of(a).boxed().collect(Collectors.toList())));
            }
            adj.add(temp);
        }

        Out.print(dijkstra(V, adj, S));
    }
}

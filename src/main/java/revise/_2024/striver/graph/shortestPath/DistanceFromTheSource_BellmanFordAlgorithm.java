package revise._2024.striver.graph.shortestPath;

import common.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DistanceFromTheSource_BellmanFordAlgorithm {
    private static final int INF = (int) (1e8);

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[S] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> e: edges) {
                int u = e.get(0);
                int v = e.get(1);
                int w = e.get(2);

                if (dist[u] == INF) continue;
                if (dist[u] + w < dist[v])
                    dist[v] = dist[u] + w;
            }
        }

        for (ArrayList<Integer> e: edges) {
            int u = e.get(0);
            int v = e.get(1);
            int w = e.get(2);

            if (dist[u] == INF) continue;
            if (dist[u] + w < dist[v]) {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 9}};
        int V = 2, S = 0;

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int[] g : arr)
            edges.add(new ArrayList<>(IntStream.of(g).boxed().collect(Collectors.toList())));

        Out.print(bellman_ford(V, edges, S));
    }
}

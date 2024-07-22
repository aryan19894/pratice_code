package revise._2024.striver.graph.shortestPath;

import lombok.ToString;

import java.util.*;

public class CheapestFlightsWithinKStops {
    @ToString
    static class Route {
        int node, cost, stop;

        public Route(int node, int cost, int stop) {
            this.node = node;
            this.cost = cost;
            this.stop = stop;
        }

        public Route(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
        List<Route>[] graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int c = flight[2];

            graph[u].add(new Route(v, c));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Route> q = new LinkedList<>();
        q.add(new Route(src, 0, 0));

        while (!q.isEmpty()) {
            Route curr = q.poll();

            if (curr.stop == k + 1 && curr.node == dst) break;

            for (Route neigh : graph[curr.node]) {
                if (curr.cost + neigh.cost < dist[neigh.node] && curr.stop <= k) {
                    dist[neigh.node] = curr.cost + neigh.cost;
                    q.add(new Route(neigh.node, curr.cost + neigh.cost, curr.stop + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dst = 3, k = 1;

        System.out.println(CheapestFLight(n, flights, src, dst, k));
    }
}

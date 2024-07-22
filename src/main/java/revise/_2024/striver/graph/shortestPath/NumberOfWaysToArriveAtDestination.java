package revise._2024.striver.graph.shortestPath;

import common.Out;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberOfWaysToArriveAtDestination {
    @ToString
    static class Path {
        int node;
        long time;

        public Path(int node, long time) {
            this.node = node;
            this.time = time;
        }
    }

    private static final int MODULO = (int) (1e9 + 7);
    private static final int MAX = Integer.MAX_VALUE;

    static int countPaths(int n, List<List<Integer>> roads) {
        List<Path>[] graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (List<Integer> road : roads) {
            int u = road.get(0);
            int v = road.get(1);
            int t = road.get(2);

            graph[u].add(new Path(v, t));
            graph[v].add(new Path(u, t));
        }

        int[] ways = new int[n];
        ways[0] = 1;
        long[] dist = new long[n];
        Arrays.fill(dist, MAX);
        dist[0] = 0;

        PriorityQueue<Path> pq = new PriorityQueue<>((x, y) -> Long.compare(x.time, y.time));
        pq.add(new Path(0, (long) 0));

        while (!pq.isEmpty()) {
            Path curr = pq.poll();
            if (curr.time > dist[curr.node]) continue;

            for (Path neigh : graph[curr.node]) {
                long consumeTime = (curr.time + neigh.time);

                if (consumeTime < dist[neigh.node]) {
                    ways[neigh.node] = ways[curr.node] % MODULO;
                    dist[neigh.node] = consumeTime;
                    pq.add(new Path(neigh.node, consumeTime));
                } else if (consumeTime == dist[neigh.node])
                    ways[neigh.node] = ways[neigh.node] + ways[curr.node];
            }
        }

        return ways[n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1000000000},
                {0, 3, 1000000000},
                {1, 3, 1000000000},
                {1, 2, 1000000000},
                {1, 5, 1000000000},
                {3, 4, 1000000000},
                {4, 5, 1000000000},
                {2, 5, 1000000000}};
        List<List<Integer>> roads = new ArrayList<>();
        for (int[] g : grid)
            roads.add(new ArrayList<>(IntStream.of(g).boxed().collect(Collectors.toList())));

        Out.print(countPaths(6, roads));
    }
}

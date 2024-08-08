package revise._2024.striver.graph.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime_743Medium {
    static class Pair {
        int node, time;

        public Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "node=" + node +
                    ", time=" + time +
                    '}';
        }
    }

    static public int networkDelayTime(int[][] times, int n, int k) {
        //1-index
        n++;
        List<Pair>[] graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] node : times)
            graph[node[0]].add(new Pair(node[1], node[2]));

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.time, b.time)
        );
        pq.add(new Pair(k, 0));
        dist[k] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            for (Pair neigh : graph[curr.node]) {
                int timeTaken = curr.time + neigh.time;
                if (timeTaken < dist[neigh.node]) {
                    dist[neigh.node] = timeTaken;
                    pq.add(new Pair(neigh.node, timeTaken));
                }
            }
        }

        int totalTime = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++)
            totalTime = Math.max(totalTime, dist[i]);

        return totalTime == Integer.MAX_VALUE ? -1 : totalTime;
    }

    public static void main(String[] args) {
        int[][] times = {{1, 2, 1}};
        int n = 2, k = 2;

        System.out.println(networkDelayTime(times, n, k));
    }
}

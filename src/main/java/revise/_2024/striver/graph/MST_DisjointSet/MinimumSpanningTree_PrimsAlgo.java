package revise._2024.striver.graph.MST_DisjointSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTree_PrimsAlgo {
    static class Pair {
        int node, dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    //1.98
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.dist, b.dist)
        );

        pq.add(new Pair(0, 0));
        boolean[] visited = new boolean[V];

        int sum = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (visited[curr.node]) continue;

            visited[curr.node] = true;
            sum += curr.dist;

            for (int[] neigh : adj.get(curr.node)) {
                if (!visited[neigh[0]])
                    pq.add(new Pair(neigh[0], neigh[1]));
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int V = 5, E = 6;
        List<List<int[]>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(
                Arrays.asList(new int[]{1, 2}, new int[]{2, 1})
        ));
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(
                Arrays.asList(new int[]{1, 1}, new int[]{4, 2}, new int[]{3, 2})
        ));
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(
                Arrays.asList(new int[]{3, 1})
        ));

        System.out.println(spanningTree(V, E, adj));
    }
}

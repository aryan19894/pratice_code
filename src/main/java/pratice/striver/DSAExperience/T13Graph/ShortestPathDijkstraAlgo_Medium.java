package pratice.striver.DSAExperience.T13Graph;

import pratice.common.Out;
import pratice.common.converter.Array;
import pratice.striver.DSAExperience.T13Graph.common.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPathDijkstraAlgo_Medium {
    // [Optimal] TC: O((N+E)*logN). Going through N nodes and E edges and log N for priority queue
    // SC:  O(N). Distance array and priority queue
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(V, new Edge());

        pq.offer(new Edge(S, 0));
        while (!pq.isEmpty()) {
            Edge node = pq.poll();
            for (ArrayList<Integer> child : adj.get(node.v())) {
                if (distance[node.v()] + child.get(1) < distance[child.get(0)]) {
                    distance[child.get(0)] = distance[node.v()] + child.get(1);
                    pq.offer(new Edge(child.get(0), distance[child.get(0)]));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int[][][] graph = {{{1, 1}, {2, 7}, {4, 9}},
                {{0, 1}, {3, 6}, {4, 3}},
                {{0, 7}, {4, 9}},
                {{1, 6}},
                {{0, 9}, {1, 3}, {2, 9}}};
        Out.print(dijkstra(5, Array.toList(graph), 1));
    }
}

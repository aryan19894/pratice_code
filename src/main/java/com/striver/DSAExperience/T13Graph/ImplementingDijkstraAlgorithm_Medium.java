package com.striver.DSAExperience.T13Graph;

import com.common.Out;
import com.common.converter.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ImplementingDijkstraAlgorithm_Medium {
    static class Pair implements Comparator<Pair> {
        private int v;
        private int weight;

        Pair(int _v, int _w) {
            v = _v;
            weight = _w;
        }

        Pair() {
        }

        int getV() {
            return v;
        }

        int getWeight() {
            return weight;
        }

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.weight - o2.weight;
        }

        @Override
        public String toString() {
            return "{" +
                    "v=" + v +
                    ", weight=" + weight +
                    '}';
        }
    }

    // [Optimal] TC: O((N+E)*logN). Going through N nodes and E edges and log N for priority queue
    // SC:  O(N). Distance array and priority queue
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(V, new Pair());

        pq.offer(new Pair(S, 0));
        while (!pq.isEmpty()) {
            Pair node = pq.poll();
            for (ArrayList<Integer> child : adj.get(node.getV())) {
                if (distance[node.getV()] + child.get(1) < distance[child.get(0)]) {
                    distance[child.get(0)] = distance[node.getV()] + child.get(1);
                    pq.offer(new Pair(child.get(0), distance[child.get(0)]));
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

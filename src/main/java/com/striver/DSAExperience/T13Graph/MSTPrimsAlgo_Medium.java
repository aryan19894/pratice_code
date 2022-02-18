package com.striver.DSAExperience.T13Graph;

import com.common.Out;
import com.common.converter.Graph;
import com.striver.DSAExperience.T13Graph.common.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MSTPrimsAlgo_Medium {
    // [Brute] TC: O(N^2). Going through N Node for N-1 times
    // SC: O(N). 3 arrays of size N
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int[] key = new int[V];
        boolean[] mst = new boolean[V];
        int[] parent = new int[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < V; i++) {
            int minKeyIdx = Integer.MAX_VALUE;
            for (int j = 0; j < V; j++) {
                if (!mst[j]) {
                    if (minKeyIdx == Integer.MAX_VALUE || key[minKeyIdx] > key[j])
                        minKeyIdx = j;
                }
            }

            mst[minKeyIdx] = true;
            for (ArrayList<Integer> pair : adj.get(minKeyIdx)) {
                int child = pair.get(0);
                if (!mst[child] && key[child] > pair.get(1)) {
                    key[child] = pair.get(1);
                    parent[child] = minKeyIdx;
                }
            }
        }
        int weightMST = 0;
        for (int k : key)
            weightMST += k;

        Out.print(Graph.toAdjMap(parent));

        return weightMST;
    }

    // [Optimal] TC: O(NlogN). N iterations and logN for priority queue
    // SC: O(N). Three arrays and priority queue
    static int spanningTree2(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(V, new Edge());
        int[] key = new int[V];
        boolean[] mst = new boolean[V];
        int[] parent = new int[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;
        pq.offer(new Edge(0, key[0]));

        while (!pq.isEmpty()) {
            int minKeyIdx = pq.poll().v();
            mst[minKeyIdx] = true;
            for (ArrayList<Integer> pair : adj.get(minKeyIdx)) {
                int child = pair.get(0);
                if (!mst[child] && key[child] > pair.get(1)) {
                    key[child] = pair.get(1);
                    parent[child] = minKeyIdx;
                    pq.offer(new Edge(child, key[child]));
                }
            }
        }
        int weightMST = 0;
        for (int k : key)
            weightMST += k;

        Out.print(Graph.toAdjMap(parent));

        return weightMST;
    }

    public static void main(String[] args) {
        int[][] weightedGraph = {
                {0, 1, 5},
                {1, 2, 3},
                {0, 2, 1}
        };
//        int[][][] graph = {{{1, 2}, {3, 6}},
//                {{0, 2}, {2, 3}, {3, 8}, {4, 5}},
//                {{1, 3}, {4, 7}},
//                {{0, 6}, {1, 8}},
//                {{1, 5}, {2, 7}}};
        //Out.print(spanningTree(5, Array.toList(graph)));
        Out.print(spanningTree2(3, Graph.toEdgeList(3, weightedGraph)));
    }
}

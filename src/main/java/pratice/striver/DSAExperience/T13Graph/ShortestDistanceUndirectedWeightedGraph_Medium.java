package pratice.striver.DSAExperience.T13Graph;

import pratice.common.Out;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceUndirectedWeightedGraph_Medium {
    // If weight is missing consider 0
    // [Optimal] TC: O(N + E), N = Number of node , E = Number of Edges
    // SC: O(N) + O(N), Visited Array and Stack data structure. Both will be using O(N).
    // ASC: O(N) - Recursion call of DFS
    public static int shortestDistance(int[][] edges, int n, int start, int end) {
        int[] distance = new int[n];
//        LinkedList<Integer> predessor = new LinkedList<Integer>();
//        predessor.add(start);
        int[] predessor = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        distance[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int child : edges[node]) {
                if (distance[child] > distance[node] + 1) {
                    distance[child] = distance[node] + 1;
                    q.offer(child);
                    predessor[child] = node;
                }
            }
        }
        Out.print(getPath(start, end, predessor));
        return distance[end];
    }

    private static LinkedList<Integer> getPath(int start, int end, int[] predecessor) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        res.add(end);

        while (predecessor[end] != 0) {
            res.add(0, predecessor[end]);
            end = predecessor[end];
        }
        res.add(0, start);
        return res;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2, 3}, {1, 6}, {0, 4}, {3, 5}, {4, 6}, {2, 5, 7, 8}, {6, 8}, {6, 7}};
        Out.print(shortestDistance(graph, 9, 0, 8));
    }
}

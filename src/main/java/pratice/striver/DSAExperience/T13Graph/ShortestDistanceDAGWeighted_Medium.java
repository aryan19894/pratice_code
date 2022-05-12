package pratice.striver.DSAExperience.T13Graph;

import pratice.common.Out;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class ShortestDistanceDAGWeighted_Medium {
    // [Optimal] TC: O(N + E)*2, N = Number of node , E = Number of Edges
    // first for topological sorting and perform BFS to find the distance
    // SC: O(2N), Visited Array and Stack data structure. Both will be using O(N).
    // ASC: O(N) - Recursion call of DFS
    public static int shortestPath(int[][][] edges, int n, int start, int end) {
        Stack<Integer> st = new Stack<>();
        int[] distance = new int[n];
        int[] predecessor = new int[n];

        for (int i = 0; i < n; i++) {
            if (distance[i] == 0)
                topoSort(i, edges, distance, st);
        }

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        while (!st.isEmpty()) {
            int node = st.pop();
            if (distance[node] != Integer.MAX_VALUE) {
                for (int[] child : edges[node]) {
                    if (distance[child[0]] > distance[node] + child[1]) {
                        distance[child[0]] = distance[node] + child[1];
                        predecessor[child[0]] = node;
                    }
                }
            }
        }
        Out.print(getPath(start, end, predecessor));
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

    private static void topoSort(int i, int[][][] edges, int[] distance, Stack<Integer> st) {
        distance[i] = 1;
        for (int[] child : edges[i]) {
            if (distance[child[0]] == 0) {
                topoSort(child[0], edges, distance, st);
            }
        }
        st.add(i);
    }

    public static void main(String[] args) {
        int[][][] graph = {{{1, 2}, {4, 1}}, {{2, 3}}, {{3, 6}}, {}, {{2, 2}, {5, 4}}, {{3, 1}}};
        Out.print(shortestPath(graph, 6, 0, 3));
    }
}

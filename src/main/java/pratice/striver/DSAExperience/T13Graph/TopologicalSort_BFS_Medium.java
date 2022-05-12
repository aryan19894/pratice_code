package pratice.striver.DSAExperience.T13Graph;

import pratice.common.Out;
import pratice.common.converter.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort_BFS_Medium {
    // Kahn's Algorithm
    // [Optimal] TC: O(N + E), N = Number of node , E = Number of Edges
    // SC: O(N) + O(N), Visited Array and Stack data structure. Both will be using O(N).
    static ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();

        int[] inDegree = new int[V];
        for (ArrayList<Integer> a : adj) {
            for (int ele : a)
                inDegree[ele]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for (int child : adj.get(node)) {
                inDegree[child]--;
                if (inDegree[child] == 0)
                    q.offer(child);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] graph = {{}, {}, {3}, {1}, {0, 1}, {0, 2}};
        //int[][] graph = {{}};
        Out.print(topoSort(graph.length, Array.toList(graph)));
    }
}

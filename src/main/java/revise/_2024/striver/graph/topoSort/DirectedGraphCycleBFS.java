package revise._2024.striver.graph.topoSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DirectedGraphCycleBFS {
    static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        for (ArrayList<Integer> n : adj) {
            for (int ele : n)
                inDegree[ele]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            for (int neigh : adj.get(curr)) {
                inDegree[neigh]--;
                if (inDegree[neigh] == 0)
                    q.offer(neigh);
            }
        }

        return V != count;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1)),
                        new ArrayList<>(Arrays.asList(2)),
                        new ArrayList<>(Arrays.asList(3)),
                        new ArrayList<>(Arrays.asList(3))
                )
        );
        System.out.println(isCyclic(4, adj));
    }
}

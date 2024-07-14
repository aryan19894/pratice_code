package revise._2024.striver.graph;

import common.Out;

import java.util.*;

public class TopologicalSortBFS_KahnSAlgo {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        Queue<Integer> q = new LinkedList<>();

        //calculating inDegree
        for (List<Integer> list : adj) {
            for (int element : list)
                inDegree[element]++;
        }

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        int ans[] = new int[V];
        int i = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans[i++] = curr;
            for(int neigh: adj.get(curr)) {
                inDegree[neigh]--;
                if (inDegree[neigh] == 0)
                    q.offer(neigh);
            }
        }

        return ans;
    }
//2.47
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList()),
                        new ArrayList<>(Arrays.asList()),
                        new ArrayList<>(Arrays.asList(3)),
                        new ArrayList<>(Arrays.asList(1)),
                        new ArrayList<>(Arrays.asList(0, 1)),
                        new ArrayList<>(Arrays.asList(0, 2))
                )
        );

        Out.print(topoSort(6, adj));
    }
}

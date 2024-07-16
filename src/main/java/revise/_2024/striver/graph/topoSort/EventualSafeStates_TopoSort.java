package revise._2024.striver.graph.topoSort;

import java.util.*;

public class EventualSafeStates_TopoSort {
    static List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adjRev.add(new ArrayList<>());

        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int ele : adj.get(i)) {
                adjRev.get(ele).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        List<Integer> safeNodes = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            safeNodes.add(curr);
            for (int neigh : adjRev.get(curr)) {
                inDegree[neigh]--;
                if (inDegree[neigh] == 0)
                    q.offer(neigh);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }

    public static void main(String[] args) {
//        List<List<Integer>> adj = new ArrayList<>(
//                Arrays.asList(
//                        new ArrayList<>(Arrays.asList(1)),
//                        new ArrayList<>(Arrays.asList(2)),
//                        new ArrayList<>(Arrays.asList(3)),
//                        new ArrayList<>(Arrays.asList(4, 5)),
//                        new ArrayList<>(Arrays.asList(6)),
//                        new ArrayList<>(Arrays.asList(6)),
//                        new ArrayList<>(Arrays.asList(7)),
//                        new ArrayList<>(Arrays.asList()),
//                        new ArrayList<>(Arrays.asList(1, 9)),
//                        new ArrayList<>(Arrays.asList(10)),
//                        new ArrayList<>(Arrays.asList(8)),
//                        new ArrayList<>(Arrays.asList(9))
//                )
//        );

        List<List<Integer>> adj = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 2)),
                        new ArrayList<>(Arrays.asList(2, 3)),
                        new ArrayList<>(Arrays.asList(5)),
                        new ArrayList<>(Arrays.asList(0)),
                        new ArrayList<>(Arrays.asList(5)),
                        new ArrayList<>(Arrays.asList()),
                        new ArrayList<>(Arrays.asList())
                )
        );

        System.out.println(eventualSafeNodes(7, adj));
    }
}

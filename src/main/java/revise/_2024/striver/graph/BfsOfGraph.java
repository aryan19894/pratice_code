package revise._2024.striver.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BfsOfGraph {
    static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            result.add(curr);
            for (int child : adj.get(curr)) {
                if (!visited[child]) {
                    visited[child] = true;
                    q.offer(child);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 2)),
                        new ArrayList<>(),
                        new ArrayList<>()
                )
        );

        ArrayList<Integer> result = bfsOfGraph(3, adj);
        System.out.println(result);
    }
}

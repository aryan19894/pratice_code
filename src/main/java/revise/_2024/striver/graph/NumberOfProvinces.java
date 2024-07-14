package revise._2024.striver.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfProvinces {
    private static ArrayList<ArrayList<Integer>> convertAdjList(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        return adjList;
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjList = convertAdjList(V, adj);

        boolean[] visited = new boolean[V];
        int num = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                num++;
                dfs(i, adjList, visited);
            }
        }
        return num;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        for (int curr : adjList.get(node)) {
            if (!visited[curr]) dfs(curr, adjList, visited);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 0, 1)),
                        new ArrayList<>(Arrays.asList(0, 1, 0)),
                        new ArrayList<>(Arrays.asList(1, 0, 1))
                )
        );

        int result = numProvinces(adj, 3);
        System.out.println(result);
    }
}

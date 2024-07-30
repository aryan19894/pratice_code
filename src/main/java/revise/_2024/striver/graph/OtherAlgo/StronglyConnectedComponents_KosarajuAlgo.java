package revise._2024.striver.graph.OtherAlgo;

import common.Out;

import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponents_KosarajuAlgo {
    static public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> sortedNodes = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(i, adj, visited, sortedNodes);
        }

        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adjRev.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            for (int ele : adj.get(i))
                adjRev.get(ele).add(i);
        }

        visited = new boolean[V];
        int scc = 0;
        while (!sortedNodes.isEmpty()) {
            int curr = sortedNodes.pop();
            if (!visited[curr]) {
                dfs(curr, adjRev, visited);
                scc++;
            }
        }

        return scc;
    }

    static public ArrayList<ArrayList<Integer>> kosarajuNodes(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> sortedNodes = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(i, adj, visited, sortedNodes);
        }

        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adjRev.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            for (int ele : adj.get(i))
                adjRev.get(ele).add(i);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        visited = new boolean[V];
        while (!sortedNodes.isEmpty()) {
            int curr = sortedNodes.pop();
            if (!visited[curr]) {
                ArrayList<Integer> temp = new ArrayList<>();
                dfs(curr, adjRev, visited, temp);
                result.add(temp);
            }
        }

        return result;
    }


    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                            boolean[] visited, Stack<Integer> sortedNodes) {
        visited[node] = true;

        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) dfs(neigh, adj, visited, sortedNodes);
        }
        sortedNodes.push(node);
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                            boolean[] visited) {
        visited[node] = true;

        for (int neigh : adj.get(node)) {
            if (!visited[neigh])
                dfs(neigh, adj, visited);
        }
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                            boolean[] visited, ArrayList<Integer> temp) {
        temp.add(node);
        visited[node] = true;

        for (int neigh : adj.get(node)) {
            if (!visited[neigh])
                dfs(neigh, adj, visited, temp);
        }
    }

    public static void main(String[] args) {
        int n = 8;
//        int[][] edges = {
//                {1, 0}, {0, 2},
//                {2, 1}, {0, 3},
//                {3, 4}
//        };

        int[][] edges = {
                {0, 1}, {1, 2}, {2, 0},
                {2, 3},
                {3, 4},
                {4, 7}, {4, 5},
                {5, 6}, {6, 4}, {6, 7}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges)
            adj.get(edge[0]).add(edge[1]);

        System.out.println(kosaraju(n, adj));
        Out.print(kosarajuNodes(n, adj));
    }
}

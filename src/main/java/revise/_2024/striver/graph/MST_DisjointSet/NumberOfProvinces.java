package revise._2024.striver.graph.MST_DisjointSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfProvinces {
    static class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                rank.add(0);
            }
        }

        public int findParent(int node) {
            if (node == parent.get(node)) return node;
            parent.set(node, findParent(parent.get(node)));
            return parent.get(node);
        }

        public void union(int u, int v) {
            int up = findParent(u);
            int vp = findParent(v);
            if (up == vp) return;

            if (rank.get(up) < rank.get(vp)) parent.set(up, vp);
            else if (rank.get(up) > rank.get(vp)) parent.set(vp, up);
            else {
                parent.set(vp, up);
                rank.set(up, rank.get(up) + 1);
            }
        }

        public void build(ArrayList<ArrayList<Integer>> adj) {
            for (int i = 0; i < adj.size(); i++) {
                for (int j = 0; j < adj.get(i).size(); j++) {
                    if (adj.get(i).get(j) == 1)
                        this.union(i, j);
                }
            }
        }
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        DisjointSet set = new DisjointSet(V);
        set.build(adj);

        int count = 0;
        for (int i = 0; i < V; i++) {
            if (set.parent.get(i) == i)
                count++;
        }
        return count;
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

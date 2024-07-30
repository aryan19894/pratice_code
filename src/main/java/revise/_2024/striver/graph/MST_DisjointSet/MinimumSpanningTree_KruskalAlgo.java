package revise._2024.striver.graph.MST_DisjointSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumSpanningTree_KruskalAlgo {
    static class Edge {
        int u, v, wt;

        public Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    static class DisjointSet {
        int[] rank, parent;

        public DisjointSet(int n) {
            this.rank = new int[n + 1];
            this.parent = new int[n + 1];

            for (int i = 0; i <= n; i++)
                parent[i] = i;
        }

        public int findParent(int node) {
            if (node == parent[node]) return node;
            parent[node] = findParent(parent[node]);
            return parent[node];
        }

        public void union(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            if (pu == pv) return;

            if (rank[pu] < rank[pv]) parent[pu] = pv;
            else if (rank[pu] > rank[pv]) parent[pv] = pu;
            else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }

        public boolean isSameComponent(Edge e) {
            return findParent(e.u) == findParent(e.v);
        }
    }

    //2.6
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (int[] ele : adj.get(i))
                edges.add(new Edge(i, ele[0], ele[1]));
        }

        Collections.sort(edges, (a, b) -> Integer.compare(a.wt, b.wt));
        DisjointSet set = new DisjointSet(V);
        int sum = 0;
        for (Edge edge : edges) {
            if (!set.isSameComponent(edge)) {
                sum += edge.wt;
                set.union(edge.u, edge.v);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int V = 7, E = 9;
        List<List<int[]>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(
                Arrays.asList(new int[]{5, 4}, new int[]{2, 2}, new int[]{4, 1})
        ));
        adj.add(new ArrayList<>(
                Arrays.asList(new int[]{4, 3}, new int[]{3, 3}, new int[]{6, 7})
        ));
        adj.add(new ArrayList<>(
                Arrays.asList(new int[]{4, 5}, new int[]{6, 8})
        ));
        adj.add(new ArrayList<>(
                Arrays.asList(new int[]{5, 9})
        ));
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());

        System.out.println(spanningTree(V, E, adj));
    }
}

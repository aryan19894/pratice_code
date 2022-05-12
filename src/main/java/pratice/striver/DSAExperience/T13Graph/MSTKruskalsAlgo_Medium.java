package pratice.striver.DSAExperience.T13Graph;

import pratice.common.Out;
import pratice.common.converter.Graph;
import pratice.striver.DSAExperience.T13Graph.common.Edge;
import pratice.striver.DSAExperience.T13Graph.common.SortByWeight;

import java.util.ArrayList;
import java.util.Collections;

public class MSTKruskalsAlgo_Medium {
    static class DisjointSet {
        private int[] parent, rank;
        private int V;

        public DisjointSet(int V) {
            parent = new int[V];
            rank = new int[V];
            this.V = V;
            dummyNode();
        }

        private void dummyNode() {
            for (int i = 0; i < V; i++)
                parent[i] = i;
        }

        public int find(int i) {
            if (parent[i] == i) return parent[i];
            return parent[i] = find(parent[i]);
        }

        public void union(Edge e) {
            int u = find(e.u());
            int v = find(e.v());

            if (rank[u] < rank[v])
                parent[u] = v;
            else if (rank[v] < rank[u])
                parent[v] = u;
            else {
                parent[v] = u;
                rank[u]++;
            }
        }

        public void print() {
            Out.print(Graph.toAdjMap(parent));
        }

        public boolean inSameComponent(Edge e) {
            return find(e.u()) == find(e.v());
        }
    }

    // [Optimal] TC: O(ElogE)+O(E*4*alpha), ElogE for sorting and E*4*alpha for findParent operation ‘E’ times
    // SC: O(N). Parent array+Rank Array
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> graph) {
        ArrayList<Edge> adj = Edge.convert(graph);
        Collections.sort(adj, new SortByWeight());

        DisjointSet set = new DisjointSet(V);
        int weightMST = 0;

        ArrayList<Edge> mst = new ArrayList<>();
        for (Edge e : adj) {
            if (!set.inSameComponent(e)) {
                weightMST += e.weight();
                set.union(e);
                mst.add(e);
            }
        }

        Out.print(Graph.toAdjMap(Edge.toArray(V, mst)));
        return weightMST;
    }

    public static void main(String[] args) {
        int[][] weightedGraph = {
                {1, 2, 2}, {1, 4, 1}, {1, 5, 4},
                {2, 1, 2}, {2, 3, 3}, {2, 4, 3}, {2, 6, 7},
                {3, 2, 3}, {3, 4, 5}, {3, 6, 8},
                {4, 1, 1}, {4, 2, 3}, {4, 3, 5}, {4, 5, 9},
                {5, 1, 4}, {5, 4, 9},
                {6, 2, 7}, {6, 3, 8}
        };
//        int[][][] graph = {{{1, 2}, {3, 6}},
//                {{0, 2}, {2, 3}, {3, 8}, {4, 5}},
//                {{1, 3}, {4, 7}},
//                {{0, 6}, {1, 8}},
//                {{1, 5}, {2, 7}}};
        //Out.print(spanningTree(5, Array.toList(graph)));
        Out.print(spanningTree(7, Graph.toEdgeList(7, weightedGraph)));
    }
}

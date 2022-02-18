package com.striver.DSAExperience.T13Graph.DisjointSet;

import com.common.Out;
import com.common.converter.Graph;

public class UnionByRankAndPathCompressionImpl {
    // [Optimal]: union() & find() - O(logN) or O(4*alpha) ~ O(4) constant time
    // find(): finds the roots of their sets using the find() with path compression technique and
    // erasing hierarchical root-child relation. so that we don’t have to traverse all intermediate nodes again
    // union(): union of trees is based on rank of tree instead of height.
    // if path compression technique is used, then rank is not always equal to height.
    static class DisjointSet {
        int[] rank, parent;
        int n;

        DisjointSet(int n) {
            rank = new int[n];
            parent = new int[n];
            this.n = n;
            dummyNode();
        }

        private void dummyNode() {
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        //finding the parent - Path Compression
        public int find(int i) {
            if (parent[i] != i)
                parent[i] = find(parent[i]);
            return parent[i];
        }

        // union by rank
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            //if both node are in same component
            if (rootX == rootY) return;

            if (rank[rootX] < rank[rootY])
                parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY])
                parent[rootY] = rootX;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }

        public boolean isFriend(int x, int y) {
            return find(x) == find(y);
        }

        public void print() {
            Out.print(Graph.toAdjMap(parent));
        }
    }

    public static void main(String[] args) {
        DisjointSet set = new DisjointSet(8);
        set.union(1, 2);
        set.union(2, 3);
        set.union(4, 5);
        set.union(6, 7);
        set.union(5, 6);
        set.union(3, 7);
        System.out.println(set.isFriend(4, 0));
        System.out.println(set.isFriend(1, 0));

        set.print();
    }
}

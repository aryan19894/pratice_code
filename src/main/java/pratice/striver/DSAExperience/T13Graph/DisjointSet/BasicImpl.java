package pratice.striver.DSAExperience.T13Graph.DisjointSet;

import pratice.common.Out;
import pratice.common.converter.Graph;

public class BasicImpl {
    // [Basic]: union() & find() - O(n)
    // finds the roots of their sets using the find(), and finally puts either one of the trees (representing the set)
    // under the root node of the other tree, effectively merging the trees and the sets.
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

        //finding the parent
        public int find(int i) {
            if (parent[i] != i)
                return find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            parent[rootX] = rootY;
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

//        System.out.println(set.isFriend(4, 0));
//        System.out.println(set.isFriend(1, 0));

        set.print();
    }
}

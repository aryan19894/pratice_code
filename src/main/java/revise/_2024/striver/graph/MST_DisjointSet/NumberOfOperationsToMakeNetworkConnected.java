package revise._2024.striver.graph.MST_DisjointSet;

import java.util.ArrayList;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected {
    static class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findParent(int node) {
            if (parent.get(node) == node) return node;
            int pu = findParent(parent.get(node));
            parent.set(node, pu);
            return parent.get(node);
        }

        public void union(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            if (pu == pv) return;

            if (size.get(pu) < size.get(pv)) {
                parent.set(pu, pv);
                size.set(pv, size.get(pv) + size.get(pu));
            } else {
                parent.set(pv, pu);
                size.set(pu, size.get(pv) + size.get(pu));
            }
        }
    }

    public static int Solve(int n, int[][] edge) {
        DisjointSet set = new DisjointSet(n);
        int extraEdge = 0;
        for (int[] e : edge) {
            int u = e[0];
            int v = e[1];
            if (set.findParent(u) == set.findParent(v)) {
                extraEdge++;
            } else {
                set.union(u, v);
            }
        }

        int compSize = 0;
        for (int i = 0; i < n; i++) {
            if (i == set.parent.get(i)) compSize++;
        }

        return extraEdge >= compSize - 1 ? compSize - 1 : -1;
    }

    public static void main(String[] args) {
        int n = 6, m = 3;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2},
                {1, 3}
        };

        System.out.println(Solve(n, edges));
    }
}

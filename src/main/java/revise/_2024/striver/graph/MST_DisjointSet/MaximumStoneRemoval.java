package revise._2024.striver.graph.MST_DisjointSet;

import common.Out;

import java.util.ArrayList;
import java.util.List;

public class MaximumStoneRemoval {
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
            if (node == parent.get(node)) return node;
            int up = findParent(parent.get(node));
            parent.set(node, up);
            return parent.get(node);
        }

        public void union(int u, int v) {
            int up = findParent(u);
            int vp = findParent(v);
            if (up == vp) return;

            if (size.get(up) < size.get(vp)) {
                parent.set(up, vp);
                size.set(vp, size.get(up) + size.get(vp));
            } else {
                parent.set(vp, up);
                size.set(up, size.get(up) + size.get(vp));
            }
        }
    }

    static public int maxRemove(int[][] stones, int n) {
        int row = 0, col = 0;
        for (int[] stone : stones) {
            row = Math.max(row, stone[0]);
            col = Math.max(col, stone[1]);
        }

        int size = row + col + 2;
        DisjointSet set = new DisjointSet(size);
        for (int[] stone : stones) {
            int i = stone[0];
            int j = stone[1];
            set.union(i, j + row + 1);
        }

        int count = 0;
        for (int i = 0; i < size; i++)
            if (set.findParent(i) == i && set.size.get(i) > 1) count++;

        return n - count;
    }

    public static void main(String[] args) {
        int[][] stones = {{0, 0}, {0, 2}, {1, 3}, {3, 0}, {3, 2}, {4, 3}};
//        int[][] stones = {{1, 1}, {0, 1}};
        int n = 6;
        Out.print(maxRemove(stones, n));
    }
}

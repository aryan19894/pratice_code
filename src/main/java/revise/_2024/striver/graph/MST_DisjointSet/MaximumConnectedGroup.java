package revise._2024.striver.graph.MST_DisjointSet;

import common.Out;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumConnectedGroup {
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

        public int getComponentSize(int node) {
            return size.get(findParent(node));
        }
    }

    private static final int[] DIR = {0, 1, 0, -1, 0};

    private static boolean isValid(int nr, int n, int nc, int m) {
        return nr >= 0 && nr < n && nc >= 0 && nc < m;
    }

    static public int MaxConnection(int grid[][]) {
        int n = grid.length;
        DisjointSet set = new DisjointSet(n * n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                for (int d = 0; d < 4; d++) {
                    int ni = i + DIR[d], nj = j + DIR[d + 1];
                    if (isValid(ni, n, nj, n) && grid[ni][nj] == 1) {
                        int u = i * n + j, v = ni * n + nj;
                        set.union(u, v);
                    }
                }
            }
        }

        int largestComp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                Set<Integer> components = new HashSet<>();
                for (int d = 0; d < 4; d++) {
                    int ni = i + DIR[d], nj = j + DIR[d + 1];
                    if (isValid(ni, n, nj, n) && grid[ni][nj] == 1)
                        components.add(set.findParent(ni * n + nj));
                }
                int sizeTotal = 1;
                for (Integer parents : components)
                    sizeTotal += set.size.get(parents);
                largestComp = Math.max(largestComp, sizeTotal);
            }
        }

        // checking if any components is itself larger without changing any node 0 -> 1
        for (int i = 0; i < n * n; i++)
            largestComp = Math.max(largestComp, set.getComponentSize(i));

        return largestComp;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 0, 1, 1}, {0, 0, 1, 0, 0}, {0, 0, 1, 1, 1},};
//        int[][] grid = {{1, 1}, {0, 1}};

        Out.print(MaxConnection(grid));
    }
}

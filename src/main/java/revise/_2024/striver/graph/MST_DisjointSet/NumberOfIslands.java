package revise._2024.striver.graph.MST_DisjointSet;

import common.Out;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands {
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

        public boolean isSameComponent(int u, int v) {
            return findParent(u) == findParent(v);
        }
    }

    private static final int[] DIR = {0, 1, 0, -1, 0};

    private static boolean isValid(int nr, int n, int nc, int m) {
        return nr >= 0 && nr < n && nc >= 0 && nc < m;
    }

    public static List<Integer> numOfIslands(int n, int m, int[][] operators) {
        DisjointSet set = new DisjointSet(n * m);
        boolean[][] visited = new boolean[n][m];
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int[] operator : operators) {
            int r = operator[0];
            int c = operator[1];
            if (visited[r][c]) {
                result.add(count);
                continue;
            }

            visited[r][c] = true;
            count++;
            for (int i = 0; i < 4; i++) {
                int nr = r + DIR[i], nc = c + DIR[i + 1];
                if (isValid(nr, n, nc, m) && visited[nr][nc]) {
                    int u = r * m + c, v = nr * m + nc;
                    if (!set.isSameComponent(u, v)) {
                        count--;
                        set.union(u, v);
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4, m = 5, k = 4;
        int[][] operators = {{1, 1}, {0, 1}, {3, 3}, {3, 4}};

        Out.print(numOfIslands(n, m, operators));
    }
}

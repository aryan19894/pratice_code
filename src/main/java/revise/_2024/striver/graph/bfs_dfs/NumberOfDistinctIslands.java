package revise._2024.striver.graph.bfs_dfs;

import common.Out;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    static String toString(int i, int j) {
        return i + " " + j;
    }

    static int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] DIR = {0, 1, 0, -1, 0};

        Set<ArrayList<String>> distinct = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ArrayList<String> island = new ArrayList<>();
                    dfs(grid, i, j, n, m, visited, island, DIR, i, j);
                    distinct.add(island);
                }
            }
        }

        return distinct.size();
    }

    private static void dfs(int[][] grid, int i, int j, int n, int m,
                            boolean[][] visited, ArrayList<String> island, int[] DIR,
                            int ri, int rj) {
        visited[i][j] = true;
        island.add(toString(i - ri, j - rj));

        for (int k = 0; k < 4; k++) {
            int ni = i + DIR[k], nj = j + DIR[k + 1];
            if (ni < 0 || nj < 0 || ni == n || nj == m || visited[ni][nj] || grid[ni][nj] == 0) continue;
            dfs(grid, ni, nj, n, m, visited, island, DIR, ri, rj);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1},
                {0, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1},
                {0, 0, 0, 1, 1, 1}};
        Out.print(countDistinctIslands(grid));
    }
}

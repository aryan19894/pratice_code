package revise._2024.striver.graph.bfs_dfs;

import common.Out;

import java.util.LinkedList;
import java.util.Queue;

public class FindTheNumberOfIslands {
    static int numIslands(char[][] grid) {
        int[] DIR = {-1, 0, 1, 1, -1, 1, 0, -1, -1};
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    visited[i][j] = true;
                    q.add(new int[]{i, j});
                    bfs(grid, q, n, m, visited, DIR);
                }
            }
        }
        return count;
    }

    private static void bfs(char[][] grid, Queue<int[]> q, int n, int m, boolean[][] visited, int[] DIR) {
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int k = 0; k < 8; k++) {
                int ni = curr[0] + DIR[k], nj = curr[1] + DIR[k + 1];
                if (ni < 0 || nj < 0 || ni == n || nj == m || visited[ni][nj] || grid[ni][nj] == '0') continue;
                visited[ni][nj] = true;
                q.add(new int[]{ni, nj});
            }
        }
    }

    private static void dfs(char[][] grid, int i, int j, int n, int m, boolean[][] visited, int[] DIR) {
        visited[i][j] = true;

        for (int k = 0; k < 8; k++) {
            int ni = i + DIR[k], nj = j + DIR[k + 1];
            if (ni < 0 || nj < 0 || ni == n || nj == m || visited[ni][nj] || grid[ni][nj] == '0') continue;
            dfs(grid, ni, nj, n, m, visited, DIR);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'0', '1', '1', '1', '0', '0', '0'}, {'0', '0', '1', '1', '0', '1', '0'}};
        long start = System.currentTimeMillis();
        int result = numIslands(grid);
        long end = System.currentTimeMillis();

        Out.print(result);
        Out.print("Time Taken: " + (end - start));
    }
}

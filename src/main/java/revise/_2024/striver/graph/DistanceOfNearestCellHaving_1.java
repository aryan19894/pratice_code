package revise._2024.striver.graph;

import common.Out;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving_1 {
    static int[][] nearest(int[][] grid) {
        int[] DIR = {0, 1, 0, -1, 0};
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] result = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                    result[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int dist = curr[2];
            for (int i = 0; i < 4; i++) {
                int ni = curr[0] + DIR[i], nj = curr[1] + DIR[i + 1];
                if (nj < 0 || ni < 0 || ni == n || nj == m ||
                        visited[ni][nj] || grid[ni][nj] == 1)
                    continue;

                visited[ni][nj] = true;
                result[ni][nj] = dist + 1;
                q.add(new int[]{ni, nj, dist + 1});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}};
        Out.print(nearest(arr));
    }
}

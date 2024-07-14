package revise._2024.striver.graph;

import common.Out;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    static int numberOfEnclaves(int[][] grid) {
        int[] DIR = {0, 1, 0, -1, 0};
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        //1st row & last row
        for (int j = 0; j < m; j++) {
            int i = 0;
            if (grid[i][j] == 1) {
                q.offer(new int[]{i, j});
                grid[i][j] = 0;
            }
            i = n - 1;
            if (grid[i][j] == 1) {
                q.offer(new int[]{i, j});
                grid[i][j] = 0;
            }
        }
        //1st col & last col
        for (int i = 0; i < n; i++) {
            int j = 0;
            if (grid[i][j] == 1) {
                q.offer(new int[]{i, j});
                grid[i][j] = 0;
            }
            j = m - 1;
            if (grid[i][j] == 1) {
                q.offer(new int[]{i, j});
                grid[i][j] = 0;
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int ni = curr[0] + DIR[i], nj = curr[1] + DIR[i + 1];
                if (nj < 0 || ni < 0 || ni == n || nj == m ||
                        grid[ni][nj] == 0)
                    continue;

                grid[ni][nj] = 0;
                q.add(new int[]{ni, nj});
            }
        }


        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 1, 1}};
        Out.print(numberOfEnclaves(grid));
    }
}

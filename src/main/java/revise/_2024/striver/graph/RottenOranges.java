package revise._2024.striver.graph;

import common.Out;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static int orangesRotting(int[][] grid) {
        int units = 0;
        int[] DIR = {0, 1, 0, -1, 0};
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int countFresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2)
                    q.add(new int[]{i, j, 0});

                if (grid[i][j] == 1) countFresh++;
            }
        }

        int makeRotten = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int dist = curr[2];
            for (int k = 0; k < 4; k++) {
                int ni = curr[0] + DIR[k], nj = curr[1] + DIR[k + 1];
                if (ni < 0 || nj < 0 || ni == n || nj == m ||
                        grid[ni][nj] == 2 || grid[ni][nj] == 0) continue;
                grid[ni][nj] = 2;
                makeRotten++;
                q.add(new int[]{ni, nj, dist + 1});
                units = Math.max(units, dist + 1);
            }
        }

        return makeRotten != countFresh ? -1 : units;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
        Out.print(orangesRotting(grid));
    }
}

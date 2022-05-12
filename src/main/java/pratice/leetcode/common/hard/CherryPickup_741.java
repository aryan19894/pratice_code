package pratice.leetcode.common.hard;

import pratice.common.Out;

import java.util.Arrays;

public class CherryPickup_741 {
    static class Solution {
        private static final int[][] dir = {{0, 1, 0}, {0, 1, 1}, {1, 0, 0}, {1, 0, 1}};

        public int cherryPickup(int[][] grid) {
            int n = grid.length;
            int[][][] dp = new int[n][n][n];
            for (int[][] b : dp)
                for (int[] c : b)
                    Arrays.fill(c, -1);

            return Math.max(0, countCherry(grid, 0, 0, 0, dp, n));
        }

        private int countCherry(int[][] grid, int i1, int j1, int i2, int[][][] dp, int n) {
            int j2 = i1 + j1 - i2;
            if (i1 == n || j1 == n || i2 == n || j2 == n || grid[i1][j1] == -1 || grid[i2][j2] == -1)
                return Integer.MIN_VALUE;
            if (dp[i1][j1][j2] != -1) return dp[i1][j1][j2];
            if (i1 == n - 1 && j1 == n - 1) return grid[i1][j1];

            int count = grid[i1][j1];
            if (i1 != i2) count += grid[i2][j2];
            int temp = Integer.MIN_VALUE;
            for (int[] d : dir)
                temp = Math.max(temp, countCherry(grid, i1 + d[0], j1 + d[1], i2 + d[2], dp, n));

            count += temp;
            return dp[i1][j1][j2] = count;
        }

        public int cherryPickup2(int[][] g) {
            int n = g.length;
            int[][][] dp = new int[n][n][n];
            for (int[][] b : dp)
                for (int[] c : b)
                    Arrays.fill(c, Integer.MIN_VALUE);

            dp[n - 1][n - 1][n - 1] = g[n - 1][n - 1];
            for (int i1 = n - 1; i1 >= 0; i1--) {
                for (int j1 = n - 1; j1 >= 0; j1--) {
                    if (g[i1][j1] == -1) continue;
                    for (int i2 = n - 1; i2 >= 0; i2--) {
                        int j2 = i1 + j1 - i2;
                        if (j2 < 0 || j2 >= n || g[i2][j2] == -1) continue;

                        int max = Integer.MIN_VALUE;
                        for (int[] d : dir) {
                            if (isValid(i1 + d[0], j1 + d[1], i2 + d[2], n, g))
                                max = Math.max(max, dp[i1 + d[0]][j1 + d[1]][i2 + d[2]]);
                        }

                        if (max == Integer.MIN_VALUE) continue;
                        int v = g[i1][j1] + g[i2][j2];
                        if (i1 == i2) v /= 2;
                        dp[i1][j1][i2] = max + v;
                    }
                }
            }

            return dp[0][0][0] == Integer.MIN_VALUE ? 0 : dp[0][0][0];
        }

        boolean isValid(int x1, int y1, int x2, int n, int[][] g) {
            int y2 = x1 + y1 - x2;
            return x1 >= 0 && x1 < n
                    && y1 >= 0 && y1 < n
                    && x2 >= 0 && x2 < n
                    && y2 >= 0 && y2 < n
                    && g[x1][y1] != -1
                    && g[x2][y2] != -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {{1, 1, -1, 1, 1}, {1, 1, -1, 1, 1}, {1, 1, 1, -1, 1}, {0, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        Out.print(sol.cherryPickup(grid));
        Out.print(sol.cherryPickup2(grid));
    }
}

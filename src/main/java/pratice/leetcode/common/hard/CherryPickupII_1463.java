package pratice.leetcode.common.hard;

import pratice.common.Out;

import java.util.Arrays;

public class CherryPickupII_1463 {
    static class Solution {
        public int cherryPickup(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][][] dp = new int[n][m][m];
            for (int[][] b : dp)
                for (int[] c : b)
                    Arrays.fill(c, -1);

            return Math.max(0, countCherry(grid, 0, 0, m - 1, dp, n, m));
        }

        private int countCherry(int[][] grid, int i, int j1, int j2, int[][][] dp, int n, int m) {
            if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m) return 0;
            if (i == n - 1) {
                if (j1 == j2) return grid[i][j1];
                else return grid[i][j1] + grid[i][j2];
            }

            if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

            int max = Integer.MIN_VALUE;
            for (int di = -1; di <= 1; di++) {
                for (int dj = -1; dj <= 1; dj++) {
                    int ans = grid[i][j1] + countCherry(grid, i + 1, j1 + di, j2 + dj, dp, n, m);
                    if (j1 != j2)
                        ans += grid[i][j2];
                    max = Math.max(max, ans);
                }
            }
            return dp[i][j1][j2] = max;
        }

        public int cherryPickup2(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][][] dp = new int[n][m][m];

            for (int i = n - 1; i >= 0; i--) {
                for (int j1 = 0; j1 < m; j1++) {
                    for (int j2 = 0; j2 < m; j2++) {
                        if (i == n - 1) {
                            if (j1 == j2) dp[i][j1][j2] = grid[i][j1];
                            else dp[i][j1][j2] = grid[i][j1] + grid[i][j2];
                        } else {
                            int max = Integer.MIN_VALUE;
                            for (int di = -1; di <= 1; di++) {
                                for (int dj = -1; dj <= 1; dj++) {
                                    int ans = (int) -1e9;
                                    if (j1 + di < m && j1 + di >= 0 && j2 + dj < m && j2 + dj >= 0)
                                        ans = grid[i][j1] + dp[i + 1][j1 + di][j2 + dj];
                                    if (j1 != j2)
                                        ans += grid[i][j2];
                                    max = Math.max(max, ans);
                                }
                            }
                            dp[i][j1][j2] = max;
                        }
                    }
                }
            }
            return dp[0][0][m - 1];
        }

        public int cherryPickup3(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][] next = new int[m][m];

            for (int i = n - 1; i >= 0; i--) {
                int[][] curr = new int[m][m];
                for (int j1 = 0; j1 < m; j1++) {
                    for (int j2 = 0; j2 < m; j2++) {
                        if (i == n - 1) {
                            if (j1 == j2) curr[j1][j2] = grid[i][j1];
                            else curr[j1][j2] = grid[i][j1] + grid[i][j2];
                        } else {
                            int max = Integer.MIN_VALUE;
                            for (int di = -1; di <= 1; di++) {
                                for (int dj = -1; dj <= 1; dj++) {
                                    int ans = (int) -1e9;
                                    if (j1 + di < m && j1 + di >= 0 && j2 + dj < m && j2 + dj >= 0)
                                        ans = grid[i][j1] + next[j1 + di][j2 + dj];
                                    if (j1 != j2)
                                        ans += grid[i][j2];
                                    max = Math.max(max, ans);
                                }
                            }
                            curr[j1][j2] = max;
                        }
                    }
                }
                next = curr;
            }
            return next[0][m - 1];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0}, {0, 3, 0, 5, 4, 0, 0}, {1, 0, 2, 3, 0, 0, 6}};
        Out.print(sol.cherryPickup(grid));
        Out.print(sol.cherryPickup2(grid));
        Out.print(sol.cherryPickup3(grid));
    }
}

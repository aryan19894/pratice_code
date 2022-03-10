package com.striver.DSAExperience.T14DP.TwoD_OnGrid;

import com.common.Out;

import java.util.Arrays;

public class CherryPickupII_NinjaAndHisFriends {
    // [Better Recursive] TC: 3powO(N*M*M) * 9:  each cell has 3 directions
    public static int maximumChocolates(int r, int c, int[][] grid) {
        return calcChoco(grid, 0, 0, c - 1, r, c);
    }

    private static int calcChoco(int[][] grid, int i, int j1, int j2, int n, int m) {
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) return 0;
        if (i == n - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        int max = Integer.MIN_VALUE;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int ans = calcChoco(grid, i + 1, j1 + di, j2 + dj, n, m);
                if (j1 == j2)
                    ans += grid[i][j1];
                else
                    ans += grid[i][j1] + grid[i][j2];
                max = Math.max(max, ans);
            }
        }
        return max;
    }

    // [Better DP: Memo] TC: O(N*M*M) * 9: At max, there will be N*M*M calls of recursion to solve a new problem and
    // in every call, two nested loops together run for 9 times.
    // SC: O(N) + O(N*M*M): using a recursion stack space: O((N),
    // using a recursion stack space: O(N), where N is the path length and an external DP Array of size ‘N*M*M’.
    public static int maximumChocolates2(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        for (int[][] a : dp)
            for (int[] b : a)
                Arrays.fill(b, -1);


        return calcChoco2(grid, 0, 0, c - 1, r, c, dp);
    }

    private static int calcChoco2(int[][] grid, int i, int j1, int j2, int n, int m, int[][][] dp) {
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) return 0;
        if (i == n - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int max = Integer.MIN_VALUE;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int ans = calcChoco2(grid, i + 1, j1 + di, j2 + dj, n, m, dp);
                if (j1 == j2)
                    ans += grid[i][j1];
                else
                    ans += grid[i][j1] + grid[i][j2];
                max = Math.max(max, ans);
            }
        }
        return dp[i][j1][j2] = max;
    }

    // [Better DP: Tab] TC: O(N*M*M) * 9: The outer nested loops run for (N*M*M) times and
    // the inner two nested loops run for 9 times.
    // SC: O(N*M*M):  using an external array of size ‘N*M*M’. The stack space will be eliminated.
    public static int maximumChocolates3(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        for (int i = r - 1; i >= 0; i--) {
            for (int j1 = 0; j1 < c; j1++) {
                for (int j2 = 0; j2 < c; j2++) {
                    if (i == r - 1) {
                        if (j1 == j2) dp[i][j1][j2] = grid[i][j1];
                        else dp[i][j1][j2] = grid[i][j1] + grid[i][j2];
                    } else {
                        int max = Integer.MIN_VALUE;
                        for (int di = -1; di <= 1; di++) {
                            for (int dj = -1; dj <= 1; dj++) {
                                int ans = (int) -1e9;
                                if (j1 + di < c && j1 + di >= 0 && j2 + dj < c && j2 + dj >= 0)
                                    ans = dp[i + 1][j1 + di][j2 + dj];
                                if (j1 == j2)
                                    ans += grid[i][j1];
                                else
                                    ans += grid[i][j1] + grid[i][j2];
                                max = Math.max(max, ans);
                            }
                        }
                        dp[i][j1][j2] = max;
                    }
                }
            }
        }

        return dp[0][0][c - 1];
    }

    // [Better DP: Tab] TC: O(N*M*M) * 9: The outer nested loops run for (N*M*M) times and
    // the inner two nested loops run for 9 times.
    // SC: O(M*M):  using an external array of size ‘M*M’.
    public static int maximumChocolates4(int r, int c, int[][] grid) {
        int[][] next = new int[c][c];

        for (int i = r - 1; i >= 0; i--) {
            int[][] curr = new int[c][c];
            for (int j1 = 0; j1 < c; j1++) {
                for (int j2 = 0; j2 < c; j2++) {
                    if (i == r - 1) {
                        if (j1 == j2) curr[j1][j2] = grid[i][j1];
                        else curr[j1][j2] = grid[i][j1] + grid[i][j2];
                    } else {
                        int max = Integer.MIN_VALUE;
                        for (int di = -1; di <= 1; di++) {
                            for (int dj = -1; dj <= 1; dj++) {
                                int ans = (int) -1e9;
                                if (j1 + di < c && j1 + di >= 0 && j2 + dj < c && j2 + dj >= 0)
                                    ans = next[j1 + di][j2 + dj];
                                if (j1 == j2)
                                    ans += grid[i][j1];
                                else
                                    ans += grid[i][j1] + grid[i][j2];
                                max = Math.max(max, ans);
                            }
                        }
                        curr[j1][j2] = max;
                    }
                }
            }
            next = curr;
        }

        return next[0][c - 1];
    }

    public static void main(String[] args) {
        int r = 0;
        int c = 0;
        int[][] grid = {{2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}};
        Out.print(maximumChocolates(3, 4, grid));
        Out.print(maximumChocolates2(3, 4, grid));
        Out.print(maximumChocolates3(3, 4, grid));
        Out.print(maximumChocolates4(3, 4, grid));
    }
}

package com.leetcode.blind75.T4Graph;

import com.common.Out;

public class NumberOfIslands_medium_200 {
    static class Solution {
        private static final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        public int numIslands(char[][] grid) {
            int n = grid.length, m = grid[0].length;
            if (grid == null || n == 0 || m == 0) return 0;

            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        markIsland(grid, i, j, n, m);
                        result++;
                    }
                }
            }

            return result;
        }

        private void markIsland(char[][] grid, int i, int j, int n, int m) {
            if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
            grid[i][j] = '2'; // mark visited

            for (int[] d : dir)
                markIsland(grid, i + d[0], j + d[1], n, m);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        Out.print(sol.numIslands(grid));
    }
}

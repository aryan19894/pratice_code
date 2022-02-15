package com.striver.DSAExperience.T13Graph;

import com.common.Out;

public class NumberOfIslands_medium_200 {
    static class Solution {
        // [Optimal] TC: O(n*m), making recursive on each direction: TOP, DOWN, RIGHT, LEFT
        public int numIslands(char[][] grid) {
            int result = 0;
            int n = grid.length;
            int m = grid[0].length;
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
            if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1')
                return;

            grid[i][j] = '2';
            int r[] = {-1, 1, 0, 0};
            int c[] = {0, 0, -1, 1};

            for (int id = 0; id < 4; id++)
                markIsland(grid, i + r[id], j + c[id], n, m);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] grid = {{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        Out.print(sol.numIslands(grid));
    }
}

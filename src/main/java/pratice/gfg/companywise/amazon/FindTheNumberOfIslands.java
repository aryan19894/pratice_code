package pratice.gfg.companywise.amazon;

import pratice.common.Out;

public class FindTheNumberOfIslands {
    static public class Solution {
        public int numIslands(char[][] grid) {
            int result = 0;
            int n = grid.length;
            int m = grid[0].length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        countIsland(grid, i, j, n, m);
                        result++;
                    }
                }
            }

            return result;
        }

        private void countIsland(char[][] grid, int i, int j, int n, int m) {
            if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;

            grid[i][j] = '2'; //visited;
            int r[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
            int c[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
            for (int k = 0; k < 8; k++)
                countIsland(grid, i + r[k], j + c[k], n, m);
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

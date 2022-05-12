package pratice.leetcode.blind75.T4Graph;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow_medium_417 {
    static class Solution {
        private static final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        public List<List<Integer>> pacificAtlantic(int[][] h) {
            List<List<Integer>> result = new ArrayList<>();
            int row = h.length, col = h[0].length;
            if (h == null || row == 0 || col == 0) return result;
            boolean[][] pacific = new boolean[row][col];
            boolean[][] atlantic = new boolean[row][col];

            //DFS
            for (int i = 0; i < col; i++) {
                dfs(h, 0, i, Integer.MIN_VALUE, row, col, pacific);
                dfs(h, row - 1, i, Integer.MIN_VALUE, row, col, atlantic);
            }

            for (int i = 0; i < row; i++) {
                dfs(h, i, 0, Integer.MIN_VALUE, row, col, pacific);
                dfs(h, i, col - 1, Integer.MIN_VALUE, row, col, atlantic);
            }


            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (pacific[i][j] && atlantic[i][j])
                        result.add(Arrays.asList(i, j));
                }
            }
            return result;
        }

        private void dfs(int[][] h, int i, int j, int prev, int row, int col, boolean[][] ocean) {
            if (i < 0 || j < 0 || i >= row || j >= col) return;
            if (h[i][j] < prev || ocean[i][j]) return;

            ocean[i][j] = true;
            for (int[] d : dir)
                dfs(h, i + d[0], j + d[1], h[i][j], row, col, ocean);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] h = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        Out.print(sol.pacificAtlantic(h));
    }
}

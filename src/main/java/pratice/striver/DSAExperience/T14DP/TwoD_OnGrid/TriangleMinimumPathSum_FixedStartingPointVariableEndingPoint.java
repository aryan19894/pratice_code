package pratice.striver.DSAExperience.T14DP.TwoD_OnGrid;

import pratice.common.Out;

import java.util.Arrays;

public class TriangleMinimumPathSum_FixedStartingPointVariableEndingPoint {
    // [Better DP: Memo] TC: O(N*N):  At max, there will be (half of, due to triangle) N*N calls of recursion.
    // SC: O(N) + O(N*N): using a recursion stack space: O((N),
    // where N is the path length and an external DP Array of size ‘N*N’.
    public static int minimumPathSum(int[][] triangle, int n) {
        int[][] dp = new int[n][n];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return findMinPathSum(triangle, 0, 0, n, dp);
    }

    private static int findMinPathSum(int[][] triangle, int i, int j, int n, int[][] dp) {
        if (i == n - 1) return triangle[i][j];
        if (dp[i][j] != -1) return dp[i][j];

        int down = triangle[i][j] + findMinPathSum(triangle, i + 1, j, n, dp);
        int diagonal = triangle[i][j] + findMinPathSum(triangle, i + 1, j + 1, n, dp);
        return dp[i][j] = Math.min(down, diagonal);
    }

    // [Better DP: Tab] TC: O(N*N): two nested loops
    // SC: O(N*N): using an external DP Array of size ‘N*N’.
    public static int minimumPathSum2(int[][] triangle, int n) {
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++)
            dp[n - 1][j] = triangle[n - 1][j];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + dp[i + 1][j];
                int diagonal = triangle[i][j] + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }

    // [Better DP: Tab] TC: O(N*N): two nested loops
    // SC: O(N): using an external array of size ‘N’ to store only one row.
    public static int minimumPathSum3(int[][] triangle, int n) {
        int[] next = new int[n];
        for (int j = 0; j < n; j++)
            next[j] = triangle[n - 1][j];

        for (int i = n - 2; i >= 0; i--) {
            int[] curr = new int[n];
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + next[j];
                int diagonal = triangle[i][j] + next[j + 1];
                curr[j] = Math.min(down, diagonal);
            }
            next = curr;
        }
        return next[0];
    }

    public static void main(String[] args) {
        int[][] triangle = {{1}, {2, 3}, {3, 6, 7}, {8, 9, 6, 10}};
        Out.print(minimumPathSum(triangle, triangle.length));
        Out.print(minimumPathSum2(triangle, triangle.length));
        Out.print(minimumPathSum3(triangle, triangle.length));
    }
}

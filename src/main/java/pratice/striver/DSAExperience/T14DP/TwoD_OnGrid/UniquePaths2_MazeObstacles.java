package pratice.striver.DSAExperience.T14DP.TwoD_OnGrid;

import pratice.common.Out;
import pratice.common.converter.Array;

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePaths2_MazeObstacles {
    private static final int MOD = 1000000007;

    // [Better DP: Memo] TC: O(M*N):  At max, there will be M*N calls of recursion.
    // SC: O((N-1)+(M-1)) + O(M*N): using a recursion stack space:O((N-1)+(M-1)),
    // here (N-1)+(M-1) is the path length and an external DP Array of size ‘M*N’.
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[][] dp = new int[n][m];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return countPath(n - 1, m - 1, mat, dp);
    }

    private static int countPath(int i, int j, ArrayList<ArrayList<Integer>> mat, int[][] dp) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0 || mat.get(i).get(j) == -1) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = (countPath(i - 1, j, mat, dp) + countPath(i, j - 1, mat, dp)) % MOD;
    }

    // [Better DP: Tab] TC: O(M*N): two nested loops
    // SC: O(M*N): using an external DP Array of size ‘M*N’.
    static int mazeObstacles2(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (mat.get(i).get(j) == -1) continue;

                int up = 0, left = 0;
                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 0];
                dp[i][j] = (up + left) % MOD;
            }
        }
        return dp[n - 1][m - 1];
    }

    // [Better DP: Tab] TC: O(M*N): two nested loops
    // SC: O(N): using an external array of size ‘N’ to store only one row.
    static int mazeObstacles3(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int prev[] = new int[m];
        for (int i = 0; i < n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = 1;
                    continue;
                }
                if (mat.get(i).get(j) == -1) continue;

                int up = 0, left = 0;
                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = curr[j - 1];
                curr[j] = (up + left) % MOD;
            }
            prev = curr;
        }
        return prev[m - 1];
    }

    public static void main(String[] args) {
        int n = 0;
        int m = 0;
        ArrayList<ArrayList<Integer>> mat = Array.toList(new int[][]{
                {0, 0, -1},
                {0, -1, 0}
        });
        Out.print(mazeObstacles(mat.size(), mat.get(0).size(), mat));
        Out.print(mazeObstacles2(mat.size(), mat.get(0).size(), mat));
        Out.print(mazeObstacles3(mat.size(), mat.get(0).size(), mat));
    }
}

package com.striver.DSAExperience.Day10RecursionBacktracking;

import com.common.Printer;

import java.util.ArrayList;
import java.util.List;

public class RatInAMazeProblemI_Medium {
    // [Optimal Recursive] TC: O(4powN*M) = check each cell with all 4 directions
    // SC: O(n*m) - created a visited array, there could be chance of visit to all cell.(Worst case)
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        if (m[0][0] == 1) solve(0, 0, n, m, res, "", visited);
        return res;
    }

    private static void solve(int i, int j, int n, int[][] m, ArrayList<String> res,
                              String move, boolean[][] visited) {
        if (i == n - 1 && j == n - 1) {
            res.add(move);
            return;
        }

        if (isSafe(i + 1, j, m, visited)) {     //down
            visited[i][j] = true;
            solve(i + 1, j, n, m, res, move + 'D', visited);
            visited[i][j] = false;
        }
        if (isSafe(i, j - 1, m, visited)) {      //left
            visited[i][j] = true;
            solve(i, j - 1, n, m, res, move + 'L', visited);
            visited[i][j] = false;
        }
        if (isSafe(i, j + 1, m, visited)) {      //right
            visited[i][j] = true;
            solve(i, j + 1, n, m, res, move + 'R', visited);
            visited[i][j] = false;
        }
        if (isSafe(i - 1, j, m, visited)) {      //up
            visited[i][j] = true;
            solve(i - 1, j, n, m, res, move + 'U', visited);
            visited[i][j] = false;
        }
    }

    private static boolean isSafe(int i, int j, int[][] m,
                                  boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m.length || j >= m.length) return false;
        if (visited[i][j]) return false;
        if (m[i][j] == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};

        ArrayList<String> ans = findPath(m, m.length);
        Printer.print(ans);
    }
}

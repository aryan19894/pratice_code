package revise._2024.striver.graph;

import common.Out;

public class ReplaceOWithX {
    static char[][] fill(int n, int m, char a[][]) {
        int[] DIR = {0, 1, 0, -1, 0};
        boolean[][] visited = new boolean[n][m];

        //1st row & last row
        for (int j = 0; j < m; j++) {
            int i = 0;
            if (!visited[i][j] && a[i][j] == 'O') dfs(a, i, j, n, m, visited, DIR);
            i = n - 1;
            if (!visited[i][j] && a[i][j] == 'O') dfs(a, i, j, n, m, visited, DIR);
        }
        //1st col & last col
        for (int i = 0; i < n; i++) {
            int j = 0;
            if (!visited[i][j] && a[i][j] == 'O') dfs(a, i, j, n, m, visited, DIR);
            j = m - 1;
            if (!visited[i][j] && a[i][j] == 'O') dfs(a, i, j, n, m, visited, DIR);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && a[i][j] == 'O')
                    a[i][j] = 'X';
            }
        }

        return a;
    }

    private static void dfs(char[][] a, int i, int j, int n, int m, boolean[][] visited, int[] DIR) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int ni = i + DIR[k], nj = j + DIR[k + 1];
            if (nj < 0 || ni < 0 || ni == n || nj == m ||
                    visited[ni][nj] || a[ni][nj] == 'X')
                continue;
            dfs(a, ni, nj, n, m, visited, DIR);
        }
    }

    public static void main(String[] args) {
        char[][] mat = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};
        Out.print(fill(5, 4, mat));
    }

}

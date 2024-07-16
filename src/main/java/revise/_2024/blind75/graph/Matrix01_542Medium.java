package revise._2024.blind75.graph;

import common.Out;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01_542Medium {
    static class Pair {
        int r, c, dist;

        public Pair(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "[" + r + "," + c + "]" +
                    ", dist=" + dist;
        }
    }

    static int[][] updateMatrix(int[][] arr, int find) {
        int[] rPrefix = {-1, 0, 1, 0};
        int[] cPrefix = {0, 1, 0, -1};
        int n = arr.length;
        int m = arr[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == find) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.r, c = curr.c;
            dist[r][c] = curr.dist;

            for (int k = 0; k < 4; k++) {
                int newR = r + rPrefix[k];
                int newC = c + cPrefix[k];

                if (newC < 0 || newR < 0 || newR == n || newC == m ||
                        visited[newR][newC] || arr[newR][newC] == find)
                    continue;

                q.add(new Pair(newR, newC, curr.dist + 1));
                visited[newR][newC] = true;
            }
        }
        return dist;
    }

    private static int[][] updateMatrixOptimized(int[][] arr) {
        int[] DIR = {0, 1, 0, -1, 0};
        int n = arr.length;
        int m = arr[0].length;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) q.offer(new int[]{i, j});
                else arr[i][j] = -1; //represent not visited yet
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + DIR[k];
                int nc = c + DIR[k + 1];

                if (nc < 0 || nr < 0 || nr == n || nc == m || arr[nr][nc] != -1)
                    continue;

                arr[nr][nc] = arr[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
        };
        Out.print(updateMatrix(arr, 0));
        Out.print(updateMatrixOptimized(arr));
    }
}

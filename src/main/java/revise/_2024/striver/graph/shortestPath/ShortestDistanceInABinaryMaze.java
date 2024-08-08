package revise._2024.striver.graph.shortestPath;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInABinaryMaze {
    static int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;
        int sr = source[0], sc = source[1];
        int dr = destination[0], dc = destination[1];
        int[] DIR = {0, 1, 0, -1, 0};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc, 0});
        grid[sr][sc] = -1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0], j = curr[1], steps = curr[2];
            if (i == dr && j == dc) return steps;

            for (int k = 0; k < 4; k++) {
                int ni = i + DIR[k], nj = j + DIR[k + 1];
                if (ni < 0 || nj < 0 || ni == n || nj == m || grid[ni][nj] == 0 || grid[ni][nj] == -1) continue;
                grid[ni][nj] = -1;
                q.add(new int[]{ni, nj, steps + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int grid[][] = {{1},{1},{1},{0},{0}};
        int[] source = {2, 0}, destination = {1, 0};

        System.out.println(shortestPath(grid, source, destination));
    }
}

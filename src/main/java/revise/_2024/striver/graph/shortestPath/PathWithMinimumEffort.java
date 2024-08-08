package revise._2024.striver.graph.shortestPath;

import lombok.ToString;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {
    private static final int INF = (int) (1e9);

    //0.73
    public static int MinimumEffort(int n, int m, int[][] heights) {
        int sr = 0, sc = 0;
        int dr = n - 1, dc = m - 1;
        int[] DIR = {0, 1, 0, -1, 0};
        int[][] steps = new int[n][m];
        for (int[] row : steps)
            Arrays.fill(row, INF);
        steps[sr][sc] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0], j = curr[1], diff = curr[2];

            for (int k = 0; k < 4; k++) {
                int ni = i + DIR[k], nj = j + DIR[k + 1];
                if (ni < 0 || nj < 0 || ni == n || nj == m) continue;
                int newEffort = Math.max(diff, Math.abs(heights[ni][nj] - heights[i][j]));
                if (steps[ni][nj] > newEffort) {
                    steps[ni][nj] = newEffort;
                    q.add(new int[]{ni, nj, newEffort});
                }
            }
        }

        return steps[dr][dc] == INF ? 0 : steps[dr][dc];
    }

    @ToString
    static class Tuple implements Comparable<Tuple> {
        int dist;
        int row;
        int col;

        public Tuple(int dist, int row, int col) {
            this.dist = dist;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Tuple other) {
            return Integer.compare(this.dist, other.dist);
        }
    }

    //0.32
    public static int MinimumEffortByDijkstra(int n, int m, int[][] heights) {
        int sr = 0, sc = 0;
        int[] DIR = {0, 1, 0, -1, 0};
        int[][] steps = new int[n][m];
        for (int[] row : steps)
            Arrays.fill(row, INF);
        steps[sr][sc] = 0;

        PriorityQueue<Tuple> q = new PriorityQueue<>();
        q.add(new Tuple(0, sr, sc));

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            int i = tuple.row, j = tuple.col, diff = tuple.dist;

            if (i == n - 1 && j == m - 1) return steps[i][j];

            for (int k = 0; k < 4; k++) {
                int ni = i + DIR[k], nj = j + DIR[k + 1];
                if (ni < 0 || nj < 0 || ni == n || nj == m) continue;

                int newEffort = Math.max(diff, Math.abs(heights[ni][nj] - heights[i][j]));
                if (steps[ni][nj] > newEffort) {
                    steps[ni][nj] = newEffort;
                    q.add(new Tuple(newEffort, ni, nj));
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
//        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        int[][] heights = {{3, 8, 10, 6, 5},
                {4, 2, 3, 4, 4},
                {5, 2, 2, 4, 9},
                {8, 5, 3, 8, 8}};
        int rows = 4, columns = 5;

        System.out.println(MinimumEffort(rows, columns, heights));
        System.out.println(MinimumEffortByDijkstra(rows, columns, heights));
    }


    static int MinimumEffort(int heights[][]) {

        // Create a priority queue containing pairs of cells
        // and their respective distance from the source cell in the
        // form {diff, {row of cell, col of cell}}.
//        PriorityQueue<Tuple> pq =
//                new PriorityQueue<Tuple>((x, y) -> x.distance - y.distance);
        Queue<Tuple> pq = new LinkedList<>();

        int n = heights.length;
        int m = heights[0].length;

        // Create a distance matrix with initially all the cells marked as
        // unvisited and the dist for source cell (0,0) as 0.
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) (1e9);
            }
        }

        dist[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));

        // The following delta rows and delts columns array are created such that
        // each index represents each adjacent node that a cell may have
        // in a direction.
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};

        // Iterate through the matrix by popping the elements out of the queue
        // and pushing whenever a shorter distance to a cell is found.
        while (pq.size() != 0) {
            Tuple it = pq.peek();
            pq.remove();
            int diff = it.dist;
            int row = it.row;
            int col = it.col;

            // Check if we have reached the destination cell,
            // return the current value of difference (which will be min).
//            if (row == n - 1 && col == m - 1) return diff;
            // row - 1, col
            // row, col + 1
            // row - 1, col
            // row, col - 1
            for (int i = 0; i < 4; i++) {
                int newr = row + dr[i];
                int newc = col + dc[i];

                // Checking validity of the cell.
                if (newr >= 0 && newc >= 0 && newr < n && newc < m) {

                    // Effort can be calculated as the max value of differences
                    // between the heights of the node and its adjacent nodes.
                    int newEffort =
                            Math.max(
                                    Math.abs(heights[row][col] - heights[newr][newc]), diff);

                    // If the calculated effort is less than the prev value
                    // we update as we need the min effort.
                    if (newEffort < dist[newr][newc]) {
                        dist[newr][newc] = newEffort;
                        pq.add(new Tuple(newEffort, newr, newc));
                    }
                }
            }
        }
        // If the destination is unreachable.
        return dist[n - 1][m - 1];
    }

}

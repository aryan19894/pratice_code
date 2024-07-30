package revise._2024.striver.graph.shortestPath;

import java.util.PriorityQueue;

public class SwimInRisingWater_778Hard {
    static class Pair {
        int r, c, time;

        public Pair(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    private static int[] DIR = {0, 1, 0, -1, 0};

    static public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.time, b.time)
        );
        pq.add(new Pair(0, 0, grid[0][0]));
        visited[0][0] = true;

        int totalDuration = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (curr.r == n - 1 && curr.c == n - 1)
                totalDuration = Math.min(totalDuration, curr.time);

            for (int i = 0; i < 4; i++) {
                int r = curr.r + DIR[i], c = curr.c + DIR[i + 1];
                if (r < 0 || c < 0 || r == n | c == n || visited[r][c]) continue;

                visited[r][c] = true;
                pq.add(new Pair(r, c, Math.max(curr.time, grid[r][c])));
            }
        }
        return totalDuration;
    }

    public static void main(String[] args) {
//        int[][] grid = {{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}};
        int[][] grid = {{3, 2}, {0, 1}};
        System.out.println(swimInWater(grid));
    }
}

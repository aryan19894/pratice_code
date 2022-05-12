package pratice.striver.DSAExperience.T9StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_medium_994 {
    static class Solution {
        // [Optimal] TC: O(n2*4), SC: O(n2) - 4 is for checking in all 4 direction and n2 ids to traverse to each cell.
        public int orangesRotting(int[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            int rows = grid.length;
            int cols = grid[0].length;
            Queue<int[]> q = new LinkedList<>();
            int count_fresh = 0;

            //Put the position of all rotten oranges in queue
            //count the number of fresh oranges
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 2)
                        q.offer(new int[]{i, j});
                    if (grid[i][j] != 0) count_fresh++;
                }
            }

            if (count_fresh == 0) return 0;
            int countMin = 0, cnt = 0;
            int dx[] = {0, 0, 1, -1};
            int dy[] = {1, -1, 0, 0};

            //bfs starting from initially rotten oranges
            while (!q.isEmpty()) {
                int size = q.size();
                cnt += size;
                for (int i = 0; i < size; i++) {
                    int[] cell = q.poll();
                    for (int j = 0; j < 4; j++) {
                        int x = cell[0] + dx[j];
                        int y = cell[1] + dy[j];

                        if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;

                        grid[x][y] = 2;
                        q.offer(new int[]{x, y});
                    }
                }
                if (!q.isEmpty()) countMin++;
            }
            return count_fresh == cnt ? countMin : -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        0: empty,
//        1: fresh
//        2: rotten
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(sol.orangesRotting(grid));
    }
}

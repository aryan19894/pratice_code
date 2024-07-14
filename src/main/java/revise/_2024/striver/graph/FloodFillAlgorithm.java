package revise._2024.striver.graph;

import common.Out;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFillAlgorithm {
    static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;
        int[] DIR = {0, 1, 0, -1, 0};

        int initialColor = image[sr][sc];
        image[sr][sc] = newColor;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + DIR[i], nc = curr[1] + DIR[i + 1];
                if (nr < 0 || nc < 0 || nr == n || nc == m ||
                        image[nr][nc] != initialColor||
                        image[nr][nc] == newColor)
                    continue;
                image[nr][nc] = newColor;
                q.add(new int[]{nr, nc});
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        Out.print(floodFill(image, 1, 1, 2));
    }
}

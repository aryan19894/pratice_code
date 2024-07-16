package revise._2024.blind75.graph;

import common.Out;

public class FloodFill_733Easy {
    static int[][] floodFill(int[][] arr, int sr, int sc, int color) {
        int initialColor = arr[sr][sc];
        floodFillUtil(arr, sr, sc, arr.length, arr[0].length, initialColor, color);
        return arr;
    }

    private static void floodFillUtil(int[][] arr, int sr, int sc, int r, int c, int initialColor, int newColor) {
        if (sr < 0 || sr >= r || sc < 0 || sc >= c || initialColor == newColor) {
            return;
        }

        if (arr[sr][sc] == initialColor) {
            arr[sr][sc] = newColor;
            floodFillUtil(arr, sr + 1, sc, r, c, initialColor, newColor);
            floodFillUtil(arr, sr - 1, sc, r, c, initialColor, newColor);
            floodFillUtil(arr, sr, sc + 1, r, c, initialColor, newColor);
            floodFillUtil(arr, sr, sc - 1, r, c, initialColor, newColor);
        }
    }

    public static void main(String[] args) {
        int[][] image = {
                {0, 0, 0},
                {0, 0, 0},
        };
        Out.print(floodFill(image, 0, 0, 0));
    }
}

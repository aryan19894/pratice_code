package companyOA.Interview.PayPal;

public class CountOfIsland {

    private static final int r = 5;
    private static final int c = 5;

    public static boolean isSafe(int[][] ins, int i, int j, boolean[][] v) {
        return (i >= 0) && (i < r) && (j >= 0) && (j < c) && (ins[i][j] == 1 && !v[i][j]);
    }

    public static void dfs(int[][] ins, int i, int j, boolean[][] v) {
        int[] rNum = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] cNum = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        if (i == r)
            i %= r;
        else if (i < 0)
            i += r;

        if (j == c)
            j %= c;
        else if (j < 0)
            j += c;

        v[i][j] = true;

        for (int k = 0; k < 8; k++) {
            if (isSafe(ins, i + rNum[k], j + cNum[k], v))
                dfs(ins, i + rNum[k], j + cNum[k], v);
        }
    }

    public static int countIsland(int[][] islands) {
        boolean[][] visited = new boolean[r][c];

        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (islands[i][j] == 1 && !visited[i][j]) {
                    dfs(islands, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] islands = new int[][]{{1, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0}};

        System.out.println(countIsland(islands));
    }

}

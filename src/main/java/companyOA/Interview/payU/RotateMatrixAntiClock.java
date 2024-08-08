package companyOA.Interview.payU;

class RotateMatrixAntiClock {
    public static void main(String[] args) {
        int n = 5;
        int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};

        rotateMatrix(arr, n);
        display(arr, n);
    }

    private static int[][] rotateMatrix(int[][] a, int n) {
        for (int i = 0; i < n / 2; i++) {
            int idx = n - 1 - i;
            for (int j = i; j < idx; j++) {
                int idy = n - 1 - j;
                int temp = a[i][j];

                a[i][j] = a[j][idx]; // right to top
                a[j][idx] = a[idx][idy]; // bottom to right
                a[idx][idy] = a[idy][i]; // left to bottom
                a[idy][i] = temp; // temp to left
            }
        }
        return a;
    }

    private static void display(int[][] a, int n) {
        for (int[] r : a) {
            for (int d : r) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }
}
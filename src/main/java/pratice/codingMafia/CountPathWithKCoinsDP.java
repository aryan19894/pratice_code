package pratice.codingMafia;

import java.util.Scanner;

public class CountPathWithKCoinsDP {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = scn.nextInt();
			}
		}

		int k = scn.nextInt();

		System.out.println(countPath(arr, m, n, k));
	}

	private static int countPath(int[][] arr, int m, int n, int k) {
		return countPathRec(arr, m - 1, n - 1, k);
	}

	private static int countPathRec(int[][] arr, int m, int n, int k) {
		if (n < 0 || m < 0)
			return 0;
		if (n == 0 && m == 0 && (k == arr[m][n]))
			return 1;

		return countPathRec(arr, m - 1, n, k - arr[m][n]) + countPathRec(arr, m, n - 1, k - arr[m][n]);
	}

}

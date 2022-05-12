package pratice.codingMafia;

import java.util.Scanner;

public class CountPathWithKCoins2 {
	static final int R = 3;
	static final int C = 3;

	public static void main(String[] args) {
		int k = 12;
		int mat[][] = { { 1, 2, 3 }, { 4, 6, 5 }, { 3, 2, 1 } };
		System.out.println(pathCount(mat, k));
	}

	static int pathCountRec(int mat[][], int m, int n, int k) {
		// Base cases
		if (m < 0 || n < 0) {
			return 0;
		}
		if (m == 0 && n == 0 && (k == mat[m][n])) {
			return 1;
		}

		// (m, n) can be reached either through (m-1, n) or
		// through (m, n-1)
		return pathCountRec(mat, m - 1, n, k - mat[m][n]) + pathCountRec(mat, m, n - 1, k - mat[m][n]);
	}

	// A wrapper over pathCountRec()
	static int pathCount(int mat[][], int k) {
		return pathCountRec(mat, R - 1, C - 1, k);
	}

}

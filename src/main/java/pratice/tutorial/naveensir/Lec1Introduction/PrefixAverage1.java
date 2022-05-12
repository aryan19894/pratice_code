package pratice.tutorial.naveensir.Lec1Introduction;

import java.util.Arrays;

public class PrefixAverage1 {
	public static void main(String args[]) {
		int[] X = { 5, 8, 4, 1, 12, 44 };
		System.out.println(Arrays.toString(X));
		int[] A = prefixAverageN2(X);
		System.out.println(Arrays.toString(A));
		A = prefixAverageN(X);
		System.out.println(Arrays.toString(A));
	}

	private static int[] prefixAverageN(int[] X) {
		int[] A = new int[X.length];
		int sum = 0;
		for (int i = 0; i < X.length; i++) {
			sum += X[i];
			A[i] = sum / (i + 1);
		}

		return A;
	}

	private static int[] prefixAverageN2(int[] X) {
		int[] A = new int[X.length];
		int i = 0;
		while (i < X.length) {
			int sum = 0;
			for (int j = i; j >= 0; j--) {
				sum += X[j];
			}
			A[i] = sum / (i + 1);
			i++;
		}
		return A;
	}
}

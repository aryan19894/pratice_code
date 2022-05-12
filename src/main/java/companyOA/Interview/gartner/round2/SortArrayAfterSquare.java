package companyOA.Interview.gartner.round2;

public class SortArrayAfterSquare {
	public static void main(String[] args) {
		int[] n = { -20, -10, -5, 0, 6, 7, 9, 12 };
		sortSquares(n);
		for (int x : n) {
			System.out.print(x + " ");
		}
	}

	private static void sortSquares(int[] arr) {
		int n = arr.length;
		int k; // first index after negative number means work like border
				// between +ve & -ve
		for (k = 0; k < n; k++) {
			if (arr[k] >= 0)
				break;
		}

		// merge two sorted array
		// 1. -ve number square
		// 2. +ve number square
		int i = k - 1;
		int j = k;
		int ind = 0; // temp array index
		int[] temp = new int[n];

		while (i >= 0 && j < n) {
			int sqi = arr[i] * arr[i];
			int sqj = arr[j] * arr[j];

			if (sqi < sqj) {
				temp[ind] = sqi;
				i--;
			} else {
				temp[ind] = sqj;
				j++;
			}
			ind++;
		}

		while (i >= 0) {
			int sqi = arr[i] * arr[i];
			temp[ind++] = sqi;
			i--;
		}

		while (j < n) {
			int sqj = arr[j] * arr[j];
			temp[ind++] = sqj;
			j++;
		}

		for (k = 0; k < n; k++) {
			arr[k] = temp[k];
		}
	}
}

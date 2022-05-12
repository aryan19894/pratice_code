package companyOA.hackerrank.salesforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RectangularSum {

	static int rectangularSum(List<List<Integer>> matrix, String coord1, String coord2) {
		int N = matrix.size();
		int M = matrix.get(0).size();
		int[][] cache = new int[N][M];

		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += matrix.get(i).get(j);
				cache[i][j] = sum;
			}
		}
		for (int i = 1; i < N; i++) {
			for (int j = M - 1; j >= 0; j--) {
				cache[i][j] += cache[i - 1][j];
			}
		}

		String[] sij = coord1.split(",");
		String[] eij = coord2.split(",");

		int si = Integer.parseInt(sij[0]);
		int sj = Integer.parseInt(sij[1]);
		int ei = Integer.parseInt(eij[0]);
		int ej = Integer.parseInt(eij[1]);

		int sum = cache[ei][ej];
		if (si > 0)
			sum -= cache[si - 1][ej];
		if (sj > 0)
			sum -= cache[ei][sj - 1];
		if (si > 0 && sj > 0)
			sum += cache[si - 1][sj - 1];
		return sum;
	}

	// Driver Code
	public static void main(String[] args) {
		List<List<Integer>> matrix = new ArrayList<>();
		List<Integer> ref = Arrays.asList(1, 2, 3, 4);
		matrix.add(ref);
		ref = Arrays.asList(5, 6, 7, 8);
		matrix.add(ref);
		ref = Arrays.asList(8, 7, 6, 5);
		matrix.add(ref);
		ref = Arrays.asList(4, 3, 2, 1);
		matrix.add(ref);

		System.out.println(rectangularSum(matrix, "0,0", "0,3"));
	}

}

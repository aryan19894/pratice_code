package companyOA.Interview.microsoft.round1;

import java.util.SortedSet;
import java.util.TreeSet;

public class MaxOfDiffMinMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 4, 9000, 1155 };
		System.out.println(DiffMinMax.findVal(arr));
	}
}

class DiffMinMax {
	public static int findVal(int[] arr) {
		SortedSet<Integer> ss = new TreeSet<>();
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			if (arr[i] % 2 != 0)
				arr[i] *= 2;
			ss.add(arr[i]);
		}

		int max = ss.last();
		while (max % 2 == 0) {
			ss.remove(max);
			max /= 2;
			ss.add(max);
			max = ss.last();
		}

		return max - ss.first();
	}
}
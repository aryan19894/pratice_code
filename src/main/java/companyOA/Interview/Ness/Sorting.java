package companyOA.Interview.Ness;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 10, 2, 5, 6, 7 };
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					// swapping
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}

	}

}

package companyOA.Interview.Pallete.OCTanner;

import java.util.Scanner;

public class ArraySumPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int x = sc.nextInt();
		int min = Integer.MAX_VALUE;
		String ans = "";
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int sum = a[i] + a[j];
				if (min > Math.abs(x - sum)) {
					min = x - sum;
					ans = a[i] + " " + a[j];
				}
			}
		}

		System.out.println("Answer: " + ans);
	}

}

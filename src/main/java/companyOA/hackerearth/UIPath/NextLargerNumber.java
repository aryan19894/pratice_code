package companyOA.hackerearth.UIPath;

public class NextLargerNumber {

	static void printArray(int arr[]) {
		for (int i : arr)
			System.out.print(i + " ");
	}

	public static void main(String[] args) {
		int arr[] = { 16, 17, 4, 3, 5, 2 };
		nextGreatest(arr.length, arr);
		System.out.println("The modified array:");
		printArray(arr);
	}

	private static void nextGreatest(int n, int[] arr) {
		int maxRight = arr[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			if (maxRight < arr[i])
				maxRight = arr[i];
			else
				arr[i] = maxRight;
		}
	}
}

package pratice.tutorial.naveensir.Lec1Introduction;

import java.util.Arrays;

public class InsertionSort1 {
	public static void main(String[] args) {
		int[] arr = { 5, 8, 4, 1, 12, 44, 332, 12 };
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void insertionSort(int[] arr) {
		for (int j = 1; j < arr.length; j++) {
			int key = arr[j];
			int i = j - 1;
			while (i >= 0 && arr[i] > key)
				arr[i + 1] = arr[i--];
			arr[i + 1] = key;
		}
	}
}

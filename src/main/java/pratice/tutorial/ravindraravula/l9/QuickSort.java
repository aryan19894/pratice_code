package pratice.tutorial.ravindraravula.l9;

import other.common.Common;
import pratice.common.Out;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 3, 4, 6, 8, 9, 7, 2, 5, 1 };
		//int a[] = { 9, 6, 3, 5 };
		System.out.println("Before Sorting: ");
		Out.print(a);
		// a = insertionSortMyself(a);
		quickSortMyself(a, 0, a.length - 1);
		System.out.println("After Sorting: ");
		Out.print(a);
	}

	private static void quickSortMyself(int[] arr, int l, int h) {
		// TODO Auto-generated method stub
		if (l < h) {
			int pi = partition(arr, l, h);

			quickSortMyself(arr, l, pi - 1);
			quickSortMyself(arr, pi + 1, h);
		}
	}

	private static int partition(int[] arr, int l, int h) {
		// TODO Auto-generated method stub
		int pi = arr[h];
		int i = l - 1;
		for (int j = l; j <= h - 1; j++) {
			if (arr[j] < pi) {
				int ref = arr[++i];
				arr[i] = arr[j];
				arr[j] = ref;
			}
		}
		int ref = arr[i+1];
		arr[i+1] = arr[h];
		arr[h] = ref;
		
		return (i+1);
	}
}

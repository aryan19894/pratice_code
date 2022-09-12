package pratice.tutorial.ravindraravula.sorting;

import pratice.common.Out;

public class MergeSort {
    public static void main(String[] args) {
        int a[] = {9, 6, 5, 0, 8, 2, 7, 1, 3};
        System.out.println("Before Sorting: ");
        Out.print(a);
        mergeSort(a, 0, a.length-1);
        System.out.println("After Sorting Iterative: ");
        Out.print(a);
//
//        a = new int[]{9, 6, 5, 0, 8, 2, 7, 1, 3};
//        System.out.println("Before Sorting: ");
//        Out.print(a);
//        insertionSort(a, 1, a.length);
//        System.out.println("After Sorting Recursive: ");
//        Out.print(a);
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    private static void merge(int[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) left[i] = a[l + i];
        for (int j = 0; j < n2; j++) right[j] = a[m + 1 + j];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) a[k] = left[i++];
            else a[k] = right[j++];
            k++;
        }
        while (i < n1)
            a[k++] = left[i++];
        while (j < n2)
            a[k++] = right[j++];
    }
}

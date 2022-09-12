package pratice.tutorial.ravindraravula.sorting;

import pratice.common.Out;

public class QuickSort {
    public static void main(String[] args) {
//        int a[] = {9, 6, 5, 0, 8, 2, 4, 7};
        int a[] = {13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11};
        System.out.println("Before Sorting: ");
        Out.print(a);
        quickSort(a, 0, a.length - 1);
        System.out.println("After Sorting Iterative: ");
        Out.print(a);
    }

    private static void quickSort(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quickSort(a, p, q - 1);
            quickSort(a, q + 1, r);
        }
    }

    private static int partition(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        for (int j = p; j <= (r - 1); j++) {
            if (a[j] <= x)
                swap(a, ++i, j);
        }
        swap(a, ++i, r);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int ref = a[i];
        a[i] = a[j];
        a[j] = ref;
    }
}

package pratice.tutorial.ravindraravula.sorting;

import pratice.common.Out;

public class InsertionSort {
    public static void main(String[] args) {
        int a[] = {9, 6, 5, 0, 8, 2, 7, 1, 3};
        System.out.println("Before Sorting: ");
        Out.print(a);
        insertionSort(a, a.length);
        System.out.println("After Sorting: ");
        Out.print(a);
    }

    private static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int pick = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > pick)
                a[j + 1] = a[j--];
            a[j + 1] =pick;
        }
    }
}

package pratice.tutorial.ravindraravula.sorting;

import pratice.common.Out;

public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {10, 50, 20, 40, 60, 70, 15};
        System.out.println("Before Sorting: ");
        Out.print(a);
        bubbleSort(a, a.length);
        System.out.println("After Sorting Iterative: ");
        Out.print(a);
    }

    private static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            boolean swapReq = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swapReq = true;
                }
            }
            if (!swapReq)
                break;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int ref = a[i];
        a[i] = a[j];
        a[j] = ref;
    }
}

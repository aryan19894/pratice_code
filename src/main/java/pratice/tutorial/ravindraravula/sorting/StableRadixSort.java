package pratice.tutorial.ravindraravula.sorting;

import pratice.common.Out;

public class StableRadixSort {
    public static void main(String[] args) {
        int a[] = {804, 26, 5, 64, 52, 1};
        System.out.println("Before Sorting: ");
        Out.print(a);
        radixSort(a, a.length);
        System.out.println("After Sorting Iterative: ");
        Out.print(a);
    }

    private static void radixSort(int[] a, int n) {
        int max = getMax(a);

        for (int div = 1; max / div > 0; div *= 10)
            countingSort(a, n, div);
    }

    private static int getMax(int[] a) {
        int max = a[0];
        for (int e : a)
            max = Math.max(max, e);
        return max;
    }

    private static void countingSort(int[] arr, int n, int div) {
        int[] out = new int[n];
        int[] count = new int[10];

        for (int a : arr) {
            int d = (a / div) % 10;
            count[d]++;
        }

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            int d = (arr[i] / div) % 10;
            count[d]--;
            out[count[d]] = arr[i];
        }

        for (int i = 0; i < n; i++)
            arr[i] = out[i];
    }

}

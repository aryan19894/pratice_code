package pratice.tutorial.ravindraravula.sorting;

import pratice.common.Out;

public class StableCountingSort {
    public static void main(String[] args) {
        int a[] = {5, 3, 5, 5, 9, 7, 5, 9, 5, 4};
        System.out.println("Before Sorting: ");
        Out.print(a);
        a = stableCountingSort(a, a.length);
        System.out.println("After Sorting Iterative: ");
        Out.print(a);
    }

    private static int[] stableCountingSort(int[] arr, int n) {
        int[] val = getMinMax(arr);
        int min = val[0], max = val[1];

        int k = (max - min) + 1;
        int count[] = new int[k];
        int sort[] = new int[n];

        for (int a : arr)
            count[a - min]++;

        for (int i = 1; i < k; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            count[arr[i] - min]--;
            sort[count[arr[i] - min]] = arr[i];
        }
        return sort;
    }

    private static int[] getMinMax(int[] arr) {
        int min, max;
        min = max = arr[0];
        for (int a : arr) {
            if (a < min)
                min = a;
            if (a > max)
                max = a;
        }
        return new int[]{min, max};
    }
}

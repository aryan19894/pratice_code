package pratice.tutorial.ravindraravula.sorting;

import pratice.common.Out;

import java.util.TreeMap;

public class CountingSort {
    public static void main(String[] args) {
        int a[] = {5, 1, 1, 2, 2, 2, 3, 5, 5};
        System.out.println("Before Sorting: ");
        Out.print(a);
        countingSort(a, a.length);

        System.out.println("After Sorting Iterative: ");
        Out.print(a);
    }

    private static void countingSort(int[] arr, int n) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int a : arr)
            map.put(a, map.getOrDefault(a, 0) + 1);

        int i = 0;
        for (int k : map.keySet()) {
            for (int j = 0; j < map.get(k); j++)
                arr[i++] = k;
        }
    }
}

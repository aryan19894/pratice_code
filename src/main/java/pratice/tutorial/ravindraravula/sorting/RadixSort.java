package pratice.tutorial.ravindraravula.sorting;

import pratice.common.Out;

import java.util.LinkedHashSet;

public class RadixSort {
    public static void main(String[] args) {
        int a[] = {804, 26, 5, 64, 52, 1};
        System.out.println("Before Sorting: ");
        Out.print(a);
        a = radixSort(a, a.length);
        System.out.println("After Sorting Iterative: ");
        Out.print(a);
    }

    private static int[] radixSort(int[] a, int n) {
        String[] arr = new String[n];
        int digitCount = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(a[i]);
            digitCount = Math.max(digitCount, arr[i].length());
        }

        for (int d = 0, i = 0; d < digitCount; d++) {
            LinkedHashSet<Integer>[] links = getDigitArray(arr, n, d);
            arr = countingSort(links, n);
        }

        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(arr[i]);
        return a;
    }

    private static String[] countingSort(LinkedHashSet<Integer>[] arrLink, int n) {
        String[] arr = new String[n];
        int j = 0;
        for (int i = 0; i < 10; i++) {
            for (int e : arrLink[i])
                arr[j++] = String.valueOf(e);
        }
        return arr;
    }

    private static LinkedHashSet<Integer>[] getDigitArray(String[] arr, int n, int d) {
        LinkedHashSet<Integer>[] digitList = new LinkedHashSet[10]; // 10 digits [0-9]
        for (int i = 0; i < 10; i++)
            digitList[i] = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String curr = arr[i];
            int idx = curr.length() - d - 1;
            int digit = idx < 0 ? 0 : curr.charAt(idx) - '0';
            digitList[digit].add(Integer.parseInt(curr));
        }
        return digitList;
    }

}

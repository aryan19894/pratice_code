package pratice.book.karumanchi.chapter2.striver.basic;

import pratice.common.Out;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 5, 8};
        reverse(arr, 0, arr.length - 1);
        Out.print(arr);
        reverse(arr, 0);
        Out.print(arr);
    }

    private static void reverse(int[] arr, int s, int e) {
        if (s >= e) return;

        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;

        reverse(arr, s + 1, e - 1);
    }

    private static void reverse(int[] arr, int i) {
        int n = arr.length;
        if (i >= n / 2) return;

        int temp = arr[i];
        arr[i] = arr[n - i - 1];
        arr[n - i - 1] = temp;

        reverse(arr, i + 1);
    }
}

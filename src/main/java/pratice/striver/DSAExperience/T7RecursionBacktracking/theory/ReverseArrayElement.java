package pratice.striver.DSAExperience.T7RecursionBacktracking.theory;

import pratice.common.Out;

public class ReverseArrayElement {
    //recursive - functional - 2pointer
    private static void reverse(int[] arr, int l, int r) {
        if (l >= r) return;
        swap(arr, l, r);
        reverse(arr, l + 1, r - 1);
    }

    //recursive - functional - 1pointer only i
    private static void reverse2(int i, int[] arr, int n) {
        if (i >= n / 2) return;
        swap(arr, i, n - i - 1);
        reverse2(i + 1, arr, n);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 2, 1};
        //reverse(arr, 0, arr.length);
        reverse2(0, arr, arr.length);
        Out.print(arr);
    }


}

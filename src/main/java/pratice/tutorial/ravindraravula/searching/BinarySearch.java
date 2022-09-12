package pratice.tutorial.ravindraravula.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int a[] = {1, 2, 5, 6, 8, 9, 11, 15};
        int index = search(a, 0, a.length, 8);
        System.out.println("8 is available at index: " + index);
    }

    private static int search(int[] arr, int l, int r, int k) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] == k) return m;
            else if (arr[m] < k) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
}

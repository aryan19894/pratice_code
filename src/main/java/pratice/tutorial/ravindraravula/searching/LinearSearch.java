package pratice.tutorial.ravindraravula.searching;

public class LinearSearch {
    public static void main(String[] args) {
        int a[] = {9, 6, 5, 0, 8, 2, 7, 1, 3};
        int index = search(a, 8);
        System.out.println("8 is available at index: " + index);
    }

    private static int search(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == k) return i;
        return -1;
    }
}

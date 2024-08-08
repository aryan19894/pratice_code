package companyOA.Interview.Google;

import java.util.ArrayList;

public class CountRightSmallerElement {
    public static ArrayList<Integer> countSmall(int[] A) {

        int len = A.length;
        Item[] items = new Item[len];

        for (int i = 0; i < len; i++) {
            items[i] = new Item(A[i], i);
        }

        int[] count = new int[len];
        mergeSort(items, 0, len - 1, count);
        ArrayList<Integer> res = new ArrayList<>();

        for (int i : count) {
            res.add(i);
        }
        return res;
    }

    private static void mergeSort(Item[] items, int low, int high, int[] count) {

        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        mergeSort(items, low, mid, count);
        mergeSort(items, mid + 1, high, count);
        merge(items, low, mid, mid + 1, high, count);
    }

    private static void merge(Item[] items, int low, int lowEnd, int high, int highEnd, int[] count) {
        int m = highEnd - low + 1;
        Item[] sorted = new Item[m];
        int rightCounter = 0;
        int lowPtr = low, highPtr = high;
        int index = 0;

        while (lowPtr <= lowEnd && highPtr <= highEnd) {
            if (items[lowPtr].val > items[highPtr].val) {
                rightCounter++;
                sorted[index++] = items[highPtr++];
            } else {
                count[items[lowPtr].index] += rightCounter;
                sorted[index++] = items[lowPtr++];
            }
        }

        while (lowPtr <= lowEnd) {
            count[items[lowPtr].index] += rightCounter;
            sorted[index++] = items[lowPtr++];
        }

        while (highPtr <= highEnd) {
            sorted[index++] = items[highPtr++];
        }

        System.arraycopy(sorted, 0, items, low, m);
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 4};
        ArrayList<Integer> countList = countSmall(arr);
        printArray(countList);
    }

    static void printArray(ArrayList<Integer> countList) {

        for (Integer i : countList)
            System.out.print(i + " ");

        System.out.println();
    }

    static class Item {

        int val;
        int index;

        public Item(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}

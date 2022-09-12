package pratice.tutorial.ravindraravula.sorting;

import pratice.common.Out;

import java.util.LinkedList;

public class BucketSortFloating {
    public static void main(String[] args) {
        double a[] = {0.897, 0.565, 0.656, 0.837, 0.525, 0.1234, 0.665, 0.3434};
        System.out.println("Before Sorting: ");
        Out.print(a);
        a = bucketSortFloating(a, a.length);
        System.out.println("After Sorting Iterative: ");
        Out.print(a);
    }

    //only floating decimal point
    private static double[] bucketSortFloating(double[] arr, double n) {
        LinkedList<Double>[] bucket = new LinkedList[10];
        for (int i = 0; i < 10; i++)
            bucket[i] = new LinkedList<Double>();

        for (double a : arr) {
            int idx = (int) ((a * 10) % 10);
            insert(bucket[idx], a);
        }

        int i = 0;
        for (LinkedList<Double> b : bucket) {
            for (Double e : b)
                arr[i++] = e;
        }
        return arr;
    }

    private static void insert(LinkedList<Double> list, double k) {
        int i = 0;
        for (; i < list.size(); i++) {
            if (list.get(i) > k)
                break;
        }
        list.add(i, k);
    }
}

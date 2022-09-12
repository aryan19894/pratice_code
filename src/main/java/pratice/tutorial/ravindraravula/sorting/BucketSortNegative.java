package pratice.tutorial.ravindraravula.sorting;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BucketSortNegative {
    static int bucketSize = 10;

    public static void main(String[] args) {
        double a[] = {-11.897, 0.565, -2.656, 0.837, 20.525, -2.1234, 0.665, 4.3434,
                2.626, 1.837, -3.525, -52.2234, 7.265, 4.3434, 9.8, 0.6, -10.1, 1.9,
                3.07, 3.04, -5.0, 8.0, 4.8, 57.68};

        System.out.println("Before Sorting: ");
        Out.print(a);
        bucketSortMixed(a);
        System.out.println("After Sorting Iterative: ");
        Out.print(a);
    }

    //Mixed number: decimal, integral, negatives
    private static void bucketSortMixed(double[] a) {
        List<Double> posList = new ArrayList<>();
        List<Double> negList = new ArrayList<>();

        for (double e : a) {
            if (e < 0)
                negList.add(-1 * e);
            else
                posList.add(e);
        }

        double[] pos = toArray(posList);
        bucketSortIntegral(pos, pos.length);
        double[] neg = toArray(negList);
        int negLen = neg.length;
        bucketSortIntegral(neg, negLen);

        int i = 0;
        while (i < negLen)
            a[i] = -1 * neg[negLen - 1 - i++];
        for (double e : pos)
            a[i++] = e;
    }

    private static void bucketSortIntegral(double[] arr, int n) {
        LinkedList<Double>[] bucket = new LinkedList[bucketSize];
        for (int i = 0; i < bucketSize; i++)
            bucket[i] = new LinkedList<Double>();

        integralRadixSort(arr, n);
        scatterToBucket(bucket, arr, n);

        int i = 0;
        for (LinkedList<Double> b : bucket) {
            for (Double e : b)
                arr[i++] = e;
        }
    }

    private static void scatterToBucket(LinkedList<Double>[] bucket, double[] arr, int n) {
        double[] val = getMinMax(arr);
        double min = val[0], max = val[1];
        double range = (max - min) / bucketSize;

        for (double a : arr) {
            int idx = (int) ((a - min) / range);
            if (idx >= bucketSize)
                idx--;

            insert(bucket[idx], a);
        }
    }

    private static void integralRadixSort(double[] arr, int n) {
        double max = getMinMax(arr)[1];

        for (int div = 1; max / div > 0; div *= 10)
            radixSort(arr, n, div);
    }

    private static void radixSort(double[] arr, int n, int div) {
        double[] out = new double[n];
        int[] count = new int[10];

        for (double a : arr)
            count[(int) ((a / div) % 10)]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            int idx = (int) ((arr[i] / div) % 10);
            count[idx]--;
            out[count[idx]] = arr[i];
        }

        for (int i = 0; i < n; i++)
            arr[i] = out[i];
    }

    private static void insert(LinkedList<Double> list, double k) {
        int i = 0;
        for (; i < list.size(); i++) {
            if (list.get(i) > k)
                break;
        }
        list.add(i, k);
    }

    private static double[] toArray(List<Double> list) {
        double[] ref = new double[list.size()];
        int i = 0;
        for (Double d : list)
            ref[i++] = d;
        return ref;
    }

    private static double[] getMinMax(double[] arr) {
        double min, max;
        min = max = arr[0];
        for (double a : arr) {
            if (a < min)
                min = a;
            if (a > max)
                max = a;
        }
        return new double[]{min, max};
    }


}

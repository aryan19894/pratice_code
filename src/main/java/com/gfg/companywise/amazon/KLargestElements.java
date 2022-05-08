package com.gfg.companywise.amazon;

import com.common.Out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KLargestElements {
    public static ArrayList<Integer> kLargest(int arr[], int n, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int a : arr)
            pq.add(a);
        if (pq.size() <= k) return new ArrayList<>(pq);
        for (int i = 0; i < k; i++)
            result.add(pq.remove());
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {12,5,787,1,23};
        int n = 0;
        int k = 2;
        Out.print(kLargest(arr, n, k));
    }
}

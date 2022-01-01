package com.common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Obj {
    public Obj() {
    }

    public static void swap(int[] arr, int a, int b) {
        if (a != b) {
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

    }

    public static void swapBetweenTwoArray(int[] a, int ai, int[] b, int bi) {
        int t = a[ai];
        a[ai] = b[bi];
        b[bi] = t;
    }

    public static void add(Map<Object, Object> number, Object key, Object in) {
        number.putIfAbsent(key, 0);
        number.put(key, toInteger(number.get(key)) + toInteger(in));
    }

    static int toInteger(Object o) {
        return Integer.valueOf((String)o);
    }


}

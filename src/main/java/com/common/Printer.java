package com.common;

import java.util.Iterator;
import java.util.List;

public class Printer {
    public static void print(int[] a, int intialIndex) {
        System.out.println("-------------------------");

        int i;
        for (i = intialIndex; i < a.length; ++i) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (i = intialIndex; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }


    public static void print(int[] a) {
        System.out.println("-------------------------");

        for (int i = 0; i < a.length; ++i) {
            System.out.print(i + " ");
        }

        System.out.println();
        int[] var5 = a;
        int var2 = a.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            int aa = var5[var3];
            System.out.print(aa + " ");
        }

        System.out.println();
    }

    public static void print(int[][] a, boolean ignoreZero) {
        int i;
        int j;
        for (i = 0; i < a.length; ++i) {
            for (j = 0; j < a[i].length; ++j) {
                if (ignoreZero && a[i][j] != 0) {
                    System.out.print("(" + i + "," + j + ")=" + a[i][j] + " ");
                }
            }

            System.out.println();
        }

        for (i = 0; i < a.length; ++i) {
            for (j = 0; j < a[i].length; ++j) {
                if (ignoreZero && a[i][j] != 0) {
                    System.out.print(a[i][j] + " ");
                }
            }

            System.out.println();
        }

    }

    public static void print(int[][] a) {
        int i;
        int j;
        for (i = 0; i < a.length; ++i) {
            for (j = 0; j < a[i].length; ++j) {
                System.out.print("(" + i + "," + j + ")=" + a[i][j] + " ");
            }

            System.out.println();
        }

        for (i = 0; i < a.length; ++i) {
            for (j = 0; j < a[i].length; ++j) {
                System.out.print(a[i][j] + " ");
            }

            System.out.println();
        }

    }

    public static void print(List a) {
        Iterator var1 = a.iterator();

        while (var1.hasNext()) {
            Object obj = var1.next();
            if (obj instanceof List)
                print((List) obj);
            System.out.println(obj);
        }

    }

//    public static void print(List<List<Integer>> lists) {
//        Iterator var1 = lists.iterator();
//
//        while(var1.hasNext()) {
//            List<Integer> list = (List)var1.next();
//            printList(list);
//            System.out.println("------------");
//        }
//
//    }

//    public static void print(List<Integer> list) {
//        Iterator var1 = list.iterator();
//
//        while(var1.hasNext()) {
//            int l = (Integer)var1.next();
//            System.out.print(l + ", ");
//        }
//
//    }


}

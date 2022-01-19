package com.common;

import com.striver.DSAExperience.Day5LinkedList.ListNode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Printer {
    private static PrinterGen<Integer> defaultPrinter;

    static class PrinterGen<T> {
        public void print(T[] arr) {
            for (int i = 0; i < arr.length; ++i) {
                System.out.println(arr[i]);
            }
        }

        public void print(T[][] arr) {
            for (int i = 0; i < arr.length; ++i) {
                for (int j = 0; j < arr[i].length; ++j) {
                    System.out.println(arr[i][j]);
                }
            }
        }

        public void printWithIndex(T[] a, int intialIndex) {
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

        public void printWithIndex(T[][] a, boolean ignoreZero) {
            int i;
            int j;
            for (i = 0; i < a.length; ++i) {
                for (j = 0; j < a[i].length; ++j) {
                    if (ignoreZero && (Integer) a[i][j] != 0) {
                        System.out.print("(" + i + "," + j + ")=" + a[i][j] + " ");
                    }
                }

                System.out.println();
            }

            for (i = 0; i < a.length; ++i) {
                for (j = 0; j < a[i].length; ++j) {
                    if (ignoreZero && (Integer) a[i][j] != 0) {
                        System.out.print(a[i][j] + " ");
                    }
                }

                System.out.println();
            }

        }

        public void printWithIndex(T[][] a) {
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

    }

    static {
        defaultPrinter = new PrinterGen<Integer>();
    }

    public static void print(int[] arr) {
        defaultPrinter.print(toIntegerArray(arr));
    }

    public static void print(int[][] arr) {
        defaultPrinter.print(to2DIntegerArray(arr));
    }

    public static void printWithIndex(int[] arr, int intialIndex) {
        Integer[] a = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        defaultPrinter.printWithIndex(toIntegerArray(arr), intialIndex);
    }

    public static void printWithIndex(int[][] arr, boolean ignoreZero) {
        defaultPrinter.printWithIndex(to2DIntegerArray(arr), ignoreZero);
    }

    public static void printWithIndex(int[][] arr) {
        defaultPrinter.printWithIndex(to2DIntegerArray(arr));
    }

    public static void print(List a) {
        Iterator var1 = a.iterator();

        while (var1.hasNext()) {
            Object obj = var1.next();
            if (obj instanceof List) {
                print((List) obj);
                System.out.println(obj + " ");
            }
        }
    }

    public static void print(ListNode node) {
        if (node == null)
            System.out.println("null");
        System.out.println();
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }



    private static Integer[][] to2DIntegerArray(int[][] arr) {
        Integer[][] a = new Integer[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = toIntegerArray(arr[i]);
        }
        return a;
    }

    private static Integer[] toIntegerArray(int[] arr) {
        return Arrays.stream(arr).boxed().toArray(Integer[]::new);
    }


//    public static void print(int[] a) {
//        System.out.println("-------------------------");
//
//        for (int i = 0; i < a.length; ++i) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println();
//        int[] var5 = a;
//        int var2 = a.length;
//
//        for (int var3 = 0; var3 < var2; ++var3) {
//            int aa = var5[var3];
//            System.out.print(aa + " ");
//        }
//
//        System.out.println();
//    }

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

package common;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Out {
    public static void print(Object obj) {
        if (obj == null) {
            System.out.println("null");
            return;
        }

        String instance = obj.toString();
        if (instance.contains("[[")) {
            for (int i = 0; i < Array.getLength(obj); i++) {
                print(Array.get(obj, i));
            }
        } else if (instance.contains("[")) {
            for (int i = 0; i < Array.getLength(obj); i++) {
                System.out.print(Array.get(obj, i) + " ");
            }
            System.out.println();
        } else
            System.out.println(obj);
    }

    public static void print(Map a) {
        if (a == null)
            System.out.println("null");

        Map<Object, Object> mapObj = (Map<Object, Object>) a;
        for (Map.Entry<Object, Object> e : mapObj.entrySet()) {
            String res = "[";
            for (Object val : (List) e.getValue())
                res += val.toString() + (mapObj.containsKey(val) ? " -> " + mapObj.get(val) : "") + ", ";

            res = res.substring(0, res.length() - 2) + "]";
            System.out.println(e.getKey() + " -> " + res);
        }
        System.out.println("-------------");
    }

    public static void print(List a) {
        if (a == null)
            System.out.println("null");

        Iterator itr = a.iterator();

        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        System.out.println("-------------");
    }

    public static void print(String msg, List a) {
        System.out.print(msg + ": ");
        print(a);
    }

    public static void printWithIndex(Object obj) {
        String instance = obj.toString();
        if (instance.contains("[[")) {
            for (int i = 0; i < Array.getLength(obj); i++) {
                printHelper(i, Array.get(obj, i), false);
            }
        } else if (instance.contains("[")) {
            printHelper(-1, obj, false);
            System.out.println();
        }
    }

    public static void printWithIndex(Object obj, boolean ignoreZero) {
        String instance = obj.toString();
        if (instance.contains("[[")) {
            for (int i = 0; i < Array.getLength(obj); i++)
                printHelper(i, Array.get(obj, i), ignoreZero);
        } else if (instance.contains("["))
            printHelper(-1, obj, ignoreZero);
    }

    public static void printHelper(int i, Object obj, boolean ignoreZero) {
        for (int j = 0; j < Array.getLength(obj); j++) {
            String ele = Array.get(obj, j).toString();
            if (i >= 0) {
                if (ignoreZero) {
                    if (ele != "0")
                        System.out.print("(" + i + "," + j + ")=" + ele + " ");
                } else
                    System.out.print("(" + i + "," + j + ")=" + ele + " ");
            } else {
                if (ignoreZero && ele != "0")
                    System.out.print("(" + j + ")=" + ele + " ");
                else if (!ignoreZero)
                    System.out.print("(" + i + "," + j + ")=" + ele + " ");
            }
        }
        System.out.println();
    }


//    private static GlobalPrinter<Integer> defaultPrinter;
//
//    static {
//        defaultPrinter = new GlobalPrinter<Integer>();
//    }
//
//    public static void print(int[] arr) {
//        defaultPrinter.print(toIntegerArray(arr));
//    }
//
//    public static void print(int[][] arr) {
//        defaultPrinter.print(to2DIntegerArray(arr));
//    }
//
//    public static void printWithIndex(int[][] arr, boolean ignoreZero) {
//        defaultPrinter.printWithIndex(to2DIntegerArray(arr), ignoreZero);
//    }
//
//    public static void printWithIndex(int[][] arr) {
//        defaultPrinter.printWithIndex(to2DIntegerArray(arr));
//    }


//    public static void print(List<List<Object>> a) {
//        Iterator itr = a.iterator();
//
//        while (itr.hasNext()) {
//            System.out.print(itr.next() + " ");
//        }
//    }


//    private static Integer[][] to2DIntegerArray(int[][] arr) {
//        Integer[][] a = new Integer[arr.length][arr[0].length];
//        for (int i = 0; i < arr.length; i++) {
//            a[i] = toIntegerArray(arr[i]);
//        }
//        return a;
//    }
//
//    private static Integer[] toIntegerArray(int[] arr) {
//        return Arrays.stream(arr).boxed().toArray(Integer[]::new);
//    }


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

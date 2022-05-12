package pratice.common;

import java.lang.reflect.Array;

@Deprecated
public class GlobalPrinter<T> {
    public void print(Object obj) {
        if (obj.getClass().isArray())
            if (obj.toString().contains("[[")) {
                for(int i = 0; i< Array.getLength(obj); i++){
                    print(Array.get(obj, i));
                }
            } else {
                for (int i = 0; i < Array.getLength(obj); i++) {
                    System.out.print(Array.get(obj, i) + " ");
                }
                System.out.println();
            }
    }

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

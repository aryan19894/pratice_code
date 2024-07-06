// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RingRotate.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming;

import java.io.PrintStream;
import java.util.Scanner;

public class RingRotate {

    public RingRotate() {
    }

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int a[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                a[i][j] = scn.nextInt();

        }

        int s = scn.nextInt();
        int r = scn.nextInt();
        rotateShell(a, s, r);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print((new StringBuilder()).append(a[i][j]).append(" ").toString());

            System.out.println();
        }

    }

    private static void rotateShell(int a[][], int s, int r) {
        int oned[] = fillOneDFromShell(a, s);
        rotate(oned, r);
        fillShellFromOneD(a, s, oned);
    }

    private static int[] fillOneDFromShell(int a[][], int s) {
        int minr = s - 1;
        int minc = s - 1;
        int maxr = a.length - s;
        int maxc = a[0].length - s;
        int size = 2 * (((maxr - minr) + maxc) - minc);
        int oned[] = new int[size];
        int idx = 0;
        int i = minr;
        int j = minc;
        for (; i <= maxr; i++)
            oned[idx++] = a[i][j];

        minc++;
        i = maxr;
        for (j = minc; j <= maxc; j++)
            oned[idx++] = a[i][j];

        i = --maxr;
        j = maxc;
        for (; i >= minr; i--)
            oned[idx++] = a[i][j];

        maxc--;
        i = minr;
        for (j = maxc; j >= minc; j--)
            oned[idx++] = a[i][j];

        minr++;
        return oned;
    }

    private static void fillShellFromOneD(int a[][], int s, int oned[]) {
        int minr = s - 1;
        int minc = s - 1;
        int maxr = a.length - s;
        int maxc = a[0].length - s;
        int idx = 0;
        int i = minr;
        int j = minc;
        for (; i <= maxr; i++)
            a[i][j] = oned[idx++];

        i = maxr;
        for (j = minc + 1; j <= maxc; j++)
            a[i][j] = oned[idx++];

        i = maxr - 1;
        j = maxc;
        for (; i >= minr; i--)
            a[i][j] = oned[idx++];

        i = minr;
        for (j = maxc - 1; j >= minc + 1; j--)
            a[i][j] = oned[idx++];

    }

    private static void rotate(int oned[], int r) {
        int n = oned.length;
        r %= n;
        if (r < 0)
            r = n + r;
        reverse(oned, 0, n - r - 1);
        reverse(oned, n - r, n - 1);
        reverse(oned, 0, n - 1);
    }

    private static void reverse(int oned[], int i, int j) {
        for (; i < j; j--) {
            int temp = oned[i];
            oned[i] = oned[j];
            oned[j] = temp;
            i++;
        }

    }
}

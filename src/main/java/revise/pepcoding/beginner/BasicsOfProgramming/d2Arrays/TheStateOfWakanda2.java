// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TheStateOfWakanda2.java

package revise.pepcoding.beginner.BasicsOfProgramming.d2Arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class TheStateOfWakanda2 {

    public TheStateOfWakanda2() {
    }

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                a[i][j] = scn.nextInt();

        }

        for (int i = 0; i < n; i++) {
            int j = 0;
            for (int k = i; k < n; ) {
                System.out.println(a[j][k]);
                k++;
                j++;
            }

        }

    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TheStateOfWakanda1.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming;

import java.io.PrintStream;
import java.util.Scanner;

public class TheStateOfWakanda1 {

    public TheStateOfWakanda1() {
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

        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++)
                    System.out.print(a[j][i]);

                continue;
            }
            for (int j = n - 1; j >= 0; j--)
                System.out.print(a[j][i]);

        }

    }
}

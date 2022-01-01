// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SaddlePrice.java

package revise.pepcoding.beginner.BasicsOfProgramming.d2Arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class SaddlePrice {

    public SaddlePrice() {
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
            int cj = 0;
            for (int j = 1; j < n; j++)
                if (a[i][j] < a[i][cj])
                    cj = j;

            boolean flag = true;
            int k = 1;
            do {
                if (k >= n)
                    break;
                if (a[k][cj] > a[i][cj]) {
                    flag = false;
                    break;
                }
                k++;
            } while (true);
            if (flag) {
                System.out.println(a[i][cj]);
                return;
            }
        }

        System.out.println("Invalid input");
    }
}

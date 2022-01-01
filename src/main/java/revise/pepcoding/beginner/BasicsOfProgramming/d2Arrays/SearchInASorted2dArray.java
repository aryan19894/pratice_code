// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SearchInASorted2dArray.java

package revise.pepcoding.beginner.BasicsOfProgramming.d2Arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class SearchInASorted2dArray {

    public SearchInASorted2dArray() {
    }

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                a[i][j] = scn.nextInt();

        }

        int x = scn.nextInt();
        int i = 0;
        for (int j = n - 1; i < n && j >= 0; ) {
            if (a[i][j] == x) {
                System.out.println(i);
                System.out.println(j);
                return;
            }
            if (a[i][j] > x)
                j--;
            else
                i++;
        }

        System.out.println("Not Found");
    }
}

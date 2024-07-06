// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MatrixMultiplication.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming;

import java.io.PrintStream;
import java.util.Scanner;

public class MatrixMultiplication {

    public MatrixMultiplication() {
    }

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int m1 = scn.nextInt();
        int a[][] = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++)
                a[i][j] = scn.nextInt();

        }

        int n2 = scn.nextInt();
        int m2 = scn.nextInt();
        int b[][] = new int[n2][m2];
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++)
                b[i][j] = scn.nextInt();

        }

        if (m1 == n2) {
            int c[][] = new int[n1][m2];
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m2; j++) {
                    for (int k = 0; k < n2; k++)
                        c[i][j] += a[i][k] * b[k][j];

                }

            }

            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m2; j++)
                    System.out.print((new StringBuilder()).append(c[i][j]).append(" ").toString());

                System.out.println();
            }

        } else {
            System.out.println("Invalid input");
        }
    }
}

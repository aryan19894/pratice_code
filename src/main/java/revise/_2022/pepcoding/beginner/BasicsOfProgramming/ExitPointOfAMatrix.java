// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExitPointOfAMatrix.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming;

import java.io.PrintStream;
import java.util.Scanner;

public class ExitPointOfAMatrix {

    public ExitPointOfAMatrix() {
    }

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int a[][] = new int[n][m];
        int i;
        int j;
        for (i = 0; i < n; i++)
            for (j = 0; j < m; j++)
                a[i][j] = scn.nextInt();


        i = 0;
        j = 0;
        int dir = 0;
        do {
            dir = (dir + a[i][j]) % 4;
            if (dir == 0)
                j++;
            else if (dir == 1)
                i++;
            else if (dir == 2)
                j--;
            else if (dir == 3)
                i--;
            if (i < 0) {
                i++;
                break;
            }
            if (j < 0) {
                j++;
                break;
            }
            if (i >= a.length) {
                i--;
                break;
            }
            if (j < a[0].length)
                continue;
            j--;
            break;
        } while (true);
        System.out.println(i);
        System.out.println(j);
    }
}

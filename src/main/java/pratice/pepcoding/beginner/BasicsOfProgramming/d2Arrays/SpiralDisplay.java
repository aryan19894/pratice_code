// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SpiralDisplay.java

package pratice.pepcoding.beginner.BasicsOfProgramming.d2Arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class SpiralDisplay
{

    public SpiralDisplay()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int a[][] = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
                a[i][j] = scn.nextInt();

        }

        int minr = 0;
        int maxr = a.length - 1;
        int minc = 0;
        int maxc = a[0].length - 1;
        int tne = n * m;
        for(int cnt = 0; cnt < tne;)
        {
            int i = minr;
            int j = minc;
            for(; i <= maxr && cnt < tne; i++)
            {
                System.out.println(a[i][j]);
                cnt++;
            }

            minc++;
            i = maxr;
            for(j = minc; j <= maxc && cnt < tne; j++)
            {
                System.out.println(a[i][j]);
                cnt++;
            }

            i = --maxr;
            j = maxc;
            for(; i >= minr && cnt < tne; i--)
            {
                System.out.println(a[i][j]);
                cnt++;
            }

            maxc--;
            i = minr;
            for(j = maxc; j >= minc && cnt < tne; j--)
            {
                System.out.println(a[i][j]);
                cnt++;
            }

            minr++;
        }

    }
}

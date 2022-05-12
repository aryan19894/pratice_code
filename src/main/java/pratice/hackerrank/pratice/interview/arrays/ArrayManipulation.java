// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ArrayManipulation.java

package pratice.hackerrank.pratice.interview.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class ArrayManipulation
{

    public ArrayManipulation()
    {
    }

    static long arrayManipulation(int n, int queries[][])
    {
        long ref[] = new long[n + 1];
        for(int i = 0; i < queries.length; i++)
        {
            int l = queries[i][0];
            int u = queries[i][1];
            int s = queries[i][2];
            ref[l - 1] += s;
            if(u < n)
                ref[u] -= s;
        }

        long max = 0L;
        long temp = 0L;
        for(int i = 0; i < n; i++)
        {
            temp += ref[i];
            if(temp > max)
                max = temp;
        }

        return max;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int ar[][] = new int[m][3];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < 3; j++)
                ar[i][j] = in.nextInt();

        }

        long res = arrayManipulation(n, ar);
        System.out.println(res);
    }
}

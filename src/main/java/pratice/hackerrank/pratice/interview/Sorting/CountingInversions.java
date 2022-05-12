// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CountingInversions.java

package pratice.hackerrank.pratice.interview.Sorting;

import java.io.PrintStream;
import java.util.Scanner;

public class CountingInversions
{

    public CountingInversions()
    {
    }

    static long countInversions(int arr[])
    {
        long count = 0L;
        int n = arr.length;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                if(i < j && arr[i] > arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    count++;
                }

        }

        return count;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int d = in.nextInt();
        for(int j = 0; j < d; j++)
        {
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = in.nextInt();

            long ans = countInversions(arr);
            System.out.println(ans);
        }

    }
}

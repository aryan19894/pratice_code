// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BubbleSort.java

package pratice.hackerrank.pratice.interview.Sorting;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort
{

    public BubbleSort()
    {
    }

    static void countSwaps(int a[])
    {
        int swap = 0;
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a.length - 1; j++)
                if(a[j] > a[j + 1])
                {
                    swap++;
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }

        }

        System.out.println(Arrays.toString(a));
        System.out.println((new StringBuilder()).append("Array is sorted in ").append(swap).append(" swaps.").toString());
        System.out.println((new StringBuilder()).append("First Element: ").append(a[0]).toString());
        System.out.println((new StringBuilder()).append("Last Element: ").append(a[a.length - 1]).toString());
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        countSwaps(arr);
    }
}

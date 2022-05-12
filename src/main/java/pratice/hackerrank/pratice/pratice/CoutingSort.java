// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CoutingSort.java

package pratice.hackerrank.pratice.pratice;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.IntStream;

public class CoutingSort
{

    public CoutingSort()
    {
    }

    static int[] countingSort(int a[])
    {
        int max = Arrays.stream(a).max().getAsInt();
        int min = Arrays.stream(a).min().getAsInt();
        int k = (max - min) + 1;
        int n = a.length;
        int count[] = new int[k];
        int sort[] = new int[n];
        for(int i = 0; i < n; i++)
            count[a[i]]++;

        for(int i = 1; i < k; i++)
            count[i] += count[i - 1];

        for(int i = n - 1; i > 0; i--)
        {
            count[a[i]]--;
            int in = count[a[i]];
            sort[in] = a[i];
        }

        return sort;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        int ans[] = countingSort(arr);
        System.out.println(Arrays.toString(ans));
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   QuartilesRef.java

package com.hackerrank.pratice.statics.day1;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class QuartilesRef
{

    public QuartilesRef()
    {
    }

    public static void main(String args[])
    {
        int array[] = getValues();
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int q1 = findMedian(array, 0, array.length / 2 - 1);
        int q2 = findMedian(array, 0, array.length - 1);
        int q3 = findMedian(array, (array.length + 1) / 2, array.length - 1);
        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
    }

    private static int[] getValues()
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int array[] = new int[n];
        for(int i = 0; i < n; i++)
            array[i] = scan.nextInt();

        scan.close();
        return array;
    }

    private static int findMedian(int array[], int start, int end)
    {
        if((end - start) % 2 == 0)
        {
            return array[(end + start) / 2];
        } else
        {
            int value1 = array[(end + start) / 2];
            int value2 = array[(end + start) / 2 + 1];
            return Math.round((value1 + value2) / 2);
        }
    }
}

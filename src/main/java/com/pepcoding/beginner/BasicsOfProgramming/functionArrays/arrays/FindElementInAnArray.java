// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FindElementInAnArray.java

package com.pepcoding.beginner.BasicsOfProgramming.functionArrays.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class FindElementInAnArray
{

    public FindElementInAnArray()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int d = scn.nextInt();
        int i = 0;
        i = 0;
        do
        {
            if(i >= n)
                break;
            if(arr[i] == d)
            {
                System.out.println(i);
                break;
            }
            i++;
        } while(true);
        if(i == n)
            System.out.println(-1);
    }
}

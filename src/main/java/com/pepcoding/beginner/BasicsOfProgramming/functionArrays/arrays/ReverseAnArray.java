// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ReverseAnArray.java

package com.pepcoding.beginner.BasicsOfProgramming.functionArrays.arrays;

import java.io.*;

public class ReverseAnArray
{

    public ReverseAnArray()
    {
    }

    public static void display(int a[])
    {
        StringBuilder sb = new StringBuilder();
        int ai[] = a;
        int i = ai.length;
        for(int j = 0; j < i; j++)
        {
            int val = ai[j];
            sb.append((new StringBuilder()).append(val).append(" ").toString());
        }

        System.out.println(sb);
    }

    public static void reverse(int a[])
    {
        int i = 0;
        for(int j = a.length - 1; i < j; j--)
        {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
        }

    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());

        reverse(a);
        display(a);
    }
}

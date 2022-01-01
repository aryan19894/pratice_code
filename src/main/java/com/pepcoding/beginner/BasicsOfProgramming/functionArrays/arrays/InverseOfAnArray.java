// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   InverseOfAnArray.java

package com.pepcoding.beginner.BasicsOfProgramming.functionArrays.arrays;

import java.io.*;

public class InverseOfAnArray
{

    public InverseOfAnArray()
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
            sb.append((new StringBuilder()).append(val).append("\n").toString());
        }

        System.out.println(sb);
    }

    public static int[] inverse(int a[])
    {
        int n = a.length;
        int b[] = new int[n];
        for(int i = 0; i < n; i++)
            b[a[i]] = i;

        return b;
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());

        int inv[] = inverse(a);
        display(inv);
    }
}

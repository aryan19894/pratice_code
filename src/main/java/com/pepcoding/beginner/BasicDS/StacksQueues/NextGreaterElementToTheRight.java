// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NextGreaterElementToTheRight.java

package com.pepcoding.beginner.BasicDS.StacksQueues;

import java.io.*;
import java.util.Stack;

public class NextGreaterElementToTheRight
{

    public NextGreaterElementToTheRight()
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

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());

        int nge[] = solve(a);
        display(nge);
    }

    public static int[] solve(int arr[])
    {
        int n = arr.length;
        int gr[] = new int[n];
        gr[n - 1] = -1;
        Stack st = new Stack();
        st.push(Integer.valueOf(arr[n - 1]));
        for(int i = n - 2; i >= 0; i--)
        {
            for(; !st.isEmpty() && arr[i] >= ((Integer)st.peek()).intValue(); st.pop());
            gr[i] = st.isEmpty() ? -1 : ((Integer)st.peek()).intValue();
            st.push(Integer.valueOf(arr[i]));
        }

        return gr;
    }
}

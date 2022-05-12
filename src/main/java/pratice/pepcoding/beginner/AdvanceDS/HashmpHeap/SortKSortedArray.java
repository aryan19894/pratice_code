// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SortKSortedArray.java

package pratice.pepcoding.beginner.AdvanceDS.HashmpHeap;

import java.io.*;

public class SortKSortedArray
{

    public SortKSortedArray()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++)
            System.out.print((new StringBuilder()).append(a[i]).append(" ").toString());

    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SubsetsOfArray.java

package com.pepcoding.beginner.BasicsOfProgramming.functionArrays.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class SubsetsOfArray
{

    public SubsetsOfArray()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        getSubset(n, arr);
    }

    private static void getSubset(int n, int arr[])
    {
        int nLoop = (int)Math.pow(2D, n);
        for(int i = 0; i < nLoop; i++)
        {
            char binary[] = toBinary(i, n).toCharArray();
            for(int j = 0; j < binary.length; j++)
                if(binary[j] == '0')
                    System.out.print("-\t");
                else
                    System.out.print((new StringBuilder()).append(arr[j]).append("\t").toString());

            System.out.println();
        }

    }

    private static String toBinary(int n, int d)
    {
        String ans = Integer.toBinaryString(n);
        int x = d - ans.length();
        for(int i = 0; i < x; i++)
            ans = (new StringBuilder()).append("0").append(ans).toString();

        return ans;
    }
}

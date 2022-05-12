// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CountBinaryStrings.java

package pratice.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class CountBinaryStrings
{

    public CountBinaryStrings()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int end0 = 1;
        int end1 = 1;
        for(int i = 2; i <= n; i++)
        {
            int temp = end0 + end1;
            end0 = end1;
            end1 = temp;
        }

        System.out.println(end0 + end1);
    }
}

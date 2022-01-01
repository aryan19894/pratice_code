// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaSubstringComparisons.java

package com.hackerrank.pratice.java.string;

import java.io.PrintStream;
import java.util.*;

public class JavaSubstringComparisons
{

    public JavaSubstringComparisons()
    {
    }

    public static String getSmallestAndLargest(String str, int k)
    {
        SortedSet sets = new TreeSet();
        for(int i = 0; i <= str.length() - k; i++)
            sets.add(str.substring(i, i + k));

        String smallest = (String)sets.first();
        String largest = (String)sets.last();
        return (new StringBuilder()).append(smallest).append("\n").append(largest).toString();
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
        System.out.println(getSmallestAndLargest(s, k));
    }
}

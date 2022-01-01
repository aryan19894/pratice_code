// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaHashset.java

package com.hackerrank.pratice.java.DataStructure;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

public class JavaHashset
{

    public JavaHashset()
    {
    }

    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String pair_left[] = new String[t];
        String pair_right[] = new String[t];
        for(int i = 0; i < t; i++)
        {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        HashSet pairs = new HashSet(t);
        for(int i = 0; i < t; i++)
        {
            pairs.add((new StringBuilder()).append("(").append(pair_left[i]).append(", ").append(pair_right[i]).append(")").toString());
            System.out.println(pairs.size());
        }

    }
}

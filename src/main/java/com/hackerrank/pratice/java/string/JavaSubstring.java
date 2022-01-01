// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaSubstring.java

package com.hackerrank.pratice.java.string;

import java.io.PrintStream;
import java.util.Scanner;

public class JavaSubstring
{

    public JavaSubstring()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
        System.out.println(S.substring(start, end));
    }
}

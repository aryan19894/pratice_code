// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrintSubsequence.java

package com.pepcoding.beginner.RecursionAndBacktracking.RecursionOnTheWayUp;

import java.io.PrintStream;
import java.util.Scanner;

public class PrintSubsequence
{

    public PrintSubsequence()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printSS(str, "");
    }

    public static void printSS(String str, String ans)
    {
        if(str.length() == 0)
        {
            System.out.println(ans);
            return;
        } else
        {
            char ch = str.charAt(0);
            String ros = str.substring(1);
            printSS(ros, (new StringBuilder()).append(ans).append(ch).toString());
            printSS(ros, (new StringBuilder()).append(ans).append("").toString());
            return;
        }
    }
}

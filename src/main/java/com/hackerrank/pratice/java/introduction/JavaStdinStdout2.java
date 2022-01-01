// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaStdinStdout2.java

package com.hackerrank.pratice.java.introduction;

import java.io.PrintStream;
import java.util.Scanner;

public class JavaStdinStdout2
{

    public JavaStdinStdout2()
    {
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        String s = "";
        double d = scan.nextDouble();
        while(scan.hasNextLine()) 
            s = (new StringBuilder()).append(s).append(scan.nextLine()).toString();
        System.out.println((new StringBuilder()).append("String: ").append(s).toString());
        System.out.println((new StringBuilder()).append("Double: ").append(d).toString());
        System.out.println((new StringBuilder()).append("Int: ").append(i).toString());
    }
}

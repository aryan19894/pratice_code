// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaIfElse.java

package com.hackerrank.pratice.java.introduction;

import java.io.PrintStream;
import java.util.Scanner;

public class JavaIfElse
{

    public JavaIfElse()
    {
    }

    public static void main(String args[])
    {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\205])?");
        if(n % 2 != 0)
            System.out.println("Weird");
        else
        if(n >= 2 && n <= 5)
            System.out.println("Not Weird");
        else
        if(n >= 6 && n <= 20)
            System.out.println("Weird");
        else
            System.out.println("Not Weird");
        scanner.close();
    }

    private static final Scanner scanner;

    static 
    {
        scanner = new Scanner(System.in);
    }
}

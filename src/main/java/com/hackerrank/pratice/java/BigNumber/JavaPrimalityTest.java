// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaPrimalityTest.java

package com.hackerrank.pratice.java.BigNumber;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

public class JavaPrimalityTest
{

    public JavaPrimalityTest()
    {
    }

    public static void main(String args[])
    {
        String n = scanner.nextLine();
        BigInteger bi = new BigInteger(n);
        if(bi.isProbablePrime(1))
            System.out.println("prime");
        else
            System.out.println("not prime");
        scanner.close();
    }

    private static final Scanner scanner;

    static 
    {
        scanner = new Scanner(System.in);
    }
}

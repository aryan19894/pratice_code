// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaCurrencyFormatter.java

package com.hackerrank.pratice.java.introduction;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class JavaCurrencyFormatter
{

    public JavaCurrencyFormatter()
    {
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        Locale indiaLocale = new Locale("en", "IN");
        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat india = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println((new StringBuilder()).append("US: ").append(us.format(payment)).toString());
        System.out.println((new StringBuilder()).append("India: ").append(india.format(payment)).toString());
        System.out.println((new StringBuilder()).append("China: ").append(china.format(payment)).toString());
        System.out.println((new StringBuilder()).append("France: ").append(france.format(payment)).toString());
    }
}

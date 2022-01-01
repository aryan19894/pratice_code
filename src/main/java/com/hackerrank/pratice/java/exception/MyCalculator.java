// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaExceptionHandling.java

package com.hackerrank.pratice.java.exception;


class MyCalculator
{

    MyCalculator()
    {
    }

    long power(int n, int p)
        throws Exception
    {
        if(n < 0 || p < 0)
            throw new Exception("n or p should not be negative.");
        if(n == 0 && p == 0)
            throw new Exception("n and p should not be zero.");
        else
            return (long)Math.pow(n, p);
    }
}

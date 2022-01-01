// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day21_Generics.java

package com.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;

class Printer
{

    Printer()
    {
    }

    public void printArray(Object arr[])
    {
        Object aobj[] = arr;
        int i = aobj.length;
        for(int j = 0; j < i; j++)
        {
            Object obj = aobj[j];
            System.out.println(obj);
        }

    }
}

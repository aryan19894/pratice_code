// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaGenerics.java

package com.hackerrank.pratice.java.DataStructure;

import java.io.PrintStream;

class Printer
{

    Printer()
    {
    }

    public static void printArray(Object obj[])
    {
        Object aobj[] = obj;
        int i = aobj.length;
        for(int j = 0; j < i; j++)
        {
            Object o = aobj[j];
            System.out.println(o);
        }

    }
}

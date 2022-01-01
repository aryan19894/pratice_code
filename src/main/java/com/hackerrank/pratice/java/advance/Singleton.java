// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaSingletonPattern.java

package com.hackerrank.pratice.java.advance;


class Singleton
{

    private Singleton()
    {
    }

    public static Singleton getSingleInstance()
    {
        if(obj == null)
            return new Singleton();
        else
            return obj;
    }

    public String str;
    private static Singleton obj = null;

}

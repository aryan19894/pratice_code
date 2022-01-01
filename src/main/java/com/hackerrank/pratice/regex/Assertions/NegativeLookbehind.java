// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NegativeLookbehind.java

package com.hackerrank.pratice.regex.Assertions;

import com.hackerrank.pratice.regex.common.Regex_Test;

public class NegativeLookbehind
{

    public NegativeLookbehind()
    {
    }

    public static void main(String args[])
    {
        Regex_Test tester = new Regex_Test();
        tester.checker("(?<![aeiouAEIOU]).");
    }
}

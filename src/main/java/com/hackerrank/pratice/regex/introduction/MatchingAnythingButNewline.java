// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MatchingAnythingButNewline.java

package com.hackerrank.pratice.regex.introduction;

import com.hackerrank.pratice.regex.common.Tester;

public class MatchingAnythingButNewline
{

    public MatchingAnythingButNewline()
    {
    }

    public static void main(String args[])
    {
        Tester tester = new Tester();
        tester.check(".{3}\\..{3}\\..{3}\\..{3}");
    }
}

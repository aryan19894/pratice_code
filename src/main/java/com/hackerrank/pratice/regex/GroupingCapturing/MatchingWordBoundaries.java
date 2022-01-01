// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MatchingWordBoundaries.java

package com.hackerrank.pratice.regex.GroupingCapturing;

import com.hackerrank.pratice.regex.common.Regex_Test;

public class MatchingWordBoundaries
{

    public MatchingWordBoundaries()
    {
    }

    public static void main(String args[])
    {
        Regex_Test tester = new Regex_Test();
        tester.checker("\\b[aeiouAEIOU]\\p{Alpha}*\\b");
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MatchingXRepetitions.java

package com.hackerrank.pratice.regex.Repetitions;

import com.hackerrank.pratice.regex.common.Regex_Test;

public class MatchingXRepetitions
{

    public MatchingXRepetitions()
    {
    }

    public static void main(String args[])
    {
        Regex_Test tester = new Regex_Test();
        tester.checker("^[a-zA-Z02468]{40}[13579\\s]{5}$");
    }
}

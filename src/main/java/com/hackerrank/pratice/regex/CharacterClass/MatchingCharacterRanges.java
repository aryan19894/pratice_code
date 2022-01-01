// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MatchingCharacterRanges.java

package com.hackerrank.pratice.regex.CharacterClass;

import com.hackerrank.pratice.regex.common.Regex_Test;

public class MatchingCharacterRanges
{

    public MatchingCharacterRanges()
    {
    }

    public static void main(String args[])
    {
        Regex_Test tester = new Regex_Test();
        tester.checker("^[a-z][1-9][^a-z][^A-Z][A-Z]");
    }
}

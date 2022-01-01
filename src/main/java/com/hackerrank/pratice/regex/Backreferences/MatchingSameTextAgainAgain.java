// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MatchingSameTextAgainAgain.java

package com.hackerrank.pratice.regex.Backreferences;

import com.hackerrank.pratice.regex.common.Regex_Test;

public class MatchingSameTextAgainAgain
{

    public MatchingSameTextAgainAgain()
    {
    }

    public static void main(String args[])
    {
        Regex_Test tester = new Regex_Test();
        tester.checker("^([a-z])(\\w)(\\s)(\\W)(\\d)(\\D)([A-Z])(\\p{Alpha})([aeiouAEIOU])(\\S)\\1\\2\\3\\4\\5\\6\\7\\8\\9\\10$");
    }
}

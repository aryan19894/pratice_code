// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BranchResetGroups.java

package com.hackerrank.pratice.regex.Backreferences;

import com.hackerrank.pratice.regex.common.Regex_Test;

public class BranchResetGroups
{

    public BranchResetGroups()
    {
    }

    public static void main(String args[])
    {
        Regex_Test tester = new Regex_Test();
        tester.checker("^\\d{2}(?|(---)|(-)|(\\.)|(:))(\\d{2}\\1){2}\\d{2}$");
    }
}

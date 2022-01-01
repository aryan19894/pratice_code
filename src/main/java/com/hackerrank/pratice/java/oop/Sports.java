// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaMethodOverriding.java

package com.hackerrank.pratice.java.oop;

import java.io.PrintStream;

class Sports
{

    Sports()
    {
    }

    String getName()
    {
        return "Generic Sports";
    }

    void getNumberOfTeamMembers()
    {
        System.out.println((new StringBuilder()).append("Each team has n players in ").append(getName()).toString());
    }
}

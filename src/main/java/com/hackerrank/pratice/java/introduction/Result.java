// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaDateTime.java

package com.hackerrank.pratice.java.introduction;

import java.time.LocalDate;

class Result
{

    Result()
    {
    }

    public static String findDay(int month, int day, int year)
    {
        LocalDate dt = LocalDate.of(year, month, day);
        String res = String.valueOf(dt.getDayOfWeek());
        return res.toUpperCase();
    }
}

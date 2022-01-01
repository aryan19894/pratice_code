// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ToggleCase.java

package com.pepcoding.beginner.BasicsOfProgramming.StringStringBuilderAndArraylist;

import java.io.PrintStream;
import java.util.Scanner;

public class ToggleCase
{

    public ToggleCase()
    {
    }

    public static String toggleCase(String str)
    {
        StringBuilder sb = new StringBuilder(str);
        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if(ch >= 'a')
                sb.setCharAt(i, (char)(ch - 32));
            else
                sb.setCharAt(i, (char)(ch + 32));
        }

        return new String(sb);
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(toggleCase(str));
    }
}

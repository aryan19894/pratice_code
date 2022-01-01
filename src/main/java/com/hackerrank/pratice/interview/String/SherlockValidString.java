// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SherlockValidString.java

package com.hackerrank.pratice.interview.String;

import java.io.PrintStream;
import java.util.Scanner;

public class SherlockValidString
{

    public SherlockValidString()
    {
    }

    static String isValid(String s)
    {
        int ch[] = new int[26];
        for(int i = 0; i < s.length(); i++)
            ch[s.charAt(i) - 97]++;

        int key = ch[s.charAt(0) - 97];
        int flag = 0;
        for(int i = 0; i < 26; i++)
            if(ch[i] != 0 && ch[i] != key)
                flag++;

        if(flag < 2)
            return "YES";
        else
            return "NO";
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        System.out.println(isValid(a));
    }
}

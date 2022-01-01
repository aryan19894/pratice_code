// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AlternatingCharacters.java

package com.hackerrank.pratice.interview.String;

import java.io.PrintStream;
import java.util.Scanner;

public class AlternatingCharacters
{

    public AlternatingCharacters()
    {
    }

    static int alternatingCharacters(String s)
    {
        int count = 0;
        char ch[] = s.toCharArray();
        char key = ch[0];
        for(int i = 1; i < ch.length; i++)
            if(key == ch[i])
                count++;
            else
                key = ch[i];

        return count;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int j = 0; j < q; j++)
        {
            String a = in.next();
            System.out.println(alternatingCharacters(a));
        }

    }
}

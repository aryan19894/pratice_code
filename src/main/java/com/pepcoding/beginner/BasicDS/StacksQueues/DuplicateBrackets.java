// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DuplicateBrackets.java

package com.pepcoding.beginner.BasicDS.StacksQueues;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets
{

    public DuplicateBrackets()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        System.out.println(isExpValid(exp));
    }

    private static boolean isExpValid(String exp)
    {
        Stack st = new Stack();
        char ac[] = exp.toCharArray();
        int i = ac.length;
        for(int j = 0; j < i; j++)
        {
            char ch = ac[j];
            if(ch == ')')
            {
                if(((Character)st.peek()).charValue() == '(')
                    return true;
                for(; ((Character)st.peek()).charValue() != '('; st.pop());
                st.pop();
                continue;
            }
            if(ch != ' ')
                st.push(Character.valueOf(ch));
        }

        return false;
    }
}

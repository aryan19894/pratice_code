// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BalancedBrackets.java

package com.pepcoding.beginner.BasicDS.StacksQueues;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets
{

    public BalancedBrackets()
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
            if(ch == '(' || ch == '{' || ch == '[')
            {
                st.push(Character.valueOf(ch));
                continue;
            }
            if(ch != ')' && ch != '}' && ch != ']')
                continue;
            if(st.isEmpty())
                return false;
            char br = ((Character)st.pop()).charValue();
            if(br + 1 != ch && br + 2 != ch)
                return false;
        }

        return st.isEmpty();
    }
}

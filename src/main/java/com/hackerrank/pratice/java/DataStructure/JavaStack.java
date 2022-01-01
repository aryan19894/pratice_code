// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaStack.java

package com.hackerrank.pratice.java.DataStructure;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

public class JavaStack
{

    public JavaStack()
    {
    }

    public static void main(String args[])
    {
        Stack stack;
        boolean st;
        for(Scanner sc = new Scanner(System.in); sc.hasNext(); System.out.println(st && stack.isEmpty()))
        {
            String s = sc.nextLine();
            stack = new Stack();
            st = true;
            char ch[] = s.toCharArray();
            char ac[] = ch;
            int i = ac.length;
            for(int j = 0; j < i; j++)
            {
                char c = ac[j];
                if(!stack.isEmpty() && !Character.isAlphabetic(c))
                {
                    if(!isOpeningBraces(c))
                    {
                        if(stack.peek() != getReverse(c))
                        {
                            st = false;
                            break;
                        }
                        stack.pop();
                    } else
                    {
                        stack.push(Character.valueOf(c));
                    }
                    continue;
                }
                if(!isOpeningBraces(c))
                {
                    st = false;
                    break;
                }
                stack.push(Character.valueOf(c));
            }

        }

    }

    private static Character getReverse(char c)
    {
        if(isOpeningBraces(c))
            if(c == '(')
                return Character.valueOf((char)(c + 1));
            else
                return Character.valueOf((char)(c + 2));
        if(c == ')')
            return Character.valueOf((char)(c - 1));
        else
            return Character.valueOf((char)(c - 2));
    }

    private static boolean isOpeningBraces(char c)
    {
        return c == '(' || c == '[' || c == '{';
    }
}

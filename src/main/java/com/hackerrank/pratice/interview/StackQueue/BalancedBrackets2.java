// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BalancedBrackets2.java

package com.hackerrank.pratice.interview.StackQueue;

import java.io.PrintStream;
import java.util.*;

public class BalancedBrackets2
{

    public BalancedBrackets2()
    {
    }

    static String isBalanced(String s)
    {
        HashMap map = new HashMap();
        map.put(Character.valueOf('('), Character.valueOf(')'));
        map.put(Character.valueOf('['), Character.valueOf(']'));
        map.put(Character.valueOf('{'), Character.valueOf('}'));
        return isBalanced(s, map) ? "YES" : "NO";
    }

    private static boolean isBalanced(String s, HashMap map)
    {
        Stack stack = new Stack();
        char ac[] = s.toCharArray();
        int i = ac.length;
        for(int j = 0; j < i; j++)
        {
            char ch = ac[j];
            if(map.containsKey(Character.valueOf(ch)))
            {
                stack.push(Character.valueOf(ch));
                continue;
            }
            if(stack.isEmpty() || ch != ((Character)map.get(stack.pop())).charValue())
                return false;
        }

        return stack.isEmpty();
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int tItr = 0; tItr < t; tItr++)
        {
            String s = scanner.next();
            String result = isBalanced(s);
            System.out.println(result);
        }

    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   InfixConversions.java

package com.pepcoding.beginner.BasicDS.StacksQueues;

import java.io.*;
import java.util.Stack;

public class InfixConversions
{

    public InfixConversions()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ip = br.readLine();
        int n = ip.length();
        String exp = "";
        for(int i = 0; i < n; i++)
        {
            char ch = ip.charAt(i);
            if(ch != ' ')
                exp = (new StringBuilder()).append(exp).append(ch).toString();
        }

        evaluate(exp);
    }

    private static void evaluate(String exp)
    {
        Stack opr = new Stack();
        Stack pre = new Stack();
        Stack post = new Stack();
        for(int i = 0; i < exp.length(); i++)
        {
            char ch = exp.charAt(i);
            if(ch == '(')
            {
                opr.push(Character.valueOf(ch));
                continue;
            }
            if(Character.isDigit(ch) || Character.isAlphabetic(ch))
            {
                pre.push((new StringBuilder()).append(ch).append("").toString());
                post.push((new StringBuilder()).append(ch).append("").toString());
                continue;
            }
            if(ch == ')')
            {
                for(; !opr.isEmpty() && ((Character)opr.peek()).charValue() != '('; operation(opr, pre, post));
                opr.pop();
                continue;
            }
            if(!isOperator(ch))
                continue;
            for(; !opr.isEmpty() && ((Character)opr.peek()).charValue() != '(' && precedence(ch) <= precedence(((Character)opr.peek()).charValue()); operation(opr, pre, post));
            opr.push(Character.valueOf(ch));
        }

        for(; !opr.isEmpty(); operation(opr, pre, post));
        System.out.println((String)post.pop());
        System.out.println((String)pre.pop());
    }

    private static void operation(Stack opr, Stack pre, Stack post)
    {
        char op = ((Character)opr.pop()).charValue();
        String s2 = (String)pre.pop();
        String s1 = (String)pre.pop();
        pre.push((new StringBuilder()).append(op).append(s1).append(s2).toString());
        s2 = (String)post.pop();
        s1 = (String)post.pop();
        post.push((new StringBuilder()).append(s1).append(s2).append(op).toString());
    }

    private static boolean isOperator(char opr)
    {
        switch(opr)
        {
        case 42: // '*'
        case 43: // '+'
        case 45: // '-'
        case 47: // '/'
            return true;

        case 44: // ','
        case 46: // '.'
        default:
            return false;
        }
    }

    private static int precedence(char opr)
    {
        switch(opr)
        {
        case 43: // '+'
        case 45: // '-'
            return 1;

        case 42: // '*'
        case 47: // '/'
            return 2;

        case 44: // ','
        case 46: // '.'
        default:
            return -1;
        }
    }
}

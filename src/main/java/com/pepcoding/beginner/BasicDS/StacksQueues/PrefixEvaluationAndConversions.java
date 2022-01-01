// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrefixEvaluationAndConversions.java

package com.pepcoding.beginner.BasicDS.StacksQueues;

import java.io.*;
import java.util.Stack;

public class PrefixEvaluationAndConversions
{

    public PrefixEvaluationAndConversions()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ip = br.readLine();
        int n = ip.length();
        String preExpr = "";
        for(int i = 0; i < n; i++)
        {
            char ch = ip.charAt(i);
            if(ch != ' ')
                preExpr = (new StringBuilder()).append(preExpr).append(ch).toString();
        }

        evaluate(preExpr);
    }

    private static void evaluate(String preExpr)
    {
        Stack infix = new Stack();
        Stack postfix = new Stack();
        Stack val = new Stack();
        for(int i = preExpr.length() - 1; i >= 0; i--)
        {
            char ch = preExpr.charAt(i);
            if(isOperator(ch))
            {
                eval(ch, val, postfix, infix);
            } else
            {
                infix.push((new StringBuilder()).append(ch).append("").toString());
                postfix.push((new StringBuilder()).append(ch).append("").toString());
                val.push(Integer.valueOf(ch - 48));
            }
        }

        System.out.println(val.pop());
        System.out.println((String)infix.pop());
        System.out.println((String)postfix.pop());
    }

    private static void eval(char op, Stack val, Stack postfix, Stack infix)
    {
        int v1 = ((Integer)val.pop()).intValue();
        int v2 = ((Integer)val.pop()).intValue();
        val.push(Integer.valueOf(operation(v1, v2, op)));
        String s1 = (String)postfix.pop();
        String s2 = (String)postfix.pop();
        postfix.push((new StringBuilder()).append(s1).append("").append(s2).append(op).toString());
        s1 = (String)infix.pop();
        s2 = (String)infix.pop();
        infix.push((new StringBuilder()).append("(").append(s1).append(op).append(s2).append(")").toString());
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

    private static int operation(int num1, int num2, char opr)
    {
        int ans = 0;
        switch(opr)
        {
        case 43: // '+'
            ans = num1 + num2;
            break;

        case 45: // '-'
            ans = num1 - num2;
            break;

        case 42: // '*'
            ans = num1 * num2;
            break;

        case 47: // '/'
            ans = num1 / num2;
            break;
        }
        return ans;
    }
}

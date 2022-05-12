// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BalancedBrackets.java

package pratice.hackerrank.pratice.interview.StackQueue;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets
{

    public BalancedBrackets()
    {
    }

    static String isBalanced(String s)
    {
        Stack stack = new Stack();
        if(isClose(s.charAt(0)) || s.length() % 2 != 0)
            return "NO";
        char ac[] = s.toCharArray();
        int i = ac.length;
        for(int j = 0; j < i; j++)
        {
            char ch = ac[j];
            if(!isClose(ch))
            {
                stack.push(Character.valueOf(ch));
                continue;
            }
            if(!stack.isEmpty() && stack.peek() == getClose(ch))
                stack.pop();
            else
                return "NO";
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    private static Character getClose(char ch)
    {
        switch(ch)
        {
        case 41: // ')'
            return Character.valueOf('(');

        case 125: // '}'
            return Character.valueOf('{');

        case 93: // ']'
            return Character.valueOf('[');
        }
        return null;
    }

    private static boolean isClose(char ch)
    {
        switch(ch)
        {
        case 41: // ')'
        case 93: // ']'
        case 125: // '}'
            return true;
        }
        return false;
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

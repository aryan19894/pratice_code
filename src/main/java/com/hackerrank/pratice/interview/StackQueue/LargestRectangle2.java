// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LargestRectangle2.java

package com.hackerrank.pratice.interview.StackQueue;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle2
{

    public LargestRectangle2()
    {
    }

    static long largestRectangle(int h[])
    {
        Stack stack = new Stack();
        int i = 0;
        long max = 0L;
        while(i < h.length) 
            if(stack.isEmpty() || h[i] >= h[((Integer)stack.peek()).intValue()])
            {
                stack.push(Integer.valueOf(i));
                i++;
            } else
            {
                int top = ((Integer)stack.peek()).intValue();
                stack.pop();
                if(stack.isEmpty())
                    max = Math.max(max, (long)h[top] * (long)i);
                else
                    max = Math.max(max, (long)h[top] * (long)(i - ((Integer)stack.peek()).intValue() - 1));
            }
        while(!stack.isEmpty()) 
        {
            int top = ((Integer)stack.peek()).intValue();
            stack.pop();
            if(stack.isEmpty())
                max = Math.max(max, (long)h[top] * (long)i);
            else
                max = Math.max(max, (long)h[top] * (long)(i - ((Integer)stack.peek()).intValue() - 1));
        }
        return max;
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int h[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            int e = scan.nextInt();
            h[i] = e;
        }

        long result = largestRectangle(h);
        System.out.println(result);
        scan.close();
    }
}

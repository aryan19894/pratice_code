// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MinimuStack1.java

package com.pepcoding.beginner.BasicDS.StacksQueues.CustomStack;

import java.io.*;
import java.util.Stack;

public class MinimuStack1
{
    public static class MinStack
    {

        int size()
        {
            return allData.size();
        }

        void push(int val)
        {
            allData.push(Integer.valueOf(val));
            if(minData.isEmpty() || ((Integer)minData.peek()).intValue() >= val)
                minData.push(Integer.valueOf(val));
        }

        int pop()
        {
            if(allData.isEmpty())
            {
                System.out.println("Stack underflow");
                return -1;
            }
            if(minData.peek() == allData.peek())
                minData.pop();
            return ((Integer)allData.pop()).intValue();
        }

        int top()
        {
            if(allData.isEmpty())
            {
                System.out.println("Stack underflow");
                return -1;
            } else
            {
                return ((Integer)allData.peek()).intValue();
            }
        }

        int min()
        {
            if(minData.isEmpty())
            {
                System.out.println("Stack underflow");
                return -1;
            } else
            {
                return ((Integer)minData.peek()).intValue();
            }
        }

        Stack allData;
        Stack minData;

        public MinStack()
        {
            allData = new Stack();
            minData = new Stack();
        }
    }


    public MinimuStack1()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();
        for(String str = br.readLine(); !str.equals("quit"); str = br.readLine())
        {
            int val;
            if(str.startsWith("push"))
            {
                val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
                continue;
            }
            if(str.startsWith("pop"))
            {
                val = st.pop();
                if(val != -1)
                    System.out.println(val);
                continue;
            }
            if(str.startsWith("top"))
            {
                val = st.top();
                if(val != -1)
                    System.out.println(val);
                continue;
            }
            if(str.startsWith("size"))
            {
                System.out.println(st.size());
                continue;
            }
            if(!str.startsWith("min"))
                continue;
            val = st.min();
            if(val != -1)
                System.out.println(val);
        }

    }
}

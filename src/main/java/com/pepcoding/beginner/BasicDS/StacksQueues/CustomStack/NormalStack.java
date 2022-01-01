// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NormalStack.java

package com.pepcoding.beginner.BasicDS.StacksQueues.CustomStack;

import java.io.*;

public class NormalStack
{
    public static class CustomStack
    {

        int size()
        {
            return tos + 1;
        }

        void display()
        {
            for(int i = tos; i >= 0; i--)
                System.out.print((new StringBuilder()).append(data[i]).append(" ").toString());

            System.out.println();
        }

        void push(int val)
        {
            if(tos == data.length - 1)
                System.out.println("Stack overflow");
            else
                data[++tos] = val;
        }

        int pop()
        {
            if(tos == -1)
            {
                System.out.println("Stack underflow");
                return -1;
            } else
            {
                int pop = data[tos];
                data[tos] = 0;
                tos--;
                return pop;
            }
        }

        int top()
        {
            if(tos == -1)
            {
                System.out.println("Stack underflow");
                return -1;
            } else
            {
                return data[tos];
            }
        }

        int data[];
        int tos;

        public CustomStack(int cap)
        {
            data = new int[cap];
            tos = -1;
        }
    }


    public NormalStack()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomStack st = new CustomStack(n);
        for(String str = br.readLine(); !str.equals("quit"); str = br.readLine())
        {
            if(str.startsWith("push"))
            {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
                continue;
            }
            if(str.startsWith("pop"))
            {
                int val = st.pop();
                if(val != -1)
                    System.out.println(val);
                continue;
            }
            if(str.startsWith("top"))
            {
                int val = st.top();
                if(val != -1)
                    System.out.println(val);
                continue;
            }
            if(str.startsWith("size"))
            {
                System.out.println(st.size());
                continue;
            }
            if(str.startsWith("display"))
                st.display();
        }

    }
}

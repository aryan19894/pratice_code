// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TwoStacksInAnArray.java

package com.pepcoding.beginner.BasicDS.StacksQueues;

import java.io.*;

public class TwoStacksInAnArray
{
    public static class TwoStack
    {

        int size1()
        {
            return (data.length - tos1) + 1;
        }

        int size2()
        {
            return (data.length - tos2) + 1;
        }

        void push1(int val)
        {
            if(tos1 + 1 == tos2)
                System.out.println("Stack overflow");
            else
                data[++tos1] = val;
        }

        void push2(int val)
        {
            if(tos1 + 1 == tos2)
                System.out.println("Stack overflow");
            else
                data[--tos2] = val;
        }

        int pop1()
        {
            if(tos1 == -1)
            {
                System.out.println("Stack underflow");
                return -1;
            } else
            {
                int pop = data[tos1];
                data[tos1] = 0;
                tos1--;
                return pop;
            }
        }

        int pop2()
        {
            if(tos2 == data.length)
            {
                System.out.println("Stack underflow");
                return -1;
            } else
            {
                int pop = data[tos2];
                data[tos2] = 0;
                tos2++;
                return pop;
            }
        }

        int top1()
        {
            if(tos1 == -1)
            {
                System.out.println("Stack underflow");
                return -1;
            } else
            {
                return data[tos1];
            }
        }

        int top2()
        {
            if(tos2 == data.length)
            {
                System.out.println("Stack underflow");
                return -1;
            } else
            {
                return data[tos2];
            }
        }

        int data[];
        int tos1;
        int tos2;

        public TwoStack(int cap)
        {
            data = new int[cap];
            tos1 = -1;
            tos2 = data.length;
        }
    }


    public TwoStacksInAnArray()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TwoStack st = new TwoStack(n);
        for(String str = br.readLine(); !str.equals("quit"); str = br.readLine())
        {
            if(str.startsWith("push1"))
            {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push1(val);
                continue;
            }
            if(str.startsWith("pop1"))
            {
                int val = st.pop1();
                if(val != -1)
                    System.out.println(val);
                continue;
            }
            if(str.startsWith("top1"))
            {
                int val = st.top1();
                if(val != -1)
                    System.out.println(val);
                continue;
            }
            if(str.startsWith("size1"))
            {
                System.out.println(st.size1());
                continue;
            }
            if(str.startsWith("push2"))
            {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push2(val);
                continue;
            }
            if(str.startsWith("pop2"))
            {
                int val = st.pop2();
                if(val != -1)
                    System.out.println(val);
                continue;
            }
            if(str.startsWith("top2"))
            {
                int val = st.top2();
                if(val != -1)
                    System.out.println(val);
                continue;
            }
            if(str.startsWith("size2"))
                System.out.println(st.size2());
        }

    }
}

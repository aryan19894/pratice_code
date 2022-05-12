// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MinimuStackConstantSpace.java

package pratice.pepcoding.beginner.BasicDS.StacksQueues.CustomStack;

import java.io.*;
import java.util.Stack;

public class MinimuStackConstantSpace
{
    public static class MinStack
    {

        int size()
        {
            return data.size();
        }

        void push(int val)
        {
            if(data.isEmpty())
            {
                data.push(Integer.valueOf(val));
                min = val;
            } else
            if(val >= min)
            {
                data.push(Integer.valueOf(val));
            } else
            {
                data.push(Integer.valueOf((val + val) - min));
                min = val;
            }
        }

        int pop()
        {
            if(data.isEmpty())
            {
                System.out.println("Stack underflow");
                return -1;
            }
            int val = ((Integer)data.pop()).intValue();
            if(val >= min)
            {
                return val;
            } else
            {
                int org = min;
                min = 2 * min - val;
                return org;
            }
        }

        int top()
        {
            if(data.isEmpty())
            {
                System.out.println("Stack underflow");
                return -1;
            } else
            {
                int tos = ((Integer)data.peek()).intValue();
                return tos < min ? min : tos;
            }
        }

        int min()
        {
            if(data.isEmpty())
            {
                System.out.println("Stack underflow");
                return -1;
            } else
            {
                return min;
            }
        }

        Stack data;
        int min;

        public MinStack()
        {
            data = new Stack();
        }
    }


    public MinimuStackConstantSpace()
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

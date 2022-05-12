// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LinkedListToStackAdapter.java

package pratice.pepcoding.beginner.BasicDS.Adapter;

import java.io.*;
import java.util.LinkedList;

public class LinkedListToStackAdapter
{
    public static class LLToStackAdapter
    {

        int size()
        {
            return list.size();
        }

        void push(int val)
        {
            list.addFirst(Integer.valueOf(val));
        }

        int pop()
        {
            if(list.isEmpty())
            {
                System.out.println("Stack underflow");
                return -1;
            } else
            {
                return ((Integer)list.removeFirst()).intValue();
            }
        }

        int top()
        {
            if(list.isEmpty())
            {
                System.out.println("Stack underflow");
                return -1;
            } else
            {
                return ((Integer)list.getFirst()).intValue();
            }
        }

        LinkedList list;

        public LLToStackAdapter()
        {
            list = new LinkedList();
        }
    }


    public LinkedListToStackAdapter()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LLToStackAdapter st = new LLToStackAdapter();
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
                System.out.println(st.size());
        }

    }
}

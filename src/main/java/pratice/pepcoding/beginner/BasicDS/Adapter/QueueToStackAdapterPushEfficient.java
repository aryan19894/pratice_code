// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   QueueToStackAdapterPushEfficient.java

package pratice.pepcoding.beginner.BasicDS.Adapter;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStackAdapterPushEfficient
{
    public static class QueueToStackAdapter
    {

        int size()
        {
            return mainQ.size();
        }

        void push(int val)
        {
            mainQ.add(Integer.valueOf(val));
        }

        int pop()
        {
            if(size() == 0)
            {
                System.out.println("Stack underflow");
                return -1;
            }
            for(; mainQ.size() > 1; helperQ.add(mainQ.remove()));
            int pop = ((Integer)mainQ.remove()).intValue();
            for(; !helperQ.isEmpty(); mainQ.add(helperQ.remove()));
            return pop;
        }

        int top()
        {
            if(size() == 0)
            {
                System.out.println("Stack underflow");
                return -1;
            }
            for(; mainQ.size() > 1; helperQ.add(mainQ.remove()));
            int pop = ((Integer)mainQ.remove()).intValue();
            helperQ.add(Integer.valueOf(pop));
            for(; !helperQ.isEmpty(); mainQ.add(helperQ.remove()));
            return pop;
        }

        Queue mainQ;
        Queue helperQ;

        public QueueToStackAdapter()
        {
            mainQ = new ArrayDeque();
            helperQ = new ArrayDeque();
        }
    }


    public QueueToStackAdapterPushEfficient()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        QueueToStackAdapter st = new QueueToStackAdapter();
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

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NormalQueue.java

package pratice.pepcoding.beginner.BasicDS.StacksQueues.CustomQueue;

import java.io.*;

public class NormalQueue
{
    public static class CustomQueue
    {

        int size()
        {
            return size;
        }

        void display()
        {
            int i = front;
            for(int len = size; len > 0; len--)
            {
                System.out.print((new StringBuilder()).append(data[i]).append(" ").toString());
                i = ++i % data.length;
            }

            System.out.println();
        }

        void add(int val)
        {
            if(size == data.length)
            {
                System.out.println("Queue overflow");
            } else
            {
                int idx = (front + size) % data.length;
                data[idx] = val;
                size++;
            }
        }

        int remove()
        {
            if(size == 0)
            {
                System.out.println("Queue underflow");
                return -1;
            } else
            {
                int top = data[front];
                front = (front + 1) % data.length;
                size--;
                return top;
            }
        }

        int peek()
        {
            if(size == 0)
            {
                System.out.println("Queue underflow");
                return -1;
            } else
            {
                return data[front];
            }
        }

        int data[];
        int front;
        int size;

        public CustomQueue(int cap)
        {
            data = new int[cap];
            front = 0;
            size = 0;
        }
    }


    public NormalQueue()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomQueue qu = new CustomQueue(n);
        for(String str = br.readLine(); !str.equals("quit"); str = br.readLine())
        {
            if(str.startsWith("add"))
            {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
                continue;
            }
            if(str.startsWith("remove"))
            {
                int val = qu.remove();
                if(val != -1)
                    System.out.println(val);
                continue;
            }
            if(str.startsWith("peek"))
            {
                int val = qu.peek();
                if(val != -1)
                    System.out.println(val);
                continue;
            }
            if(str.startsWith("size"))
            {
                System.out.println(qu.size());
                continue;
            }
            if(str.startsWith("display"))
                qu.display();
        }

    }
}

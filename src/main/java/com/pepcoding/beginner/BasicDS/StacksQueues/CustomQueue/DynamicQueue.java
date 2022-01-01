// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DynamicQueue.java

package com.pepcoding.beginner.BasicDS.StacksQueues.CustomQueue;

import java.io.*;

public class DynamicQueue
{
    public static class CustomQueue
    {

        int size()
        {
            return size;
        }

        void display()
        {
            for(int i = 0; i < size; i++)
            {
                int idx = (front + i) % data.length;
                System.out.print((new StringBuilder()).append(data[idx]).append(" ").toString());
            }

            System.out.println();
        }

        void add(int val)
        {
            if(size == data.length)
                increaseQueueCapacity();
            int idx = (front + size) % data.length;
            data[idx] = val;
            size++;
        }

        private void increaseQueueCapacity()
        {
            int newData[] = new int[2 * data.length];
            for(int i = 0; i < size; i++)
            {
                int idx = (front + i) % data.length;
                newData[i] = data[idx];
            }

            data = newData;
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


    public DynamicQueue()
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

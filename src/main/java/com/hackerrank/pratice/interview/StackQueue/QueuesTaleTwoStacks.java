// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   QueuesTaleTwoStacks.java

package com.hackerrank.pratice.interview.StackQueue;

import java.io.PrintStream;
import java.util.Scanner;

// Referenced classes of package com.hackerrank.pratice.interview.StackQueue:
//            MyQueue

public class QueuesTaleTwoStacks
{

    public QueuesTaleTwoStacks()
    {
    }

    public static void main(String args[])
    {
        MyQueue queue = new MyQueue();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0; i < n; i++)
        {
            int operation = scan.nextInt();
            if(operation == 1)
            {
                queue.enqueue(Integer.valueOf(scan.nextInt()));
                continue;
            }
            if(operation == 2)
            {
                queue.dequeue();
                continue;
            }
            if(operation == 3)
                System.out.println(queue.peek());
        }

        scan.close();
    }
}

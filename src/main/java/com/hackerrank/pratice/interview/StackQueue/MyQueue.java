// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   QueuesTaleTwoStacks.java

package com.hackerrank.pratice.interview.StackQueue;

import java.util.Stack;

class MyQueue
{

    MyQueue()
    {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void enqueue(Object item)
    {
        stack1.push(item);
    }

    public Object dequeue()
    {
        if(size() == 0)
            return null;
        if(stack2.isEmpty())
            shiftStacks();
        return stack2.pop();
    }

    public Object peek()
    {
        if(size() == 0)
            return null;
        if(stack2.isEmpty())
            shiftStacks();
        return stack2.peek();
    }

    private void shiftStacks()
    {
        if(stack2.isEmpty())
            for(; !stack1.isEmpty(); stack2.push(stack1.pop()));
    }

    public int size()
    {
        return stack1.size() + stack2.size();
    }

    private Stack stack1;
    private Stack stack2;
}

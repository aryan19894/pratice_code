// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PoisonousPlants.java

package com.hackerrank.pratice.interview.StackQueue;

import java.io.PrintStream;
import java.util.*;

public class PoisonousPlants
{

    public PoisonousPlants()
    {
    }

    static int poisonousPlants(int p[])
    {
        int count = 0;
        List list = new ArrayList();
        Stack current = new Stack();
        for(int i = 0; i < p.length; i++)
            if(current.isEmpty() || ((Integer)current.peek()).intValue() >= p[i])
            {
                current.push(Integer.valueOf(p[i]));
            } else
            {
                list.add(current);
                current = new Stack();
                current.push(Integer.valueOf(p[i]));
            }

        if(!current.isEmpty())
            list.add(current);
        while(list.size() > 1) 
        {
            count++;
            int i = list.size() - 1;
            while(i > 0) 
            {
                current = (Stack)list.get(i);
                current.remove(0);
                Stack beforeCurrent = (Stack)list.get(i - 1);
                if(current.isEmpty())
                    list.remove(i);
                else
                if(((Integer)beforeCurrent.peek()).intValue() >= ((Integer)current.get(0)).intValue())
                {
                    beforeCurrent.addAll(current);
                    list.remove(i);
                }
                i--;
            }
        }
        return count;
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int p[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            int item = scan.nextInt();
            p[i] = item;
        }

        int result = poisonousPlants(p);
        System.out.println(result);
    }
}

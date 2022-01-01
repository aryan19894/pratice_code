// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FraudulentActivityNotifications2.java

package com.hackerrank.pratice.interview.Sorting;

import java.io.PrintStream;
import java.util.*;

public class FraudulentActivityNotifications2
{

    public FraudulentActivityNotifications2()
    {
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int d = input.nextInt();
        int notifications = 0;
        Queue queue = new LinkedList();
        int pastActivity[] = new int[201];
        for(int i = 0; i < d; i++)
        {
            int transaction = input.nextInt();
            queue.offer(Integer.valueOf(transaction));
            pastActivity[transaction] = pastActivity[transaction] + 1;
        }

        for(int i = 0; i < n - d; i++)
        {
            int newTransaction = input.nextInt();
            if((double)newTransaction >= 2D * median(pastActivity, d))
                notifications++;
            int oldestTransaction = ((Integer)queue.poll()).intValue();
            pastActivity[oldestTransaction] = pastActivity[oldestTransaction] - 1;
            queue.offer(Integer.valueOf(newTransaction));
            pastActivity[newTransaction] = pastActivity[newTransaction] + 1;
        }

        System.out.println(notifications);
    }

    static double median(int array[], int elements)
    {
        int index = 0;
        if(elements % 2 == 0)
        {
            int counter;
            for(counter = elements / 2; counter > 0;)
            {
                counter -= array[index];
                index++;
            }

            index--;
            if(counter <= -1)
                return (double)index;
            int firstIndex = index;
            int secondIndex;
            for(secondIndex = index + 1; array[secondIndex] == 0; secondIndex++);
            return (double)(firstIndex + secondIndex) / 2D;
        }
        for(int counter = elements / 2; counter >= 0;)
        {
            counter -= array[index];
            index++;
        }

        return (double)index - 1.0D;
    }
}

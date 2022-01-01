// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FraudulentActivityNotifications.java

package com.hackerrank.pratice.interview.Sorting;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.IntStream;

public class FraudulentActivityNotifications
{

    public FraudulentActivityNotifications()
    {
    }

    static int activityNotifications(int expenditure[], int d)
    {
        Queue queue = new LinkedList();
        int max = Arrays.stream(expenditure).max().getAsInt();
        int pastActivity[] = new int[max + 1];
        int time = 0;
        int n = expenditure.length;
        for(int i = 0; i < d; i++)
        {
            queue.offer(Integer.valueOf(expenditure[i]));
            pastActivity[expenditure[i]]++;
        }

        for(int i = d; i < n; i++)
        {
            int val = expenditure[i];
            if((double)val >= 2D * median(pastActivity, d))
                time++;
            int oldVal = ((Integer)queue.poll()).intValue();
            pastActivity[oldVal]--;
            queue.offer(Integer.valueOf(val));
            pastActivity[val]++;
        }

        return time;
    }

    private static double median(int arr[], int d)
    {
        int i = 0;
        if(d % 2 == 0)
        {
            int counter;
            for(counter = d / 2; counter > 0;)
            {
                counter -= arr[i];
                i++;
            }

            i--;
            if(counter <= -1)
                return (double)i;
            int firstIndex = i;
            int secondIndex;
            for(secondIndex = i + 1; arr[secondIndex] == 0; secondIndex++);
            return (double)(firstIndex + secondIndex) / 2D;
        }
        for(int counter = d / 2; counter >= 0;)
        {
            counter -= arr[i];
            i++;
        }

        return (double)i - 1.0D;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        int ans = activityNotifications(arr, d);
        System.out.println(ans);
    }
}

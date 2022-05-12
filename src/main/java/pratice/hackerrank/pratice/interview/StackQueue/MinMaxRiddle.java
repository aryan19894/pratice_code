// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MinMaxRiddle.java

package pratice.hackerrank.pratice.interview.StackQueue;

import java.io.PrintStream;
import java.util.*;

public class MinMaxRiddle
{

    public MinMaxRiddle()
    {
    }

    static long[] riddle(long arr[])
    {
        int n = arr.length;
        long res[] = new long[n];
        Queue q = new LinkedList();
        int i = n;
        int j = 0;
        int k = 0;
        while(i > 0) 
        {
            do
            {
                if(j >= n)
                    break;
                q.offer(Long.valueOf(arr[j++]));
                if(++k == i)
                {
                    long min = ((Long)Collections.min(q)).longValue();
                    q.poll();
                    res[i - 1] = Math.max(res[i - 1], min);
                    k--;
                }
            } while(true);
            j = 0;
            k = 0;
            i--;
            q.clear();
        }
        return res;
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long h[] = new long[n];
        for(int i = 0; i < n; i++)
        {
            long e = scan.nextLong();
            h[i] = e;
        }

        long result[] = riddle(h);
        System.out.println(Arrays.toString(result));
        scan.close();
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LargestRectangle.java

package pratice.hackerrank.pratice.interview.StackQueue;

import java.io.PrintStream;
import java.util.*;

public class LargestRectangle
{

    public LargestRectangle()
    {
    }

    static long largestRectangle(int h[])
    {
        Stack s = new Stack();
        int n = h.length;
        h = Arrays.copyOf(h, n + 1);
        int maximum = 0;
        for(int x0 = 0; x0 <= n; x0++)
        {
            int x1 = x0;
            while(!s.isEmpty() && h[((int[])s.peek())[0]] >= h[x0]) 
            {
                int x[] = (int[])s.pop();
                x1 = x[1];
                maximum = Math.max(maximum, h[x[0]] * (x0 - x1));
            }
            s.push(new int[] {
                x0, x1
            });
        }

        return (long)maximum;
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int h[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            int e = scan.nextInt();
            h[i] = e;
        }

        long result = largestRectangle(h);
        System.out.println(result);
        scan.close();
    }
}

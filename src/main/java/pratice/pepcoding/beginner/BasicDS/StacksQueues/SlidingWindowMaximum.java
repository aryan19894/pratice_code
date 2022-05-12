// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SlidingWindowMaximum.java

package pratice.pepcoding.beginner.BasicDS.StacksQueues;

import java.io.*;
import java.util.Stack;

public class SlidingWindowMaximum
{

    public SlidingWindowMaximum()
    {
    }

    public static void main(String args[])
        throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());

        int k = Integer.parseInt(br.readLine());
        int grt[] = new int[n];
        grt[n - 1] = n;
        Stack st = new Stack();
        st.push(Integer.valueOf(n - 1));
        for(int i = n - 2; i >= 0; i--)
        {
            for(; !st.isEmpty() && a[i] >= a[((Integer)st.peek()).intValue()]; st.pop());
            grt[i] = st.isEmpty() ? n : ((Integer)st.peek()).intValue();
            st.push(Integer.valueOf(i));
        }

        int j = 0;
        for(int i = 0; i <= n - k; i++)
        {
            if(j < i)
                j = i;
            for(; grt[j] < i + k; j = grt[j]);
            System.out.println(a[j]);
        }

    }
}

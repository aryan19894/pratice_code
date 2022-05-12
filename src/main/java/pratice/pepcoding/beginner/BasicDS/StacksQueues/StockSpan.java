// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StockSpan.java

package pratice.pepcoding.beginner.BasicDS.StacksQueues;

import java.io.*;
import java.util.Stack;

public class StockSpan
{

    public StockSpan()
    {
    }

    public static void display(int a[])
    {
        StringBuilder sb = new StringBuilder();
        int ai[] = a;
        int i = ai.length;
        for(int j = 0; j < i; j++)
        {
            int val = ai[j];
            sb.append((new StringBuilder()).append(val).append("\n").toString());
        }

        System.out.println(sb);
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());

        int span[] = solve(a);
        display(span);
    }

    public static int[] solve(int arr[])
    {
        int n = arr.length;
        int span[] = new int[n];
        span[0] = 1;
        Stack st = new Stack();
        st.push(Integer.valueOf(0));
        for(int i = 1; i < n; i++)
        {
            for(; !st.isEmpty() && arr[((Integer)st.peek()).intValue()] < arr[i]; st.pop());
            span[i] = st.isEmpty() ? i + 1 : i - ((Integer)st.peek()).intValue();
            st.push(Integer.valueOf(i));
        }

        return span;
    }
}

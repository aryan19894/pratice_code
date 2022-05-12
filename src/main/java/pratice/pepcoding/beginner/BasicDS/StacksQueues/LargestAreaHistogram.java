// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LargestAreaHistogram.java

package pratice.pepcoding.beginner.BasicDS.StacksQueues;

import java.io.*;
import java.util.Stack;

public class LargestAreaHistogram
{

    public LargestAreaHistogram()
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

        int right[] = new int[n];
        right[n - 1] = n;
        Stack st = new Stack();
        st.push(Integer.valueOf(n - 1));
        for(int i = n - 2; i >= 0; i--)
        {
            for(; !st.isEmpty() && a[i] <= a[((Integer)st.peek()).intValue()]; st.pop());
            right[i] = st.isEmpty() ? n : ((Integer)st.peek()).intValue();
            st.push(Integer.valueOf(i));
        }

        int left[] = new int[n];
        left[0] = -1;
        st = new Stack();
        st.push(Integer.valueOf(0));
        for(int i = 1; i < n; i++)
        {
            for(; !st.isEmpty() && a[i] <= a[((Integer)st.peek()).intValue()]; st.pop());
            left[i] = st.isEmpty() ? -1 : ((Integer)st.peek()).intValue();
            st.push(Integer.valueOf(i));
        }

        int maxArea = 0;
        for(int i = 0; i < n; i++)
        {
            int w = right[i] - left[i] - 1;
            int area = a[i] * w;
            maxArea = Math.max(maxArea, area);
        }

        System.out.println(maxArea);
    }
}

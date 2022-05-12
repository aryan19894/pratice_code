// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SmallestNumberFollowingPattern.java

package pratice.pepcoding.beginner.BasicDS.StacksQueues;

import java.io.*;
import java.util.Stack;

public class SmallestNumberFollowingPattern
{

    public SmallestNumberFollowingPattern()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        Stack st = new Stack();
        int c = 1;
        for(int i = 0; i < n; i++)
        {
            char ch = str.charAt(i);
            if(ch == 'd')
            {
                st.push(Integer.valueOf(c++));
                continue;
            }
            st.push(Integer.valueOf(c++));
            for(; !st.isEmpty(); System.out.print(st.pop()));
        }

        st.push(Integer.valueOf(c++));
        for(; !st.isEmpty(); System.out.print(st.pop()));
    }
}

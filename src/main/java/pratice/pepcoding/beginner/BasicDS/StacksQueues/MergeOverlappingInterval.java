// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MergeOverlappingInterval.java

package pratice.pepcoding.beginner.BasicDS.StacksQueues;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingInterval
{
    static class Pair
        implements Comparable
    {

        public int compareTo(Pair ot)
        {
            if(st != ot.st)
                return st - ot.st;
            else
                return en - ot.en;
        }

        public String toString()
        {
            return (new StringBuilder()).append(st).append(" ").append(en).toString();
        }

        public int compareTo(Object obj)
        {
            return compareTo((Pair)obj);
        }

        int st;
        int en;

        public Pair(int st, int en)
        {
            this.st = st;
            this.en = en;
        }
    }


    public MergeOverlappingInterval()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];
        for(int j = 0; j < n; j++)
        {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int a[][])
    {
        int n = a.length;
        Pair pairs[] = new Pair[n];
        for(int i = 0; i < n; i++)
            pairs[i] = new Pair(a[i][0], a[i][1]);

        Arrays.sort(pairs);
        Stack st = new Stack();
        st.push(pairs[0]);
        for(int i = 1; i < n; i++)
        {
            Pair c = pairs[i];
            Pair tos = (Pair)st.peek();
            if(pairs[i].st > tos.en)
                st.push(c);
            else
                tos.en = Math.max(tos.en, pairs[i].en);
        }

        Stack ref = new Stack();
        for(; !st.isEmpty(); ref.push(st.pop()));
        for(; !ref.isEmpty(); System.out.println(ref.pop()));
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   KLargestElements.java

package pratice.pepcoding.beginner.AdvanceDS.HashmpHeap;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElements
{

    public KLargestElements()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());

        int k = Integer.parseInt(br.readLine());
        findKLargerElement(a, n, k);
    }

    private static void findKLargerElement(int a[], int n, int k)
    {
        PriorityQueue pq = new PriorityQueue(Collections.reverseOrder());
        for(int i = 0; i < n; i++)
        {
            if(i < k)
            {
                pq.add(Integer.valueOf(a[i]));
                continue;
            }
            if(a[i] > ((Integer)pq.peek()).intValue())
            {
                pq.remove();
                pq.add(Integer.valueOf(a[i]));
            }
        }

        for(; !pq.isEmpty(); pq.remove())
            System.out.println(pq.peek());

    }
}

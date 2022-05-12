// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SockMerchant.java

package pratice.hackerrank.pratice.interview.warmup;

import java.util.*;

public class SockMerchant
{

    public SockMerchant()
    {
    }

    static int sockMerchant(int n, int ar[])
    {
        Map number = new HashMap();
        for(int i = 0; i < n; i++)
            addToMap(number, ar[i]);

        int res = 0;
        for(Iterator iterator = number.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            res += ((Integer)entry.getValue()).intValue() / 2;
        }

        return res;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ar[] = new int[n];
        for(int i = 0; i < n; i++)
            ar[i] = in.nextInt();

        sockMerchant(n, ar);
    }

    private static void addToMap(Map number, int key)
    {
        number.putIfAbsent(Integer.valueOf(key), Integer.valueOf(0));
        number.put(Integer.valueOf(key), Integer.valueOf(((Integer)number.get(Integer.valueOf(key))).intValue() + 1));
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SherlockAnagrams.java

package com.hackerrank.pratice.interview.dictionaries_hashmaps;

import java.io.PrintStream;
import java.util.*;

public class SherlockAnagrams
{

    public SherlockAnagrams()
    {
    }

    static int sherlockAndAnagrams(String st)
    {
        int res = 0;
        int N = st.length();
        char str[] = st.toCharArray();
        Map mp = new HashMap();
        for(int i = 0; i < N; i++)
        {
            int freq[] = new int[MAX_CHARS];
            for(int j = i; j < N; j++)
            {
                freq[toNumber(str[j])]++;
                addToMap(mp, freq);
            }

        }

        for(Iterator iterator = mp.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            int freq = ((Integer)entry.getValue()).intValue();
            res += (freq * (freq - 1)) / 2;
        }

        return res;
    }

    static int toNumber(char c)
    {
        return c - 97;
    }

    private static void addToMap(Map number, int k[])
    {
        String key = Arrays.toString(k);
        number.putIfAbsent(key, Integer.valueOf(0));
        number.put(key, Integer.valueOf(((Integer)number.get(key)).intValue() + 1));
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int i = 0; i < q; i++)
        {
            String str = in.next();
            int ans = sherlockAndAnagrams(str);
            System.out.println(ans);
        }

    }

    static int MAX_CHARS = 26;

}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MakingAnagrams.java

package com.hackerrank.pratice.interview.String;

import java.io.PrintStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MakingAnagrams
{

    public MakingAnagrams()
    {
    }

    static int makeAnagram(String a, String b)
    {
        int count = 0;
        Map freq = new ConcurrentHashMap();
        char ac[] = a.toCharArray();
        int j = ac.length;
        for(int k = 0; k < j; k++)
        {
            char ch = ac[k];
            freq = addToMap(freq, ch);
        }

        ac = b.toCharArray();
        j = ac.length;
        for(int l = 0; l < j; l++)
        {
            char ch = ac[l];
            if(freq.containsKey(Character.valueOf(ch)) && ((Integer)freq.get(Character.valueOf(ch))).intValue() != 0)
                freq.put(Character.valueOf(ch), Integer.valueOf(((Integer)freq.get(Character.valueOf(ch))).intValue() - 1));
            else
                count++;
        }

        for(Iterator iterator = freq.values().iterator(); iterator.hasNext();)
        {
            Integer i = (Integer)iterator.next();
            count += i.intValue();
        }

        return count;
    }

    private static Map refresh(Map freq)
    {
        Iterator iterator = freq.entrySet().iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            java.util.Map.Entry e = (java.util.Map.Entry)iterator.next();
            if(((Integer)e.getValue()).intValue() == 0)
                freq.remove(e.getKey());
        } while(true);
        return freq;
    }

    private static Map addToMap(Map freq, char ch)
    {
        freq.putIfAbsent(Character.valueOf(ch), Integer.valueOf(0));
        freq.put(Character.valueOf(ch), Integer.valueOf(((Integer)freq.get(Character.valueOf(ch))).intValue() + 1));
        return freq;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        System.out.println(makeAnagram(a, b));
    }
}

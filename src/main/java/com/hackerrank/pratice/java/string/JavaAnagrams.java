// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaAnagrams.java

package com.hackerrank.pratice.java.string;

import java.io.PrintStream;
import java.util.*;

public class JavaAnagrams
{

    public JavaAnagrams()
    {
    }

    static boolean isAnagram(String a, String b)
    {
        if(a == null || b == null || a.equals("") || b.equals(""))
            return false;
        if(a.length() != b.length())
            return false;
        a = a.toLowerCase();
        b = b.toLowerCase();
        Map map = new HashMap();
        for(int i = 0; i < b.length(); i++)
        {
            char ch = b.charAt(i);
            if(!map.containsKey(Character.valueOf(ch)))
                map.put(Character.valueOf(ch), Integer.valueOf(1));
            else
                map.put(Character.valueOf(ch), Integer.valueOf(((Integer)map.get(Character.valueOf(ch))).intValue() + 1));
        }

        for(int i = 0; i < a.length(); i++)
        {
            char ch = a.charAt(i);
            if(!map.containsKey(Character.valueOf(ch)))
                return false;
            int freq = ((Integer)map.get(Character.valueOf(ch))).intValue();
            if(freq == 0)
                return false;
            map.put(Character.valueOf(ch), Integer.valueOf(--freq));
        }

        return true;
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println(ret ? "Anagrams" : "Not Anagrams");
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ZigzagConversion_6.java

package com.leetcode.common.medium;


class ZigzagConversion_6
{

    ZigzagConversion_6()
    {
    }

    public static String convert(String s, int numRows)
    {
        if(numRows == 1)
            return s;
        int cycle = numRows * 2 - 2;
        char charArray[] = new char[s.length()];
        int pointer = 0;
        for(int i = 0; i < s.length(); i += cycle)
            charArray[pointer++] = s.charAt(i);

        for(int i = 1; i < numRows - 1; i++)
        {
            int j = i;
            for(int k = cycle - j; j < s.length(); k += cycle)
            {
                charArray[pointer++] = s.charAt(j);
                if(k < s.length())
                    charArray[pointer++] = s.charAt(k);
                j += cycle;
            }

        }

        for(int i = numRows - 1; i < s.length(); i += cycle)
            charArray[pointer++] = s.charAt(i);

        return String.valueOf(charArray);
    }
}

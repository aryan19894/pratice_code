// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LongestSubstringWithoutRepeatingCharacters_3.java

package com.leetcode.common.medium;


class LongestSubstringWithoutRepeatingCharacters_3
{

    LongestSubstringWithoutRepeatingCharacters_3()
    {
    }

    public int lengthOfLongestSubstring(String s)
    {
        int len = 0;
        int cache[] = new int[256];
        int i = 0;
        int j = 0;
        for(; i < s.length(); i++)
        {
            char curr = s.charAt(i);
            j = cache[curr] <= 0 ? j : Math.max(j, cache[curr]);
            cache[curr] = i + 1;
            len = Math.max(len, (i - j) + 1);
        }

        return len;
    }
}

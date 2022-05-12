// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LongestPalindromicSubstring_5.java

package pratice.leetcode.common.medium;


class LongestPalindromicSubstring_5
{

    LongestPalindromicSubstring_5()
    {
    }

    public String longestPalindrome(String s)
    {
        int max = 0;
        int idx = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int len1 = extend(s, i, i);
            int len2 = extend(s, i, i + 1);
            if(max < Math.max(len1, len2))
            {
                idx = len1 <= len2 ? (i - len2 / 2) + 1 : i - len1 / 2;
                max = Math.max(len1, len2);
            }
        }

        return s.substring(idx, idx + max);
    }

    private int extend(String s, int i, int j)
    {
        for(; i >= 0 && j < s.length(); j++)
        {
            if(s.charAt(i) != s.charAt(j))
                break;
            i--;
        }

        return (j - i - 2) + 1;
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RegularExpressionMatching_10.java

package com.leetcode.facebook.hard;


class RegularExpressionMatching_10
{

    RegularExpressionMatching_10()
    {
    }

    public boolean isMatch(String s, String p)
    {
        if(p == null || p.length() == 0)
            return s == null || s.length() == 0;
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int j = 2; j <= p.length(); j++)
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];

        for(int j = 1; j <= p.length(); j++)
        {
            for(int i = 1; i <= s.length(); i++)
                if(p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else
                if(p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 2] || (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j];

        }

        return dp[s.length()][p.length()];
    }
}

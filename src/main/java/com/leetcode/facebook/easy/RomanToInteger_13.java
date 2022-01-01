// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RomanToInteger_13.java

package com.leetcode.facebook.easy;


class RomanToInteger_13
{

    RomanToInteger_13()
    {
    }

    public int romanToInt(String S)
    {
        int ans = 0;
        int num = 0;
        for(int i = S.length() - 1; i >= 0; i--)
        {
            switch(S.charAt(i))
            {
            case 73: // 'I'
                num = 1;
                break;

            case 86: // 'V'
                num = 5;
                break;

            case 88: // 'X'
                num = 10;
                break;

            case 76: // 'L'
                num = 50;
                break;

            case 67: // 'C'
                num = 100;
                break;

            case 68: // 'D'
                num = 500;
                break;

            case 77: // 'M'
                num = 1000;
                break;
            }
            if(4 * num < ans)
                ans -= num;
            else
                ans += num;
        }

        return ans;
    }
}

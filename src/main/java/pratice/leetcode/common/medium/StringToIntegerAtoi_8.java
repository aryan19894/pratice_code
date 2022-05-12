// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StringToIntegerAtoi_8.java

package pratice.leetcode.common.medium;


class StringToIntegerAtoi_8
{

    StringToIntegerAtoi_8()
    {
    }

    public int myAtoi(String s)
    {
        int idx = 0;
        int sign = 1;
        int total = 0;
        s = s.trim();
        if(s.isEmpty())
            return 0;
        if(s.charAt(idx) == '-' || s.charAt(idx) == '+')
        {
            sign = s.charAt(idx) != '+' ? -1 : 1;
            idx++;
        }
        for(; idx < s.length(); idx++)
        {
            int digit = s.charAt(idx) - 48;
            if(digit < 0 || digit > 9)
                break;
            int MAX = 0x7fffffff;
            if(MAX / 10 < total || MAX / 10 == total && MAX % 10 < digit)
                return sign != 1 ? 0x80000000 : MAX;
            total = total * 10 + digit;
        }

        return total * sign;
    }
}

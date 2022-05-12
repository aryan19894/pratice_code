// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ReverseInteger_7.java

package pratice.leetcode.common.medium;


class ReverseInteger_7
{

    ReverseInteger_7()
    {
    }

    public int reverse(int x)
    {
        int res = 0;
        for(; x != 0; x /= 10)
        {
            int r = x % 10;
            int newRes = 10 * res + r;
            if((newRes - r) / 10 != res)
                return 0;
            res = newRes;
        }

        return res;
    }
}

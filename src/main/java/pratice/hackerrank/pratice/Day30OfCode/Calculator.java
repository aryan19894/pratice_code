// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day17_MoreExceptions.java

package pratice.hackerrank.pratice.Day30OfCode;


class Calculator
{

    Calculator()
    {
    }

    public int power(int n, int p)
    {
        if(n >= 0 && p >= 0)
            return (int)Math.pow(n, p);
        else
            throw new RuntimeException("n and p should be non-negative");
    }
}

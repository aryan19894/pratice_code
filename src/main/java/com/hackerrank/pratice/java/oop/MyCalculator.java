// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaInterface.java

package com.hackerrank.pratice.java.oop;


// Referenced classes of package com.hackerrank.pratice.java.oop:
//            AdvancedArithmetic

class MyCalculator
    implements AdvancedArithmetic
{

    MyCalculator()
    {
    }

    public int divisor_sum(int n)
    {
        int sum = 0;
        int sqrt = (int)Math.sqrt(n);
        for(int i = 1; i <= sqrt; i++)
            if(n % i == 0)
                sum += i + n / i;

        if(sqrt * sqrt == n)
            sum -= sqrt;
        return sum;
    }
}

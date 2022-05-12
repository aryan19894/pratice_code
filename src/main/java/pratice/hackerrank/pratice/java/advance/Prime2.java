// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrimeChecker2.java

package pratice.hackerrank.pratice.java.advance;

import java.io.PrintStream;

class Prime2
{

    Prime2()
    {
    }

    void checkPrime(int numbers[])
    {
        int ai[] = numbers;
        int i = ai.length;
        for(int j = 0; j < i; j++)
        {
            int num = ai[j];
            if(isPrime(num))
                System.out.print((new StringBuilder()).append(num).append(" ").toString());
        }

        System.out.println();
    }

    boolean isPrime(int n)
    {
        if(n < 2)
            return false;
        if(n == 2)
            return true;
        if(n % 2 == 0)
            return false;
        int sqrt = (int)Math.sqrt(n);
        for(int i = 3; i <= sqrt; i += 2)
            if(n % i == 0)
                return false;

        return true;
    }
}

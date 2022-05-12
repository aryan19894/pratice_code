// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IsANumberPrime.java

package pratice.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

import java.io.PrintStream;
import java.util.Scanner;

public class IsANumberPrime
{

    public IsANumberPrime()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++)
        {
            int n = in.nextInt();
            System.out.println(isPrime(n) ? "prime" : "not prime");
        }

    }

    private static boolean isPrime(int n)
    {
        if(n <= 1 || n % 2 == 0)
            return false;
        if(n == 2)
            return true;
        for(int i = 3; (double)i <= Math.sqrt(n); i++)
            if(n % i == 0)
                return false;

        return true;
    }
}

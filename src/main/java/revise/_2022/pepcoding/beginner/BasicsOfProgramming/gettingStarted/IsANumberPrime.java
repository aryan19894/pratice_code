// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IsANumberPrime.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

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
        for(int i = 2; (double)i <= Math.sqrt(n); i++)
            if(n % i == 0)
                return false;

        return true;
    }
}

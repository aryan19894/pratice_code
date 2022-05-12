// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrimeFactorisationOfANumber.java

package pratice.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

import java.io.PrintStream;
import java.util.Scanner;

public class PrimeFactorisationOfANumber
{

    public PrimeFactorisationOfANumber()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a = 2; a * a <= n;)
            if(n % a == 0)
            {
                System.out.print((new StringBuilder()).append(a).append(" ").toString());
                n /= a;
            } else
            {
                a++;
            }

        if(n != 1)
            System.out.println(n);
    }
}

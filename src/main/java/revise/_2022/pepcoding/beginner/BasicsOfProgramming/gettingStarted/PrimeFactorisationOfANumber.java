// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrimeFactorisationOfANumber.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

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
        for(int div = 2; div * div <= n;)
            if(n % div == 0)
            {
                System.out.print((new StringBuilder()).append(div).append(" ").toString());
                n /= div;
            } else
            {
                div++;
            }

        if(n != 1)
            System.out.println(n);
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DigitsOfANumber.java

package pratice.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

import java.io.PrintStream;
import java.util.Scanner;

public class DigitsOfANumber
{

    public DigitsOfANumber()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = 1;
        int temp = n;
        while(n >= 10) 
        {
            n /= 10;
            p *= 10;
        }
        for(; p != 0; p /= 10)
        {
            int digit = temp / p;
            System.out.println(digit);
            temp %= p;
        }

    }
}

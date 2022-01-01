// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   InverseOfANumber.java

package revise.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

import java.io.PrintStream;
import java.util.Scanner;

public class InverseOfANumber
{

    public InverseOfANumber()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i = 1;
        int ans = 0;
        for(; n > 0; n /= 10)
        {
            int d = n % 10;
            ans = (int)((double)ans + Math.pow(10D, d - 1) * (double)i);
            i++;
        }

        System.out.println(ans);
    }
}

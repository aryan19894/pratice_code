// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RotateANumber.java

package pratice.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

import java.io.PrintStream;
import java.util.Scanner;

public class RotateANumber
{

    public RotateANumber()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int len = (int)Math.log10(n) + 1;
        k %= len;
        int pre = (int)Math.pow(10D, Math.abs(k));
        int post = (int)Math.pow(10D, len - Math.abs(k));
        if(k > 0)
        {
            int r = n % pre;
            n /= pre;
            n += r * post;
        } else
        {
            int r = n % post;
            n /= post;
            n += r * pre;
        }
        System.out.println(n);
    }
}

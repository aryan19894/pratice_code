// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GcdAndLcm.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

import java.io.PrintStream;
import java.util.Scanner;

public class GcdAndLcm
{

    public GcdAndLcm()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int prod = a * b;
        int rem;
        for(; a % b > 0; b = rem)
        {
            rem = a % b;
            a = b;
        }

        System.out.println(b);
        System.out.println(prod / b);
    }
}

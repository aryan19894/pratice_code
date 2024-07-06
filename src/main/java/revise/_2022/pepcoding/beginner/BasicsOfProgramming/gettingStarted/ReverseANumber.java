// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ReverseANumber.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

import java.io.PrintStream;
import java.util.Scanner;

public class ReverseANumber
{

    public ReverseANumber()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        for(int n = in.nextInt(); n > 0; n /= 10)
            System.out.println(n % 10);

    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CountDigitsInANumber.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

import java.io.PrintStream;
import java.util.Scanner;

public class CountDigitsInANumber
{

    public CountDigitsInANumber()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(String.valueOf(n).length());
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day16_ExceptionStringInteger.java

package pratice.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.Scanner;

public class Day16_ExceptionStringInteger
{

    public Day16_ExceptionStringInteger()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        try
        {
            System.out.println(Integer.valueOf(S));
        }
        catch(NumberFormatException e)
        {
            System.out.println("Bad String");
        }
    }
}

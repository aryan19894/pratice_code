// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaExceptionHandling.java

package com.hackerrank.pratice.java.exception;

import java.io.PrintStream;
import java.util.Scanner;

// Referenced classes of package com.hackerrank.pratice.java.exception:
//            MyCalculator

public class JavaExceptionHandling
{

    public JavaExceptionHandling()
    {
    }

    public static void main(String args[])
    {
        while(in.hasNextInt()) 
        {
            int n = in.nextInt();
            int p = in.nextInt();
            try
            {
                System.out.println(my_calculator.power(n, p));
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }

    public static final MyCalculator my_calculator = new MyCalculator();
    public static final Scanner in;

    static 
    {
        in = new Scanner(System.in);
    }
}

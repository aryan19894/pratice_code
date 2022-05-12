// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaExceptionHandlingTrycatch.java

package pratice.hackerrank.pratice.java.exception;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaExceptionHandlingTrycatch
{

    public JavaExceptionHandlingTrycatch()
    {
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        try
        {
            int x = scan.nextInt();
            int y = scan.nextInt();
            System.out.println(x / y);
        }
        catch(InputMismatchException e)
        {
            System.out.println(e.getClass().getName());
        }
        catch(ArithmeticException e)
        {
            System.out.println((new StringBuilder()).append(e.getClass().getName()).append(": / by zero").toString());
        }
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaStdinStdout.java

package pratice.hackerrank.pratice.java.introduction;

import java.io.PrintStream;
import java.util.Scanner;

public class JavaStdinStdout
{

    public JavaStdinStdout()
    {
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaEOF.java

package pratice.hackerrank.pratice.java.introduction;

import java.io.PrintStream;
import java.util.Scanner;

public class JavaEOF
{

    public JavaEOF()
    {
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        for(; scan.hasNext(); System.out.println((new StringBuilder()).append(i).append(" ").append(scan.nextLine()).toString()))
            i++;

    }
}

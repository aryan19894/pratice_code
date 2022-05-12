// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day26_NestedLogic.java

package pratice.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.Scanner;

public class Day26_NestedLogic
{

    public Day26_NestedLogic()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int da = sc.nextInt();
        int ma = sc.nextInt();
        int ya = sc.nextInt();
        int de = sc.nextInt();
        int me = sc.nextInt();
        int ye = sc.nextInt();
        if(ye > ya)
            System.out.println("0");
        else
        if(ye < ya)
            System.out.println("10000");
        else
        if(me < ma)
            System.out.println(500 * (ma - me));
        else
        if(de < da)
            System.out.println(15 * (da - de));
        else
            System.out.println("0");
    }
}

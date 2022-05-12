// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day0_HelloWorld.java

package pratice.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.Scanner;

public class Day0_HelloWorld
{

    public Day0_HelloWorld()
    {
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();
        scan.close();
        System.out.println("Hello, World.");
        System.out.println(inputString);
    }
}

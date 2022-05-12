// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day1_DataTypes.java

package pratice.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.Scanner;

public class Day1_DataTypes
{

    public Day1_DataTypes()
    {
    }

    public static void main(String args[])
    {
        int i = 4;
        double d = 4D;
        String s = "HackerRank ";
        Scanner scan = new Scanner(System.in);
        String c = "";
        int a = scan.nextInt();
        double b = scan.nextDouble();
        while(scan.hasNextLine()) 
            c = (new StringBuilder()).append(c).append(scan.nextLine()).toString();
        System.out.println(a + i);
        System.out.println(b + d);
        System.out.println((new StringBuilder()).append(s).append(c).toString());
        scan.close();
    }
}

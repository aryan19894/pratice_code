// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day2_Operators.java

package pratice.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.Scanner;

public class Day2_Operators
{

    public Day2_Operators()
    {
    }

    static void solve(double meal_cost, int tip_percent, int tax_percent)
    {
        double total = meal_cost + (meal_cost * (double)tip_percent) / 100D + (meal_cost * (double)tax_percent) / 100D;
        System.out.println(Math.round(total));
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        double c = sc.nextDouble();
        int tip = sc.nextInt();
        int tax = sc.nextInt();
        solve(c, tip, tax);
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GradingSystem.java

package revise.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

import java.io.PrintStream;
import java.util.Scanner;

public class GradingSystem
{

    public GradingSystem()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int marks = scn.nextInt();
        if(marks > 90)
            System.out.println("excellent");
        else
        if(marks > 80 && marks <= 90)
            System.out.println("good");
        else
        if(marks > 70 && marks <= 80)
            System.out.println("fair");
        else
        if(marks > 60 && marks <= 70)
            System.out.println("meets expectations");
        else
            System.out.println("below par");
    }
}

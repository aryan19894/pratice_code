// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IncrementOperators.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

import java.io.PrintStream;

public class IncrementOperators
{

    public IncrementOperators()
    {
    }

    public static void main(String args[])
    {
        int i = 10;
        if(i++ == i)
            System.out.println((new StringBuilder()).append(i).append(" is good").toString());
        else
            System.out.println((new StringBuilder()).append(i).append(" is bad").toString());
        int j = 20;
        if(++j == j)
            System.out.println((new StringBuilder()).append(j).append(" is good").toString());
        else
            System.out.println((new StringBuilder()).append(j).append(" is bad").toString());
    }
}

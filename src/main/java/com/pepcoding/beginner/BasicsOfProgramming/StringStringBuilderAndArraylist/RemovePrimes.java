// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RemovePrimes.java

package com.pepcoding.beginner.BasicsOfProgramming.StringStringBuilderAndArraylist;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class RemovePrimes
{

    public RemovePrimes()
    {
    }

    public static void solution(ArrayList al)
    {
        for(int i = al.size() - 1; i >= 0; i--)
            if(isPrime(((Integer)al.get(i)).intValue()))
                al.remove(i);

    }

    private static boolean isPrime(int n)
    {
        for(int i = 2; i * i <= n; i++)
            if(n % i == 0)
                return false;

        return true;
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList al = new ArrayList();
        for(int i = 0; i < n; i++)
            al.add(Integer.valueOf(scn.nextInt()));

        solution(al);
        System.out.println(al);
    }
}

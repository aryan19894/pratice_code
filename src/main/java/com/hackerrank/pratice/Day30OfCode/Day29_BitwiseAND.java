// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day29_BitwiseAND.java

package com.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.Scanner;

public class Day29_BitwiseAND
{

    public Day29_BitwiseAND()
    {
    }

    public static void main(String args[])
    {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\205])?");
        for(int tItr = 0; tItr < t; tItr++)
        {
            String nk[] = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            if((k - 1 | k) > n && k % 2 == 0)
                System.out.println(k - 2);
            else
                System.out.println(k - 1);
        }

        scanner.close();
    }

    private static final Scanner scanner;

    static 
    {
        scanner = new Scanner(System.in);
    }
}

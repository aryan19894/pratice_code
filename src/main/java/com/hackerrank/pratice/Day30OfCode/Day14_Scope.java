// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day14_Scope.java

package com.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.Scanner;

// Referenced classes of package com.hackerrank.pratice.Day30OfCode:
//            Difference

public class Day14_Scope
{

    public Day14_Scope()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        sc.close();
        Difference difference = new Difference(a);
        difference.computeDifference();
        System.out.print(difference.maximumDifference);
    }
}

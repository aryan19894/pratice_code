// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day4_ClassInstance.java

package com.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.Scanner;

// Referenced classes of package com.hackerrank.pratice.Day30OfCode:
//            Person

public class Day4_ClassInstance
{

    public Day4_ClassInstance()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++)
        {
            int age = sc.nextInt();
            Person p = new Person(age);
            p.amIOld();
            for(int j = 0; j < 3; j++)
                p.yearPasses();

            p.amIOld();
            System.out.println();
        }

        sc.close();
    }
}

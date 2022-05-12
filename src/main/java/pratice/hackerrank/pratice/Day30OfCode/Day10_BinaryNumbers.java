// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day10_BinaryNumbers.java

package pratice.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.Scanner;

public class Day10_BinaryNumbers
{

    public Day10_BinaryNumbers()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        char ch[] = s.toCharArray();
        int max = 0;
        int count = 0;
        for(int i = 0; i < ch.length; i++)
        {
            if(ch[i] == '1')
            {
                count++;
                continue;
            }
            if(max <= count)
                max = count;
            count = 0;
        }

        if(max < count)
        {
            max = count;
            count = 0;
        }
        System.out.println(max);
    }
}

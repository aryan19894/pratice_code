// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DecimalToAnyBase.java

package revise.pepcoding.beginner.BasicsOfProgramming.functionArrays;

import java.io.PrintStream;
import java.util.Scanner;

public class DecimalToAnyBase
{

    public DecimalToAnyBase()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
    }

    public static int getValueInBase(int n, int b)
    {
        int p = 1;
        int bin = 0;
        while(n > 0) 
        {
            int r = n % b;
            bin = p * r + bin;
            n /= b;
            p *= 10;
        }
        return bin;
    }
}

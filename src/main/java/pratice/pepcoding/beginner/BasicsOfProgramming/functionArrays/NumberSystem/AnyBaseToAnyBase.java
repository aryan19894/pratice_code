// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AnyBaseToAnyBase.java

package pratice.pepcoding.beginner.BasicsOfProgramming.functionArrays.NumberSystem;

import java.io.PrintStream;
import java.util.Scanner;

public class AnyBaseToAnyBase
{

    public AnyBaseToAnyBase()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int destBase = scn.nextInt();
        int ans = getValue(n, sourceBase, destBase);
        System.out.println(ans);
    }

    public static int getValue(int n, int nb, int b)
    {
        return getValueInBase(getValueIndecimal(n, nb), b);
    }

    public static int getValueInBase(int n, int b)
    {
        int ans = 0;
        int p = 0;
        for(; n >= 1; n /= b)
        {
            int r = n % b;
            ans = (int)((double)ans + Math.pow(10D, p++) * (double)r);
        }

        return ans;
    }

    public static int getValueIndecimal(int n, int b)
    {
        int ans = 0;
        int p = 0;
        for(; n > 0; n /= 10)
        {
            int r = n % 10;
            ans = (int)((double)ans + Math.pow(b, p++) * (double)r);
        }

        return ans;
    }
}

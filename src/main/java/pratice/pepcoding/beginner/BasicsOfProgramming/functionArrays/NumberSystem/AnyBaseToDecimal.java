// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AnyBaseToDecimal.java

package pratice.pepcoding.beginner.BasicsOfProgramming.functionArrays.NumberSystem;

import java.io.PrintStream;
import java.util.Scanner;

public class AnyBaseToDecimal
{

    public AnyBaseToDecimal()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueIndecimal(n, b);
        System.out.println(dn);
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

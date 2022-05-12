// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AnyBaseMultiplication2.java

package pratice.pepcoding.beginner.BasicsOfProgramming.functionArrays.NumberSystem;

import java.io.PrintStream;
import java.util.Scanner;

public class AnyBaseMultiplication2
{

    public AnyBaseMultiplication2()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int d = getProduct(b, n1, n2);
        System.out.println(d);
    }

    public static int getProduct(int b, int n1, int n2)
    {
        int ans = 0;
        for(int p = 1; n2 > 0; p *= 10)
        {
            int d2 = n2 % 10;
            n2 /= 10;
            int sinAns = getProductWithSingle(b, n1, d2);
            ans = getSum(b, ans, sinAns * p);
        }

        return ans;
    }

    private static int getProductWithSingle(int b, int n1, int d2)
    {
        int ans = 0;
        int p = 1;
        for(int c = 0; n1 > 0 || c > 0;)
        {
            int d1 = n1 % 10;
            n1 /= 10;
            int d = d1 * d2 + c;
            c = d / b;
            d %= b;
            ans += d * p;
            p *= 10;
        }

        return ans;
    }

    private static int getSum(int b, int n1, int n2)
    {
        int ans = 0;
        int p = 0;
        for(int carry = 0; n1 > 0 || n2 > 0 || carry != 0; n2 /= 10)
        {
            int r1 = n1 % 10;
            int r2 = n2 % 10;
            int sum = carry + r1 + r2;
            carry = sum / b;
            int digit = sum % b;
            ans = (int)((double)ans + Math.pow(10D, p++) * (double)digit);
            n1 /= 10;
        }

        return ans;
    }
}

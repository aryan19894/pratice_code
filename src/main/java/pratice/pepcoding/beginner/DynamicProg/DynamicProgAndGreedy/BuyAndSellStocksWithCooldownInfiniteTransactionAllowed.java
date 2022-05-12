// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BuyAndSellStocksWithCooldownInfiniteTransactionAllowed.java

package pratice.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class BuyAndSellStocksWithCooldownInfiniteTransactionAllowed
{

    public BuyAndSellStocksWithCooldownInfiniteTransactionAllowed()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        int obsp = -a[0];
        int ossp = 0;
        int ocsp = 0;
        for(int i = 1; i < n; i++)
        {
            int bsp = Math.max(obsp, ocsp - a[i]);
            int ssp = Math.max(ossp, obsp + a[i]);
            int csp = Math.max(ocsp, ossp);
            obsp = bsp;
            ossp = ssp;
            ocsp = csp;
        }

        System.out.println(ossp);
    }
}

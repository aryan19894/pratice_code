// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BuyAndSellStocksInfiniteTransactionsAllowed.java

package pratice.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class BuyAndSellStocksInfiniteTransactionsAllowed
{

    public BuyAndSellStocksInfiniteTransactionsAllowed()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        int buy;
        int sell = buy = a[0];
        int maxBenefit = sell - buy;
        for(int i = 1; i < n; i++)
            if(a[i - 1] >= a[i])
            {
                maxBenefit += sell - buy;
                buy = sell = a[i];
            } else
            {
                sell = a[i];
            }

        maxBenefit += sell - buy;
        System.out.println(maxBenefit);
    }
}

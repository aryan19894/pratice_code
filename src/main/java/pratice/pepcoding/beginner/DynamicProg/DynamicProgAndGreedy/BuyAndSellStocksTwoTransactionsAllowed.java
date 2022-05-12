// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BuyAndSellStocksTwoTransactionsAllowed.java

package pratice.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class BuyAndSellStocksTwoTransactionsAllowed
{

    public BuyAndSellStocksTwoTransactionsAllowed()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        int dpl[] = new int[n];
        int buy;
        int sell = buy = a[0];
        dpl[0] = sell - buy;
        for(int i = 1; i < n; i++)
        {
            buy = Math.min(buy, a[i]);
            sell = a[i];
            dpl[i] = Math.max(dpl[i - 1], sell - buy);
        }

        int dpr[] = new int[n];
        sell = buy = a[n - 1];
        dpl[n - 1] = sell - buy;
        for(int i = n - 2; i >= 0; i--)
        {
            buy = a[i];
            sell = Math.max(sell, a[i + 1]);
            dpr[i] = Math.max(dpr[i + 1], sell - buy);
        }

        int maxBen = 0;
        for(int i = 0; i < n; i++)
            maxBen = Math.max(maxBen, dpl[i] + dpr[i]);

        System.out.println(maxBen);
    }
}

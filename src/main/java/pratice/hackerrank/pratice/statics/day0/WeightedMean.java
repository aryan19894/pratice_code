// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeightedMean.java

package pratice.hackerrank.pratice.statics.day0;

import java.io.PrintStream;
import java.util.Scanner;

public class WeightedMean
{

    public WeightedMean()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double a[] = new double[n];
        int w[] = new int[n];
        double sum = 0.0D;
        for(int i = 0; i < n; i++)
            a[i] = in.nextDouble();

        double sumWeight = 0.0D;
        for(int i = 0; i < n; i++)
        {
            int we = in.nextInt();
            sum += a[i] * (double)we;
            sumWeight += we;
        }

        System.out.printf("%.1f", new Object[] {
            Double.valueOf(sum / sumWeight)
        });
    }
}

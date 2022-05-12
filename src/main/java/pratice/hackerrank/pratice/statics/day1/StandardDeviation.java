// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StandardDeviation.java

package pratice.hackerrank.pratice.statics.day1;

import java.io.PrintStream;
import java.util.Scanner;

public class StandardDeviation
{

    public StandardDeviation()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double a[] = new double[n];
        double sum = 0.0D;
        for(int i = 0; i < n; i++)
        {
            double ip = in.nextDouble();
            a[i] = ip;
            sum += ip;
        }

        double mean = sum / (double)n;
        sum = 0.0D;
        for(int i = 0; i < n; i++)
            sum += Math.pow(a[i] - mean, 2D);

        System.out.printf("%.1f", new Object[] {
            Double.valueOf(Math.sqrt(sum / (double)n))
        });
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MeanMedianMode.java

package com.hackerrank.pratice.statics.day0;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.*;

public class MeanMedianMode
{

    public MeanMedianMode()
    {
    }

    public static void main(String args[])
    {
        DecimalFormat df = new DecimalFormat("#.#");
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

        System.out.println(df.format(sum / (double)n));
        Arrays.sort(a);
        double median;
        if(n % 2 == 0)
            median = (a[n / 2 - 1] + a[n / 2]) / 2D;
        else
            median = a[n / 2 - 1];
        System.out.println(df.format(median));
        Map map = new LinkedHashMap();
        for(int i = 0; i < n; i++)
            if(map.containsKey(Double.valueOf(a[i])))
                map.replace(Double.valueOf(a[i]), Integer.valueOf(((Integer)map.get(Double.valueOf(a[i]))).intValue() + 1));
            else
                map.put(Double.valueOf(a[i]), Integer.valueOf(1));

        int maxValueInMap = ((Integer)Collections.max(map.values())).intValue();
        Iterator iterator = map.entrySet().iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if(((Integer)entry.getValue()).intValue() != maxValueInMap)
                continue;
            System.out.println(entry.getKey());
            break;
        } while(true);
    }
}

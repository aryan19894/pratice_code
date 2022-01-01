// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaBigDecimal.java

package com.hackerrank.pratice.java.BigNumber;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.*;

public class JavaBigDecimal
{

    public JavaBigDecimal()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s[] = new String[n + 2];
        for(int i = 0; i < n; i++)
            s[i] = sc.next();

        sc.close();
        Comparator customComparator = new Comparator() {

            public int compare(String s1, String s2)
            {
                BigDecimal a = new BigDecimal(s1);
                BigDecimal b = new BigDecimal(s2);
                return b.compareTo(a);
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((String)obj, (String)obj1);
            }

        }
;
        Arrays.sort(s, 0, n, customComparator);
        for(int i = 0; i < n; i++)
            System.out.println(s[i]);

    }
}

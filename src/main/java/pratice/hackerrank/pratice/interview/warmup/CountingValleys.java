// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CountingValleys.java

package pratice.hackerrank.pratice.interview.warmup;

import java.io.PrintStream;
import java.util.Scanner;

public class CountingValleys
{

    public CountingValleys()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int sea = countingValleys(n, s);
        System.out.println(sea);
    }

    static int countingValleys(int n, String s)
    {
        char ch[] = s.toCharArray();
        int level = 0;
        int valley = 0;
        char ac[] = ch;
        int i = ac.length;
        for(int j = 0; j < i; j++)
        {
            char c = ac[j];
            if(c == 'U')
            {
                level++;
                continue;
            }
            if(c != 'D')
                continue;
            if(level == 0)
                valley++;
            level--;
        }

        return valley;
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SpecialStringAgain2.java

package pratice.hackerrank.pratice.interview.String;

import java.io.PrintStream;
import java.util.Scanner;

public class SpecialStringAgain2
{

    public SpecialStringAgain2()
    {
    }

    static long substrCount(int n, String s)
    {
        long specials = n;
        int i = 0;
        int j;
        for(j = 1; j < n; j++)
        {
            if(s.charAt(i) == s.charAt(j))
                continue;
            int repeatedCharStringLen = j - i;
            specials += repeatedCharStringLen - 1;
            int newStringAfterSpecialIdx = j + 1 + repeatedCharStringLen;
            if(j + 1 < n && newStringAfterSpecialIdx <= n && s.substring(i, j).equals(s.substring(j + 1, newStringAfterSpecialIdx)))
                specials++;
            j = ++i;
        }

        specials += substringsInLen(j - i) - (long)(j - i);
        return specials;
    }

    private static long substringsInLen(int len)
    {
        if(len <= 0)
            return 0L;
        else
            return (long)((len * (len + 1)) / 2);
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String a = in.next();
        System.out.println(substrCount(n, a));
    }
}

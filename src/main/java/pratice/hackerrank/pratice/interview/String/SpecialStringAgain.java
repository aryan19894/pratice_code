// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SpecialStringAgain.java

package pratice.hackerrank.pratice.interview.String;

import java.io.PrintStream;
import java.util.Scanner;

public class SpecialStringAgain
{

    public SpecialStringAgain()
    {
    }

    static long substrCount(int n, String s)
    {
        long res = 0L;
        char ch[] = s.toCharArray();
        for(int i = 0; i < n; i++)
        {
label0:
            for(int j = i + 1; j <= n; j++)
            {
                if(ch[i] != ch[j])
                {
                    int k = j + 1;
                    do
                    {
                        if(k >= n)
                            continue label0;
                        if(ch[k] != ch[--j] || j >= i)
                            break label0;
                        res++;
                        k++;
                    } while(true);
                }
                res++;
            }

        }

        return res;
    }

    private static boolean isPalindrom(String s)
    {
        String reverse = (new StringBuffer(s)).reverse().toString();
        return s.equals(reverse);
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String a = in.next();
        System.out.println(substrCount(n, a));
    }
}

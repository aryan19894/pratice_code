// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StringCompression.java

package pratice.pepcoding.beginner.BasicsOfProgramming.StringStringBuilderAndArraylist;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Scanner;

public class StringCompression
{

    public StringCompression()
    {
    }

    public static String compression1(String str)
    {
        String ans = (new StringBuilder()).append("").append(str.charAt(0)).toString();
        for(int i = 1; i < str.length(); i++)
            if(str.charAt(i - 1) != str.charAt(i))
                ans = (new StringBuilder()).append(ans).append(str.charAt(i)).toString();

        return ans;
    }

    public static String compression2(String str)
    {
        String ans = (new StringBuilder()).append("").append(str.charAt(0)).toString();
        int freq = 1;
        for(int i = 1; i < str.length(); i++)
        {
            char prev = str.charAt(i - 1);
            char curr = str.charAt(i);
            if(prev == curr)
            {
                freq++;
            } else
            {
                ans = (new StringBuilder()).append(ans).append(freq <= 1 ? "" : ((Object) (Integer.valueOf(freq)))).toString();
                ans = (new StringBuilder()).append(ans).append(curr).toString();
                freq = 1;
            }
        }

        if(freq > 1)
            ans = (new StringBuilder()).append(ans).append(freq == 1 ? "" : ((Object) (Integer.valueOf(freq)))).toString();
        return ans;
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(compression1(str));
        System.out.println(compression2(str));
    }
}

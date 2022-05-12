// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrintAllPalindromicSubstrings.java

package pratice.pepcoding.beginner.BasicsOfProgramming.StringStringBuilderAndArraylist;

import java.io.PrintStream;
import java.util.Scanner;

public class PrintAllPalindromicSubstrings
{

    public PrintAllPalindromicSubstrings()
    {
    }

    public static void solution(String str)
    {
        for(int i = 0; i < str.length(); i++)
        {
            for(int j = i + 1; j <= str.length(); j++)
            {
                String sub = str.substring(i, j);
                if(isPalindrome(sub))
                    System.out.println(sub);
            }

        }

    }

    private static boolean isPalindrome(String sub)
    {
        int i = 0;
        for(int j = sub.length() - 1; i <= j; j--)
        {
            if(sub.charAt(i) != sub.charAt(j))
                return false;
            i++;
        }

        return true;
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }
}

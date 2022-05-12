// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StringWithDifferenceOfEveryTwoConsecutiveCharacters.java

package pratice.pepcoding.beginner.BasicsOfProgramming.StringStringBuilderAndArraylist;

import java.io.PrintStream;
import java.util.Scanner;

public class StringWithDifferenceOfEveryTwoConsecutiveCharacters
{

    public StringWithDifferenceOfEveryTwoConsecutiveCharacters()
    {
    }

    public static String solution(String str)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for(int i = 1; i < str.length(); i++)
        {
            sb.append(str.charAt(i) - str.charAt(i - 1));
            sb.append(str.charAt(i));
        }

        return new String(sb);
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}

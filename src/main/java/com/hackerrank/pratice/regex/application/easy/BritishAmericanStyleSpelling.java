// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BritishAmericanStyleSpelling.java

package com.hackerrank.pratice.regex.application.easy;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BritishAmericanStyleSpelling
{

    public BritishAmericanStyleSpelling()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String text = readText(sc, N);
        int T = sc.nextInt();
        for(int tc = 0; tc < T; tc++)
        {
            String w = sc.next();
            String regex = (new StringBuilder(String.valueOf(w))).append("|").append(w.substring(0, w.length() - 2)).append("se").toString();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            int result;
            for(result = 0; matcher.find(); result++);
            System.out.println(result);
        }

        sc.close();
    }

    static String readText(Scanner sc, int N)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++)
        {
            sb.append(sc.nextLine());
            sb.append("\n");
        }

        return sb.toString();
    }
}
